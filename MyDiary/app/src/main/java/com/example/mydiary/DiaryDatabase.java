package com.example.mydiary;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Diary.class},version = 4)
public abstract class DiaryDatabase extends RoomDatabase {
    abstract DiaryDao1 diaryDao();
}
