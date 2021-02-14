package com.valerie.specialitybank.presentation.specialityroster

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.valerie.specialitybank.databinding.SpecialityItemBinding
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.presentation.view.SpecialityView

class SpecialityRosterAdapter(
    private val inflater: LayoutInflater,
    private val onRowClick: (SpecialityView) -> Unit
) : ListAdapter<SpecialityView, SpecialityRosterHolder>(
    DiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SpecialityRosterHolder(
            SpecialityItemBinding.inflate(inflater, parent, false),
            onRowClick
        )

    override fun onBindViewHolder(holder: SpecialityRosterHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object DiffCallback : DiffUtil.ItemCallback<SpecialityView>() {
    override fun areItemsTheSame(oldItem: SpecialityView, newItem: SpecialityView) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SpecialityView, newItem: SpecialityView) =
        oldItem.name == newItem.name
}