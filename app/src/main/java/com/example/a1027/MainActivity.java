package com.example.a1027;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView order, dcheck, drink, ice, sweetness;
    private Button choose_menu;

    private final ActivityResultLauncher<Intent> mStartForResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    if (intent != null && intent.getExtras() != null) {
                        Bundle b = intent.getExtras();
                        String str1 = b.getString("drink");
                        String str2 = b.getString("sweetness");
                        String str3 = b.getString("ice");
                        drink.setText(String.format(str1));
                        sweetness.setText(String.format(str2));
                        ice.setText(String.format(str3));
                    }
                }
            });

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order = findViewById(R.id.order);
        choose_menu = findViewById(R.id.choose_menu);
        dcheck = findViewById(R.id.dcheck);
        drink = findViewById(R.id.drink);
        ice = findViewById(R.id.ice);
        sweetness = findViewById(R.id.sweetness);

        choose_menu.setOnClickListener(view -> {
            mStartForResult.launch(
                    new Intent(this, MainActivity2.class)
            );
        });
    }
}