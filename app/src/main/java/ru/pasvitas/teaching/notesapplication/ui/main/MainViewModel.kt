package ru.pasvitas.teaching.notesapplication.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.pasvitas.teaching.notesapplication.NoteApplication
import ru.pasvitas.teaching.notesapplication.model.INoteUseCase
import ru.pasvitas.teaching.notesapplication.model.Note
import ru.pasvitas.teaching.notesapplication.model.NoteUseCase

class MainViewModel : ViewModel() {

    val noteLiveData: MutableLiveData<List<Note>> = MutableLiveData()

    private lateinit var noteUseCase: INoteUseCase

    fun getAllNotes() {
        noteLiveData.postValue(noteUseCase.getAllNotes())
    }

    fun init(application: NoteApplication) {
        noteUseCase = application.getNoteUseCase()
    }

}