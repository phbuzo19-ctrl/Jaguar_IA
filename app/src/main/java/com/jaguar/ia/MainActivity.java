package com.jaguar.ia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputQuestion;
    private Button btnAsk;
    private TextView outputAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputQuestion = findViewById(R.id.inputQuestion);
        btnAsk = findViewById(R.id.btnAsk);
        outputAnswer = findViewById(R.id.outputAnswer);

        btnAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pergunta = inputQuestion.getText().toString().trim();

                if (pergunta.isEmpty()) {
                    outputAnswer.setText("Digite uma pergunta.");
                } else {
                    // RESPOSTA TEMPORÁRIA (base para IA)
                    outputAnswer.setText("Você perguntou:\n\n" + pergunta);
                }
            }
        });
    }
}
