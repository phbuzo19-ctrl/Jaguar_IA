package com.jaguaria.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputQuestion;
    Button btnAsk;
    TextView outputAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputQuestion = findViewById(R.id.inputQuestion);
        btnAsk = findViewById(R.id.btnAsk);
        outputAnswer = findViewById(R.id.outputAnswer);

        btnAsk.setOnClickListener(v -> {
            String question = inputQuestion.getText().toString();
            outputAnswer.setText("Jaguaria diz: " + question);
        });
    }
}
