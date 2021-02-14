package com.valerie.specialitybank.presentation.speciality

import androidx.recyclerview.widget.RecyclerView
import com.valerie.specialitybank.R
import com.valerie.specialitybank.databinding.WorkerItemBinding
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.presentation.formatter.NameFormatter.Companion.getNameSurname
import com.valerie.specialitybank.presentation.view.WorkerView

class SpecialityHolder(
    private val binding: WorkerItemBinding,
    val onRowClick: (WorkerView) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(worker: WorkerView) {
        binding.apply {
            root.setOnClickListener { onRowClick(worker) }
            workerName.text = worker.fullName
            workerAge.text = worker.age?.let { root.context.getString(R.string.years_old, it) }
                ?: root.context.getString(R.string.empty)
        }
    }
}