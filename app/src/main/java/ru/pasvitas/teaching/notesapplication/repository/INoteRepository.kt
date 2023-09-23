package ru.pasvitas.teaching.notesapplication.repository

import ru.pasvitas.teaching.notesapplication.model.Note

interface INoteRepository {
    suspend fun addNote(note: Note)
    suspend fun editNote(note: Note)
    suspend fun deleteNote(id: Long)
    suspend fun getNoteById(id: Long) : Note
    suspend fun getAllNotes() : List<Note>
}