package com.valerie.specialitybank.presentation.speciality

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.valerie.specialitybank.databinding.SpecialityItemBinding
import com.valerie.specialitybank.databinding.WorkerItemBinding
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.domain.entity.Worker

class SpecialityAdapter(
    private val inflater: LayoutInflater,
    private val onRowClick: (Worker) -> Unit
) : ListAdapter<Worker, SpecialityHolder>(
    DiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SpecialityHolder(
            WorkerItemBinding.inflate(inflater, parent, false),
            onRowClick
        )

    override fun onBindViewHolder(holder: SpecialityHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object DiffCallback : DiffUtil.ItemCallback<Worker>() {
    override fun areItemsTheSame(oldItem: Worker, newItem: Worker) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Worker, newItem: Worker) =
        oldItem.name == newItem.name
}