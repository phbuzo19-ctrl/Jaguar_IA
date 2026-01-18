package com.jaguar.ia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("Jaguar IA ATIVA 🐆🚀");
        tv.setTextSize(24);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(40, 80, 40, 40);

        setContentView(tv);
    }
}
