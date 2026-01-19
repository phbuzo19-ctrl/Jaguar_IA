package com.jaguar.ia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText inputPergunta = findViewById(R.id.inputPergunta);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        TextView txtResposta = findViewById(R.id.txtResposta);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pergunta = inputPergunta.getText().toString().trim();

                if (pergunta.isEmpty()) {
                    txtResposta.setText("Digite uma pergunta 🐆");
                } else {
                    txtResposta.setText("Jaguar IA recebeu:\n\n" + pergunta);
                }
            }
        });
    }
}
