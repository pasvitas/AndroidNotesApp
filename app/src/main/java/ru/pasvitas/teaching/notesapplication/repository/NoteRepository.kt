package ru.pasvitas.teaching.notesapplication.repository

import ru.pasvitas.teaching.notesapplication.model.Note

class NoteRepository(private val noteDAO: NoteDAO) : INoteRepository {

    override suspend fun addNote(note: Note) {
        noteDAO.saveNote(note.toNoteEntity())
    }

    override suspend fun editNote(note: Note) {
        noteDAO.editNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(id: Long) {
        noteDAO.deleteNote(id)
    }

    override suspend fun getNoteById(id: Long): Note
        = noteDAO.getNoteById(id).toNote()

    override suspend fun getAllNotes(): List<Note>
        = noteDAO.getAllNotes().map { it.toNote() }
}