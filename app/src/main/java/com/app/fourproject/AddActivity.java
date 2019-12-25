package com.app.fourproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText Name;
    EditText Phone;
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Name = findViewById(R.id.Name);
        Phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
    }

    public void AddPerson(View view) {

        DBHelper db = new DBHelper(this); // ----->

        String n = Name.getText().toString();
        String p = Phone.getText().toString();
        String a = address.getText().toString();

        Person person = new Person(n, p, a);

        db.InsertPerson(person); // ----->

        MainActivity.names.add(person);
        finish();
    }
}
