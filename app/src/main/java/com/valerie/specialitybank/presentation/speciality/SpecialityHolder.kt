package com.valerie.specialitybank.presentation.speciality

import androidx.recyclerview.widget.RecyclerView
import com.valerie.specialitybank.databinding.SpecialityItemBinding
import com.valerie.specialitybank.databinding.WorkerItemBinding
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.presentation.transformation.AgeTransform
import com.valerie.specialitybank.presentation.transformation.NameTransform

class SpecialityHolder(
    private val binding: WorkerItemBinding,
    val onRowClick: (Worker) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(worker: Worker) {
        binding.apply {
            root.setOnClickListener { onRowClick(worker) }
            workerName.text = NameTransform.getNameSurname(worker)
            workerAge.text = AgeTransform.getAgeStr(worker.getAge())
        }
    }
}