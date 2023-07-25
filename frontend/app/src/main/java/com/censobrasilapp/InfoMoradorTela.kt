package com.censobrasilapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.InfoMoradorTelaBinding

class InfoMoradorTela : Fragment() {

    private var _binding: InfoMoradorTelaBinding? = null
    private lateinit var activityContext: Context
    private val binding get() = _binding!!
    private val items_cor = listOf("Branca", "Preta", "Amarela", "Parda", "Indínena")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = InfoMoradorTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(40, true)
        binding.autoCor.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_cor
                )
            )
        }
        binding.buttonInfoMorador.setOnClickListener {
            findNavController().navigate(R.id.action_InfoMoradorTela_to_MoradoresTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}