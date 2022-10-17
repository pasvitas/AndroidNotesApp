package ru.pasvitas.teaching.notesapplication

import android.app.Application
import androidx.room.Room
import ru.pasvitas.teaching.notesapplication.model.INoteUseCase
import ru.pasvitas.teaching.notesapplication.model.NoteUseCase
import ru.pasvitas.teaching.notesapplication.repository.NoteDatabase
import ru.pasvitas.teaching.notesapplication.repository.NoteRepository

class NoteApplication : Application() {

    private lateinit var database : NoteDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
                applicationContext,
        NoteDatabase::class.java,
        "notes-database"
        ).build()
    }

    private var noteUseCase : INoteUseCase? = null

    fun getNoteUseCase() : INoteUseCase {
        if (noteUseCase == null) {
            noteUseCase = NoteUseCase(NoteRepository(database.getNoteDao()))
        }
        return noteUseCase!!
    }
}