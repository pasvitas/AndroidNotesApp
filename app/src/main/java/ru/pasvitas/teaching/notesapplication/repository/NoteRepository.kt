package ru.pasvitas.teaching.notesapplication.repository

import ru.pasvitas.teaching.notesapplication.model.Note

class NoteRepository(private val noteDAO: NoteDAO) : INoteRepository {

    override fun addNote(note: Note) {
        noteDAO.saveNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) {
        noteDAO.saveNote(note.toNoteEntity())
    }

    override fun deleteNote(id: Long) {
        noteDAO.deleteNote(getNoteById(id).toNoteEntity())
    }

    override fun getNoteById(id: Long): Note
        = noteDAO.getNoteById(id).toNote()

    override fun getAllNotes(): List<Note>
        = noteDAO.getAllNotes().map { it.toNote() }
}