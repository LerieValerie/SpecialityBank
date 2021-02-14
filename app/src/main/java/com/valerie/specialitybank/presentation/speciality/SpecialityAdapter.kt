package com.valerie.specialitybank.presentation.speciality

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.valerie.specialitybank.databinding.WorkerItemBinding
import com.valerie.specialitybank.domain.entity.Worker
import com.valerie.specialitybank.presentation.view.WorkerView

class SpecialityAdapter(
    private val inflater: LayoutInflater,
    private val onRowClick: (WorkerView) -> Unit
) : ListAdapter<WorkerView, SpecialityHolder>(
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

private object DiffCallback : DiffUtil.ItemCallback<WorkerView>() {
    override fun areItemsTheSame(oldItem: WorkerView, newItem: WorkerView) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: WorkerView, newItem: WorkerView) =
        oldItem.fullName == newItem.fullName &&
                oldItem.age == newItem.age
}