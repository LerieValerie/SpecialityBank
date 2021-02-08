package com.valerie.specialitybank.presentation.speciality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.valerie.specialitybank.R
import com.valerie.specialitybank.databinding.FragmentSpecialityBinding
import com.valerie.specialitybank.databinding.FragmentSpecialityRosterBinding
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.presentation.specialityroster.SpecialityRosterAdapter
import com.valerie.specialitybank.presentation.specialityroster.SpecialityRosterFragmentDirections
import com.valerie.specialitybank.presentation.specialityroster.SpecialityRosterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SpecialityFragment : Fragment() {
    private val args: SpecialityFragmentArgs by navArgs()
    private val viewModel: SpecialityViewModel by viewModel { parametersOf(args.specialityId) }
    private lateinit var binding: FragmentSpecialityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSpecialityBinding.inflate(inflater, container, false)
        .apply { binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =
            SpecialityAdapter(
                layoutInflater,
                onRowClick = ::display
            )

        binding.worker.apply {
            setAdapter(adapter)
            layoutManager = LinearLayoutManager(context)

            addItemDecoration(
                DividerItemDecoration(
                    activity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        viewModel.loadSpeciality().observe(viewLifecycleOwner) {
            binding.specialityName.text = it.name
        }

        viewModel.loadWorkerList().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun display(worker: Worker) {
        findNavController()
            .navigate(
                SpecialityFragmentDirections.actionWorker(
                    worker.id
                )
            )
    }
}