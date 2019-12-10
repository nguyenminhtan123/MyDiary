package com.example.mydiary;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Diary {
    @PrimaryKey(autoGenerate = true)
    public int id;
    String note;

    public String getNote() {
        return note;
    }
    public void setNote(String note){
        this.note=note;
    }
    public Diary(String note) {
        this.note=note;
    }
}
