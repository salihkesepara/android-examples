package com.example.kesepara.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtName, edtSurname, edtPhone;
    private Button btnSave, btnList, btnDelete, btnEdit;
    private ListView lvUsers;
    private int selectedId = -1;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* define fields */
        edtName = (EditText) findViewById(R.id.edtName);
        edtSurname = (EditText) findViewById(R.id.edtSurname);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnList = (Button) findViewById(R.id.btnList);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        lvUsers = (ListView) findViewById(R.id.lvUsers);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String surname = edtSurname.getText().toString();
                String phone = edtPhone.getText().toString();

                Db db = new Db(context);
                db.addRow(name, surname, phone);
                getList();
                clearForm();
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getList();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedId != -1) {
                    Db db = new Db(context);
                    db.deleteRow(selectedId);
                    getList();
                    clearForm();
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String surname = edtSurname.getText().toString();
                String phone = edtPhone.getText().toString();

                Db db = new Db(context);
                db.updateRow(selectedId, name, surname, phone);
                getList();
            }
        });

        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /* get the selected item */
                String selectedItem = lvUsers.getItemAtPosition(position).toString();

                String[] splitedItem = selectedItem.split(" - ");

                /* get id */
                selectedId = Integer.valueOf(splitedItem[0]);

                edtName.setText(splitedItem[1]);
                edtSurname.setText(splitedItem[2]);
                edtPhone.setText(splitedItem[3]);
            }
        });

        getList();
    }

    public void getList() {
        Db db = new Db(context);
        List<String> list = db.getList();
        System.out.println("List: " + list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        lvUsers.setAdapter(adapter);

    }

    public void clearForm() {
        edtName.setText("");
        edtSurname.setText("");
        edtPhone.setText("");
    }
}
