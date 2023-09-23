package ru.pasvitas.teaching.notesapplication.model

import ru.pasvitas.teaching.notesapplication.repository.INoteRepository

class NoteUseCase(private val noteRepository: INoteRepository) : INoteUseCase {

    override suspend fun saveNote(note: Note) {
        if (note.id == null) {
            noteRepository.addNote(note)
        }
        else {
            noteRepository.editNote(note)
        }
    }

    override suspend fun deleteNote(id: Long) {
        noteRepository.deleteNote(id)
    }

    override suspend fun getNoteById(id: Long): Note
        = noteRepository.getNoteById(id)

    override suspend fun getAllNotes(): List<Note>
        = noteRepository.getAllNotes()


}