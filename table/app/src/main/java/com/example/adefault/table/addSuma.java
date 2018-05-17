package com.example.adefault.table;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addSuma extends AppCompatActivity {

    ListView listView;
    Button open;
    Button btnAddData;
    Databasehepler myDb;

    String strDate;
    String Data;
    String getItem;
    EditText editSuma, editOther;
    TextView editWhat;
    TextView textData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_suma);
        myDb = new Databasehepler(this);

        open = (Button) findViewById(R.id.open);
        btnAddData = (Button) findViewById(R.id.add);

        editSuma = (EditText) findViewById(R.id.suma);
        editWhat = (TextView) findViewById(R.id.etCost);
        editOther = (EditText) findViewById(R.id.opisanie);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
        strDate = mdformat.format(calendar.getTime());
        textData = (TextView) findViewById(R.id.dataview);
        textData.setText(strDate);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), open);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(), "" + item.getTitle(), Toast.LENGTH_LONG).show();
                        editWhat.setText("Разход за " + item.getTitle());
                        getItem = item.getTitle().toString();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        AddData();
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(textData.getText().toString(), editSuma.getText().toString(), getItem, editOther.getText().toString());

                        if(isInserted == true){
                            Toast.makeText(addSuma.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(addSuma.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
