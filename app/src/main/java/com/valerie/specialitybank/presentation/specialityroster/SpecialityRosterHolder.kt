package com.valerie.specialitybank.presentation.specialityroster

import androidx.recyclerview.widget.RecyclerView
import com.valerie.specialitybank.databinding.SpecialityItemBinding
import com.valerie.specialitybank.domain.entity.Speciality
import com.valerie.specialitybank.presentation.view.SpecialityView

class SpecialityRosterHolder(
    private val binding: SpecialityItemBinding,
    val onRowClick: (SpecialityView) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(speciality: SpecialityView) {
        binding.apply {
            root.setOnClickListener { onRowClick(speciality) }
            specialityItem.text = speciality.name
        }
    }
}