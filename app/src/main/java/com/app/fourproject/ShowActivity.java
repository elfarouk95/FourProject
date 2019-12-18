package com.app.fourproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    TextView name;
    TextView phone;
    TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        name = findViewById(R.id.Name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.addres);

        Intent n = getIntent();
        int x = n.getIntExtra("index", 0);

        Person s = MainActivity.names.get(x);
        name.setText(s.name);
        phone.setText(s.phone);
        address.setText(s.address);

    }

    public void Delete(View view) {
        Intent n = getIntent();
        int x = n.getIntExtra("index", 0);
        MainActivity.names.remove(x);
        finish();
    }
}
