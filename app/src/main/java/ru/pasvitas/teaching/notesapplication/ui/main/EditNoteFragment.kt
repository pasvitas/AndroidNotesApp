package ru.pasvitas.teaching.notesapplication.ui.main

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.pasvitas.teaching.notesapplication.NoteApplication
import ru.pasvitas.teaching.notesapplication.R
import ru.pasvitas.teaching.notesapplication.model.Note

class EditNoteFragment(private val note: Note?) : Fragment() {

    companion object {
        fun newInstance() = EditNoteFragment(null)
        fun newInstance(note: Note) = EditNoteFragment(note)
    }

    private lateinit var viewModel: EditNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditNoteViewModel::class.java)

        viewModel.init(requireActivity().application as NoteApplication)

        note?.apply {
            requireActivity().findViewById<EditText>(R.id.titleEditText).setText(this.title)
            requireActivity().findViewById<EditText>(R.id.textEditText).setText(this.text)
            requireActivity().findViewById<Button>(R.id.buttonDeleteNote).visibility = View.VISIBLE
        }

        requireActivity().findViewById<Button>(R.id.buttonSaveNote).setOnClickListener {

            val id = note?.id

            viewModel.viewModelScope.launch {
                viewModel.saveData(id,
                    requireActivity().findViewById<EditText>(R.id.titleEditText).text.toString(),
                    requireActivity().findViewById<EditText>(R.id.textEditText).text.toString())
            }
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, MainFragment.newInstance())
            transaction.commit()
        }

        requireActivity().findViewById<Button>(R.id.buttonDeleteNote).setOnClickListener {
            viewModel.viewModelScope.launch {
                viewModel.deleteData(note!!.id!!)
            }
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, MainFragment.newInstance())
            transaction.commit()
        }
    }
}