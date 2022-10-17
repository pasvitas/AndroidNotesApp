package ru.pasvitas.teaching.notesapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import ru.pasvitas.teaching.notesapplication.NoteApplication
import ru.pasvitas.teaching.notesapplication.R

class EditNoteFragment : Fragment() {

    companion object {
        fun newInstance() = EditNoteFragment()
    }

    private lateinit var viewModel: EditNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditNoteViewModel::class.java)

        viewModel.init(requireActivity().application as NoteApplication)

        requireActivity().findViewById<Button>(R.id.buttonSaveNote).setOnClickListener {
            viewModel.saveData(null,
                requireActivity().findViewById<EditText>(R.id.titleEditText).text.toString(),
                requireActivity().findViewById<EditText>(R.id.textEditText).text.toString())

            requireActivity().supportFragmentManager.popBackStack()
        }
    }

}