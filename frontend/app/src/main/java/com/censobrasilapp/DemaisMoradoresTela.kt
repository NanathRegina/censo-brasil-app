package com.censobrasilapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.DemaisMoradoresTelaBinding

class DemaisMoradoresTela : Fragment() {

    private var _binding: DemaisMoradoresTelaBinding? = null
    private val binding get() = _binding!!
    private val items_cor = listOf("Branca", "Preta", "Amarela", "Parda", "Indínena")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DemaisMoradoresTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(60, true)

        binding.buttonDemaisMoradores.setOnClickListener {
            findNavController().navigate(R.id.action_DemaisMoradoresTela_to_InfoDemaisMoradoresTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}