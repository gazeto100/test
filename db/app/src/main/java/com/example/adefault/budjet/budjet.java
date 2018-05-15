package com.example.adefault.budjet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class budjet extends AppCompatActivity {

    Databasehepler smetkidb;
    Button btnIncome = (Button) findViewById(R.id.income);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budjet);
        smetkidb = new Databasehepler(this);

        btnIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
