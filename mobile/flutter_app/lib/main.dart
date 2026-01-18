import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

void main() {
  runApp(const JaguarApp());
}

class JaguarApp extends StatelessWidget {
  const JaguarApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Jaguar IA',
      theme: ThemeData(
        brightness: Brightness.dark,
        primaryColor: Colors.blue,
        scaffoldBackgroundColor: Colors.black,
        textTheme: const TextTheme(
          bodyMedium: TextStyle(color: Colors.white),
        ),
      ),
      home: const HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final controller = TextEditingController();
  String resposta = "";

  Future<void> perguntar() async {
    final r = await http.get(
      Uri.parse(
        "http://127.0.0.1:8000/perguntar?q=${controller.text}",
      ),
    );
    setState(() {
      resposta = jsonDecode(r.body).toString();
    });
  }

  Future<void> diagnosticar() async {
    final r = await http.get(
      Uri.parse(
        "http://127.0.0.1:8000/diagnosticar?sintoma=${controller.text}",
      ),
    );
    setState(() {
      resposta = jsonDecode(r.body).toString();
    });
  }

  Future<void> enviarComando() async {
    await http.post(
      Uri.parse(
        "http://127.0.0.1:8000/comando?dispositivo=rele1&acao=ligar",
      ),
    );
    setState(() {
      resposta = "Comando enviado com sucesso";
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Jaguar IA")),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(
              controller: controller,
              style: const TextStyle(color: Colors.white),
              decoration: const InputDecoration(
                hintText: "Digite a pergunta ou falha",
                hintStyle: TextStyle(color: Colors.white54),
              ),
            ),
            const SizedBox(height: 12),
            ElevatedButton(
              onPressed: perguntar,
              child: const Text("Perguntar"),
            ),
            ElevatedButton(
              onPressed: diagnosticar,
              child: const Text("Diagnosticar"),
            ),
            ElevatedButton(
              onPressed: enviarComando,
              child: const Text("Enviar Comando"),
            ),
            const SizedBox(height: 20),
            Text(resposta),
          ],
        ),
      ),
    );
  }
}
