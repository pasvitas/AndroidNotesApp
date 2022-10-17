package ru.pasvitas.teaching.notesapplication.model

import ru.pasvitas.teaching.notesapplication.repository.NoteEntity
import java.util.*

data class Note(
    val id: Long?,
    val title: String,
    val text: String
)
{
    fun toNoteEntity() =
        NoteEntity(id, title, text)
}
