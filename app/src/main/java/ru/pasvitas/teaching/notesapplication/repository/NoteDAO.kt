package ru.pasvitas.teaching.notesapplication.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.pasvitas.teaching.notesapplication.model.Note

@Dao
interface NoteDAO {

    @Query("SELECT * FROM noteentity")
    fun getAllNotes() : List<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE id = :id")
    fun getNoteById(id : Long) : NoteEntity

    @Insert
    fun saveNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

}