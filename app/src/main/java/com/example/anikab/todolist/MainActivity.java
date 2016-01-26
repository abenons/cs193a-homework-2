package com.example.anikab.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ArrayList<String> actionInputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionInputs = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                actionInputs
        );

        ListView toDoList = (ListView) findViewById(R.id.toDoList);
        toDoList.setAdapter(adapter);

        //To-do actions inputted by the user are added to the To-Do list
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText actionInput = (EditText) findViewById(R.id.action);

                String action = actionInput.getText().toString();
                actionInputs.add(action);
                adapter.notifyDataSetChanged();
            }
        });

        //If the user long clicks on an item, it is removed
        toDoList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                actionInputs.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}
