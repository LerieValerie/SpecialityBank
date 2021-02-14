package com.valerie.specialitybank.presentation.speciality

import androidx.recyclerview.widget.RecyclerView
import com.valerie.specialitybank.R
import com.valerie.specialitybank.databinding.WorkerItemBinding
import com.valerie.specialitybank.presentation.view.WorkerView

class SpecialityHolder(
    private val binding: WorkerItemBinding,
    val onRowClick: (WorkerView) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var worker: WorkerView

    init {
        binding.root.setOnClickListener { onRowClick(worker) }
    }

    fun bind(worker: WorkerView) {
        this.worker = worker
        binding.apply {
            workerName.text = worker.fullName
            workerAge.text = worker.age?.let { root.context.getString(R.string.years_old, it) }
                ?: root.context.getString(R.string.empty)
        }
    }
}