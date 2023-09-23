package com.censobrasilapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.databinding.MoradoresTelaBinding

class MoradoresTela : Fragment() {

    private var _binding: MoradoresTelaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = MoradoresTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(50, true)
        binding.buttonAdcMorador.setOnClickListener {
            findNavController().navigate(R.id.action_MoradoresTela_to_DemaisMoradoresTela)
        }

        binding.buttonMoradores.setOnClickListener {
            findNavController().navigate(R.id.action_MoradoresTela_to_InfoDomicilioTela)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}