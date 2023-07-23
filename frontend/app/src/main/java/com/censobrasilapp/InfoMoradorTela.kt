package com.censobrasilapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.InfoMoradorTelaBinding

class InfoMoradorTela : Fragment() {

    private var _binding: InfoMoradorTelaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = InfoMoradorTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(50, true)

        binding.buttonInfoMorador.setOnClickListener {
            findNavController().navigate(R.id.action_InfoMoradorTela_to_MoradoresTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}