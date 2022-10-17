package ru.pasvitas.teaching.notesapplication.model

import ru.pasvitas.teaching.notesapplication.repository.INoteRepository

class NoteUseCase(private val noteRepository: INoteRepository) : INoteUseCase {

    override fun saveNote(note: Note) {
        if (note.id == null) {
            noteRepository.addNote(note)
        }
        else {
            noteRepository.editNote(note)
        }
    }

    override fun deleteNote(id: Long) {
        noteRepository.deleteNote(id)
    }

    override fun getNoteById(id: Long): Note
        = noteRepository.getNoteById(id)

    override fun getAllNotes(): List<Note>
        = noteRepository.getAllNotes()


}