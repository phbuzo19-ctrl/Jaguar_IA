package com.jaguar.ia;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.parseColor("#121212"));

        TextView tv = new TextView(this);
        tv.setText("Jaguar IA em espera...");
        tv.setTextSize(24);
        tv.setTextColor(Color.WHITE);
        tv.setPadding(0, 0, 0, 40);

        Button btn = new Button(this);
        btn.setText("Ativar Jaguar 🐆");

        btn.setOnClickListener(v -> {
            tv.setText("Jaguar IA ATIVA 🚀");
        });

        layout.addView(tv);
        layout.addView(btn);

        setContentView(layout);
    }
}
