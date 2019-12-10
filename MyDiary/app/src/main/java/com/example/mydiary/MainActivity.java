package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btnDisplayAddScreen;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDisplayAddScreen = findViewById(R.id.add);
        btnDisplayAddScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAddScreen();
            }
        });
    }

    private void openAddScreen() {
        EditText addDiary;
        String data;
        addDiary = findViewById(R.id.addDiary);
        data = addDiary.getText().toString();
        Intent intent = new Intent(MainActivity.this, AddDiary.class);
        intent.putExtra("key", data);
        startActivity(intent);
    }
}
