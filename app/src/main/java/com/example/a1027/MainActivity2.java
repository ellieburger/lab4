package com.example.a1027;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private RadioGroup for_sweetness, for_ice;
    private TextView drink;
    private String sweetness;
    private String ice;
    private EditText input_drink;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        for_sweetness = findViewById(R.id.for_sweetness);
        for_sweetness.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.no_sweet) {
                sweetness = "無糖";
            } else if (i == R.id.less_sweet) {
                sweetness = "少糖";
            } else if (i == R.id.half_sweet) {
                sweetness = "半糖";
            } else if (i == R.id.full_sweet) {
                sweetness = "全糖";
            }
        });
        for_ice = findViewById(R.id.for_ice);
        for_ice.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.no_ice) {
                ice = "無冰";
            } else if (i == R.id.little_ice) {
                ice = "微冰";
            } else if (i == R.id.less_ice) {
                ice = "少冰";
            } else if (i == R.id.normal_ice) {
                ice = "正常冰";
            }
        });
        send = findViewById(R.id.send);
        send.setOnClickListener(view -> {
            input_drink = findViewById(R.id.input_drink);
            String drink = input_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink", drink);
            b.putString("sweetness", sweetness);
            b.putString("ice", ice);
            i.putExtras(b);
            setResult(Activity.RESULT_OK,i);
            finish();
        });
    }
}