package com.example.mydiary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class AddDiary extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView rvDiary;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_diary);
        rvDiary = findViewById(R.id.recycle_diary);
        rvDiary.setLayoutManager(new LinearLayoutManager(this));

        final DiaryAdapter adapter = new DiaryAdapter();
        rvDiary.setAdapter(adapter);

        final DiaryDatabase db = Room.databaseBuilder(getApplicationContext(),
                DiaryDatabase.class, "database-name").build();

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                String data;
                Intent myIntent = getIntent(); // this is just for example purpose
                data = myIntent.getStringExtra("key");
                Log.d("haha", data);
                Diary diary = new Diary(data);
                db.diaryDao().insert(diary);
                List<Diary> diaries = db.diaryDao().getAll();
                final List<String> diaryData1 = new ArrayList<>();
                for (int i = 0; i < diaries.size(); i++) {
                    diaryData1.add(diaries.get(i).getNote());
                }
                Log.d("haha1", String.valueOf(diaryData1));
                adapter.data = diaryData1;
                return null;
            }
        }.execute();
    }
}