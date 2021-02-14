package com.valerie.specialitybank.presentation.specialityroster

import androidx.recyclerview.widget.RecyclerView
import com.valerie.specialitybank.databinding.SpecialityItemBinding
import com.valerie.specialitybank.presentation.view.SpecialityView

class SpecialityRosterHolder(
    private val binding: SpecialityItemBinding,
    val onRowClick: (SpecialityView) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var speciality: SpecialityView

    init {
        binding.root.setOnClickListener { onRowClick(speciality) }
    }

    fun bind(speciality: SpecialityView) {
        this.speciality = speciality
        binding.apply {
            specialityItem.text = speciality.name
        }
    }
}