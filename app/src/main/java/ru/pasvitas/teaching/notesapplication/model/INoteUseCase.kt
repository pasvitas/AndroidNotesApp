package ru.pasvitas.teaching.notesapplication.model

interface INoteUseCase {
    fun saveNote(note: Note)
    fun deleteNote(id: Long)
    fun getNoteById(id: Long) : Note
    fun getAllNotes() : List<Note>
}