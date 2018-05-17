package com.example.adefault.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class accounts extends AppCompatActivity {

    TableLayout showTable;
    Databasehepler myDb;
    TableRow row;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        myDb = new Databasehepler(this);


        showTable = (TableLayout) findViewById(R.id.showTable);


        TableRow rowHeader = new TableRow(this);
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));

//        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
//                TableLayout.LayoutParams.WRAP_CONTENT));

        String[] headerText = {"Дата", "За какво", "Сума"};

        for (String c : headerText) {
            TextView tv = new TextView(this);
//            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
//                    TableRow.LayoutParams.WRAP_CONTENT));
//            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(20, 5, 20, 5);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        showTable.addView(rowHeader);

        SQLiteDatabase db = myDb.getReadableDatabase();

        db.beginTransaction();
        try
        {
        String selectQuery = "SELECT * FROM "+ myDb.TABLE_NAME;
        cursor = db.rawQuery(selectQuery,null);

        if(cursor.getCount() >0)
        {
            int count = 0;
            while (cursor.moveToNext()) {

                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String data= cursor.getString(cursor.getColumnIndex("DATA"));
                String suma= cursor.getString(cursor.getColumnIndex("SUMA"));
                String what= cursor.getString(cursor.getColumnIndex("WHAT"));
                //String other= cursor.getString(cursor.getColumnIndex("OTHER"));

                row = new TableRow(this);

                if (count %2 == 0){
                    row.setBackgroundColor(Color.WHITE);
                }else {

                }

//                row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
//                        TableLayout.LayoutParams.MATCH_PARENT));
                String[] colText={data,suma,what};
                for(String text:colText) {
                    TextView tv = new TextView(this);
//                    tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
//                            TableRow.LayoutParams.MATCH_PARENT));
//                    tv.setGravity(Gravity.CENTER);
                    tv.setTextSize(14);
                    tv.setPadding(5, 10, 5, 5);
                    tv.setText(text);
                    row.addView(tv);
                }
                showTable.addView(row);
                GetRow(id);
                count++;
            }
        }
        db.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            e.printStackTrace();

        }
        finally
        {
            db.endTransaction();
            // End the transaction.
            db.close();
            // Close database
        }
    }


    public void GetRow(final int id){
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GRAY);
                String testString = Integer.toString(id);
                Integer deleteRow = myDb.deleteData(testString);
                //myDb.onUpgrade(myDb, 1, 1);

                Toast.makeText(accounts.this, "Row clicked: " + v.getId(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
