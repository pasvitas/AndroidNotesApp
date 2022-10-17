package ru.pasvitas.teaching.notesapplication.repository

import ru.pasvitas.teaching.notesapplication.model.Note

interface INoteRepository {
    fun addNote(note: Note)
    fun editNote(note: Note)
    fun deleteNote(id: Long)
    fun getNoteById(id: Long) : Note
    fun getAllNotes() : List<Note>
}