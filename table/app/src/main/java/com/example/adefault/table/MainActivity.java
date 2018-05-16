package com.example.adefault.table;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TableLayout tLayout;
    TableRow tRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tLayout = (TableLayout)findViewById(R.id.table);
        tLayout.setColumnCollapsed(0, true);
        tLayout.setColumnCollapsed(1, true);

        tRow = new TableRow(this);
        TextView t= new TextView(this);
        TextView t1= new TextView(this);
        t.setText("adefsg");
        t.setTextSize(15);
        t.setGravity(Gravity.CENTER);
        t1.setText("adefsg");
        t1.setTextSize(15);
        t1.setGravity(Gravity.CENTER);
        tRow.addView(t);
        tRow.addView(t1);
        tLayout.addView(tRow);

    }
}
