package com.valerie.specialitybank.presentation.specialityroster

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.valerie.specialitybank.R
import com.valerie.specialitybank.databinding.FragmentSpecialityRosterBinding
import com.valerie.specialitybank.domain.entity.Speciality
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpecialityRosterFragment : Fragment() {
    private val viewModel: SpecialityRosterViewModel by viewModel()
    private lateinit var binding: FragmentSpecialityRosterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSpecialityRosterBinding.inflate(inflater, container, false)
        .apply { binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFromRemoteAndSaveToDb()

        val adapter =
            SpecialityRosterAdapter(
                layoutInflater,
                onRowClick = ::display
            )

        binding.speciality.apply {
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)

            addItemDecoration(
                DividerItemDecoration(
                    activity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }


        viewModel.load().observe(viewLifecycleOwner) {
            adapter.submitList(it)

//            when {
//                it.isEmpty() -> {
//                    binding.empty.visibility = View.VISIBLE
//                    binding.empty.setText(R.string.emptyText)
//                }
//                else -> {
//                    binding.empty.visibility = View.GONE
//                }
//
//            }
        }
    }

    private fun display(speciality : Speciality) {
        findNavController()
            .navigate(
                SpecialityRosterFragmentDirections.actionSpeciality(
                    speciality.id
                )
            )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actions, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.load -> {
                viewModel.reloadFromRemote()
//                viewModel.getFromRemoteAndSaveToDb()
                viewModel.load()
                return true
            }
//            R.id.delete -> {
//                viewModel.delete()
//                return true
//            }
        }
        return super.onOptionsItemSelected(item)
    }


}