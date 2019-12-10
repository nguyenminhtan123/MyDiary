package com.example.mydiary;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DiaryDao1 {
    @Query("SELECT * from diary")
    List<Diary> getAll();

    @Insert
    void insert(Diary user);
}
