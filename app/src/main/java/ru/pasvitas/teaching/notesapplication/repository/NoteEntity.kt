package ru.pasvitas.teaching.notesapplication.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.pasvitas.teaching.notesapplication.model.Note
import java.util.*

@Entity
data class NoteEntity(
    @PrimaryKey val id: Long?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "text") val text: String
)
{
    fun toNote() =
        Note(id, title, text)
}