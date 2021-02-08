package com.valerie.specialitybank.presentation.specialityroster

import androidx.recyclerview.widget.RecyclerView
import com.valerie.specialitybank.databinding.SpecialityItemBinding
import com.valerie.specialitybank.domain.entity.Speciality

class SpecialityRosterHolder(
    private val binding: SpecialityItemBinding,
    val onRowClick: (Speciality) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(speciality: Speciality) {
        binding.apply {
            root.setOnClickListener { onRowClick(speciality) }
            specialityCode.text = speciality.id.toString()
            specialityItem.text = speciality.name
        }
    }
}