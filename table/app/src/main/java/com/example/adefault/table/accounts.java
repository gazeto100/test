package com.example.adefault.table;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class accounts extends AppCompatActivity {

    TableLayout showTable;
    Databasehepler myDb;
    TableRow row;
    Cursor cursor;
    TableRow rowHeader;
    TextView currentSum;

    float m_CurrentSum = 0;
    float plusSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        myDb = new Databasehepler(this);
        showTable = (TableLayout) findViewById(R.id.showTable);

        currentSum = (TextView) findViewById(R.id.currentSum);

        rowHeader = new TableRow(this);
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));

        showTable();
    }


    public void GetRow(final int id, final String Data, final String Suma, final String What){
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CharSequence colors[] = new CharSequence[] {"Редактиране", "Изтриване"};

                AlertDialog.Builder builder = new AlertDialog.Builder(accounts.this);

                builder.setTitle("Запис: " + Data + " " + Suma + " " + What);

                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // the user clicked on colors[which]
                        switch (which){
                            case 0:
                                break;

                            case 1:
                                String idRecord = Integer.toString(id);
                                Integer deleteRow = myDb.deleteData(idRecord);
                                showTable.removeAllViews();
                                rowHeader.removeAllViews();
                                m_CurrentSum = 0;
                                showTable();

                                break;
                            default:
                                break;
                        }


                    }
                });

                builder.show();
            }
        });
    }


    public void showTable() {

        String[] headerText = {"Дата", "Сума", "За какво"};

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
            String selectQuery = "SELECT * FROM "+ myDb.TABLE_NAME +" ORDER BY "+ myDb.ID +" DESC";
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

                    plusSum = Float.parseFloat(suma);
                    m_CurrentSum = m_CurrentSum + plusSum;

                    row = new TableRow(this);

                    if (count %2 == 0){
                        row.setBackgroundColor(Color.WHITE);
                    }else {

                    }

                    String[] colText={data,suma,what};
                    for(String text:colText) {
                        TextView tv = new TextView(this);
                        tv.setTextSize(14);
                        tv.setPadding(5, 10, 5, 5);
                        tv.setText(text);
                        row.addView(tv);
                    }

                    showTable.addView(row);
                    GetRow(id, data, suma, what);
                    count++;
                }
            }

            if (m_CurrentSum < 0){
                currentSum.setTextColor(Color.RED);
            }else {
                currentSum.setTextColor(Color.BLACK);
            }
            currentSum.setText("Разполагаема сума: "+Float.toString(m_CurrentSum)+" лв.");

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

    public void currentSum(){

    }
}
