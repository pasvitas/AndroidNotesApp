package ru.pasvitas.teaching.notesapplication.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ru.pasvitas.teaching.notesapplication.NoteApplication
import ru.pasvitas.teaching.notesapplication.model.INoteUseCase
import ru.pasvitas.teaching.notesapplication.model.Note
import ru.pasvitas.teaching.notesapplication.model.NoteUseCase

class MainViewModel : ViewModel() {

    private lateinit var noteUseCase: INoteUseCase

    fun getAllNotes() : LiveData<List<Note>> =
        liveData {
            emit(noteUseCase.getAllNotes());
        }


    fun init(application: NoteApplication) {
        noteUseCase = application.getNoteUseCase()
    }

}