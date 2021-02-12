package com.valerie.specialitybank.presentation.speciality

import androidx.recyclerview.widget.RecyclerView
import com.valerie.specialitybank.R
import com.valerie.specialitybank.databinding.WorkerItemBinding
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.presentation.formatter.NameFormatter.Companion.getNameSurname

class SpecialityHolder(
    private val binding: WorkerItemBinding,
    val onRowClick: (Worker) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(worker: Worker) {
        binding.apply {
            root.setOnClickListener { onRowClick(worker) }
            workerName.text = getNameSurname(worker)
            workerAge.text = worker.getAge()?.let { root.context.getString(R.string.years_old, it) }
                ?: root.context.getString(R.string.empty)
        }
    }
}