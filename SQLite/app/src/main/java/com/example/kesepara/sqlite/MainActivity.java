package com.example.kesepara.sqlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtName, edtSurname, edtPhone;
    private Button btnSave, btnList, btnDelete, btnEdit;
    private ListView lvUsers;
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
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getList();
            }
        });
    }

    public void getList() {
        Db db = new Db(context);
        List<String> list = db.getList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        lvUsers.setAdapter(adapter);

    }
}
