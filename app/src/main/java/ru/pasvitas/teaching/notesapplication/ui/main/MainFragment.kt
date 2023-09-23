package ru.pasvitas.teaching.notesapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import ru.pasvitas.teaching.notesapplication.NoteApplication
import ru.pasvitas.teaching.notesapplication.R
import ru.pasvitas.teaching.notesapplication.model.Note

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.init(requireActivity().application as NoteApplication)

        requireActivity().findViewById<Button>(R.id.buttonAddNote).setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, EditNoteFragment.newInstance())
            transaction.commit()
        }
    }


    override fun onResume() {
        super.onResume()
        viewModel.getAllNotes().observe(viewLifecycleOwner) {
            val recycle = requireActivity().findViewById<RecyclerView>(R.id.recyclerView)
            recycle.layoutManager = LinearLayoutManager(this.context)
            recycle.adapter =
                NoteAdapter(it,
                    object : OnRecycleViewListener {
                        override fun onViewClick(note: Note) {
                            val transaction = requireActivity().supportFragmentManager.beginTransaction()
                            transaction.replace(R.id.container, EditNoteFragment.newInstance(note))
                            transaction.commit()
                        }
                    })
        }
    }

    class NoteAdapter(private val notes: List<Note>, private val listener: OnRecycleViewListener) :
        RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

        class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            val title: TextView
            val text: TextView

            init {
                title = itemView.findViewById(R.id.title)
                text = itemView.findViewById(R.id.text)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.note_layout, parent, false)
            return NoteViewHolder(view)
        }

        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            holder.title.text = notes[position].title
            holder.text.text = notes[position].text
            holder.itemView.setOnClickListener {
                listener.onViewClick(notes[position])
            }
        }

        override fun getItemCount(): Int = notes.size

    }

    interface OnRecycleViewListener {
        fun onViewClick(note: Note)
    }
}