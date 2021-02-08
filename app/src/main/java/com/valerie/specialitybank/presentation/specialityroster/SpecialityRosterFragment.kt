package com.valerie.specialitybank.presentation.specialityroster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.valerie.specialitybank.databinding.FragmentSpecialityRosterBinding
import com.valerie.specialitybank.domain.entity.Speciality
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpecialityRosterFragment : Fragment() {
    private val viewModel: SpecialityRosterViewModel by viewModel()
    private lateinit var binding: FragmentSpecialityRosterBinding

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

//        viewModel.aa.observe(viewLifecycleOwner) {
//            adapter.submitList(it)
//        }
        viewModel.load().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

//        motor.states.observe(viewLifecycleOwner) { state ->
//            adapter.submitList(state.items)
//            binding.loading.visibility = View.GONE
//
//            when {
//                state.items.isEmpty() && state.filterMode == FilterMode.ALL -> {
//                    binding.empty.visibility = View.VISIBLE
//                    binding.empty.setText(R.string.msg_empty)
//                }
//                state.items.isEmpty() -> {
//                    binding.empty.visibility = View.VISIBLE
//                    binding.empty.setText(R.string.msg_empty_filtered)
//                }
//                else -> binding.empty.visibility = View.GONE
//            }
//
//            menuMap[state.filterMode]?.isChecked = true
//        }

//        viewLifecycleOwner.lifecycleScope.launch {
//            motor.navEvents.collect { nav ->
//                when (nav) {
//                    is Nav.ViewReport -> viewReport(nav.doc)
//                    is Nav.ShareReport -> shareReport(nav.doc)
//                }
//            }
//        }
//
//        viewLifecycleOwner.lifecycleScope.launch {
//            motor.errorEvents.collect { error ->
//                when (error) {
//                    ErrorScenario.Import -> handleImportError()
//                }
//            }
//        }

//        findNavController()
//            .getBackStackEntry(R.id.rosterListFragment)
//            .savedStateHandle
//            .getLiveData<ErrorScenario>(ErrorDialogFragment.KEY_RETRY)
//            .observe(viewLifecycleOwner) { retryScenario ->
//                clearImportError()
//
//                when (retryScenario) {
//                    ErrorScenario.Import -> motor.importItems()
//                }
//            }
    }

    private fun display(speciality : Speciality) {
        findNavController()
            .navigate(
                SpecialityRosterFragmentDirections.actionSpeciality(
                    speciality.id
                )
            )
    }

}