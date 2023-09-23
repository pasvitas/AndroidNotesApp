package ru.pasvitas.teaching.notesapplication.model

interface INoteUseCase {
    suspend fun saveNote(note: Note)
    suspend fun deleteNote(id: Long)
    suspend fun getNoteById(id: Long) : Note
    suspend fun getAllNotes() : List<Note>
}