package com.iot.a20220711_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<String>();
        for (int i = 0; i < 201; i++) arrayList.add("list"+i);

        listView = (ListView)findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        EditText editText = (EditText)findViewById(R.id.editText);
        Button createButton = findViewById(R.id.createButton);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = arrayList.size();
                arrayList.add("test"+number);
                adapter.notifyDataSetChanged();

                if (number>0)
                    listView.setSelection(number-1);

                editText.setText("");
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(0);
                adapter.notifyDataSetChanged();
                listView.setSelection(0);
            }
        });
    }
}