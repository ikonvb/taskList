package com.konstantinbulygin.tasklistapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);

        notes.add(new Note("BarberShop", "Make hair", "Monday", 2));
        notes.add(new Note("Shop", "Buy bread", "Tuesday", 2));
        notes.add(new Note("Work", "Work", "Wednesday", 1));
        notes.add(new Note("Walk", "Go for a walk", "Friday", 3));
        notes.add(new Note("Buy food", "Buy a lot of food", "Saturday", 2));
        notes.add(new Note("Celebrate", "Celebrate the new year", "Sunday", 1));

        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);
    }
}
