package ru.pasvitas.teaching.notesapplication.repository

import androidx.room.*
import ru.pasvitas.teaching.notesapplication.model.Note

@Dao
interface NoteDAO {

    @Query("SELECT * FROM noteentity")
    suspend fun getAllNotes() : List<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE id = :id")
    suspend fun getNoteById(id : Long) : NoteEntity

    @Insert
    suspend fun saveNote(note: NoteEntity)

    @Update
    suspend fun editNote(note: NoteEntity)

    @Query("DELETE FROM noteentity WHERE id = :id")
    suspend fun deleteNote(id: Long)

}