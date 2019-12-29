package com.konstantinbulygin.tasklistapp;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static NotesDatabase mainViewModelDatabase;
    private LiveData<List<Note>> mainViewModelLiveDataNotes;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mainViewModelDatabase = NotesDatabase.getInstance(getApplication());
        mainViewModelLiveDataNotes = mainViewModelDatabase.notesDao().getAllNotes();
    }

    public LiveData<List<Note>> getMainViewModelLiveDataNotes() {
        return mainViewModelLiveDataNotes;
    }

    public void insertNote(Note note) {
        new InsertTask().execute(note);
    }

    public void deleteNote(Note note) {
        new DeleteTask().execute(note);
    }

    public void deleteAllNote() {
        new DeleteAllTask().execute();
    }

    private static class InsertTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... notes) {
            if (notes != null && notes.length > 0) {
                mainViewModelDatabase.notesDao().insertNote(notes[0]);
            }
            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... notes) {
            if (notes != null && notes.length > 0) {
                mainViewModelDatabase.notesDao().deleteNote(notes[0]);
            }
            return null;
        }
    }

    private static class DeleteAllTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void...notes) {
            mainViewModelDatabase.notesDao().deleteAllNotes();
            return null;
        }
    }
}
