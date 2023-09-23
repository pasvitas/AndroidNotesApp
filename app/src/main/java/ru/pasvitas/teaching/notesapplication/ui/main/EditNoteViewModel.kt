package ru.pasvitas.teaching.notesapplication.ui.main

import androidx.lifecycle.ViewModel
import ru.pasvitas.teaching.notesapplication.NoteApplication
import ru.pasvitas.teaching.notesapplication.model.INoteUseCase
import ru.pasvitas.teaching.notesapplication.model.Note
import java.util.*

class EditNoteViewModel : ViewModel() {

    private lateinit var noteUseCase : INoteUseCase

    fun init(application: NoteApplication) {
        noteUseCase = application.getNoteUseCase()
    }

    suspend fun saveData(id: Long?, title: String, text: String) {
        noteUseCase.saveNote(
            Note(
                id = id,
                title = title,
                text = text
            )
        )
    }

    suspend fun deleteData(id: Long) {
        noteUseCase.deleteNote(id)
    }
}