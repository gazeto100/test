package com.example.adefault.table;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TableLayout table;
    TableRow tr;
    Databasehepler myDb;
    Button addCost, accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new Databasehepler(this);

        addCost = (Button)findViewById(R.id.cost);
        accounts = (Button) findViewById(R.id.accounts);

        addCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        accounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountsActivity();;
            }
        });


        table = (TableLayout)findViewById(R.id.table);


        for(int i = 0; i < 2; i++){

            tr =  new TableRow(this);
            for(int j = 0; j < 5; j++) {
                TextView t = new TextView(this);
                t.setText("d |");
                tr.addView(t);
            }
            table.addView(tr);
        }
    }



    public void openActivity(){
        Intent intent = new Intent(this, addSuma.class);
        startActivity(intent);
    }

    public void openAccountsActivity(){
        Intent intent = new Intent(this, accounts.class);
        startActivity(intent);
    }
}
