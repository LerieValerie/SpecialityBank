package com.valerie.specialitybank.presentation.worker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.valerie.specialitybank.R
import com.valerie.specialitybank.databinding.FragmentWorkerBinding
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.presentation.transformation.DateTransform
import com.valerie.specialitybank.presentation.transformation.NameTransform
import com.valerie.specialitybank.presentation.transformation.SpecialityListTransform
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WorkerFragment : Fragment() {
    private val args: WorkerFragmentArgs by navArgs()
    private val viewModel: WorkerViewModel by viewModel { parametersOf(args.workerId) }
    private lateinit var binding: FragmentWorkerBinding
    private lateinit var worker: Worker

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = FragmentWorkerBinding.inflate(inflater, container, false)
            .apply { binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadWorker().observe(viewLifecycleOwner) {
            if (it != null) {
                worker = it
                displayWorkerInfo(worker)
            }
        }

        viewModel.loadSpecialityList().observe(viewLifecycleOwner) {
            displaySpecialityList(it)
        }
    }

    private fun displayPhoto(url: String?) {
        binding.apply {
            Glide.with(root.context)
                    .load(url)
                    .transform(CircleCrop())
                    .placeholder(R.drawable.ic_image_place_holder)
                    .error(R.drawable.ic_broken_image)
                    .fallback(R.drawable.ic_no_image)
                    .into(workerImage)
        }
    }

    private fun displayWorkerInfo(worker: Worker) {
        displayPhoto(worker.imageUrl)
        binding.apply {
            workerSurnameName.text = NameTransform.getNameSurname(worker)
            birthDate.text = DateTransform.getDateWithDot(worker.birthDate) ?: getString(R.string.empty)
            age.text = worker.getAge()?.toString() ?: getString(R.string.empty)
        }
    }

    private fun displaySpecialityList(specialityList : List<Speciality>) {
        binding.specialityList.text = SpecialityListTransform.getListToStr(specialityList)
    }
}