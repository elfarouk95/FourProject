package com.app.fourproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    static ArrayList<Person> names = new ArrayList<>();

    ArrayAdapter<Person> adapter;

    static {
        names.add(new Person("a", "0", "a"));
        names.add(new Person("a1", "01", "a1"));
        names.add(new Person("a2", "02", "a2"));
        names.add(new Person("a3", "03", "a3"));
        names.add(new Person("a4", "04", "a4"));
        names.add(new Person("a5", "04", "a5"));
        names.add(new Person("a6", "04", "a6"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        adapter = new ArrayAdapter<>(this, R.layout.item, R.id.nm, names);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                show(position);
            }
        });


    }

    private void show(int position) {
        Intent n = new Intent(this, ShowActivity.class);
        n.putExtra("index", position);
        startActivity(n);
    }

    public void Add(View view) {

        Intent n = new Intent(this, AddActivity.class);
        startActivity(n);
    }
}
