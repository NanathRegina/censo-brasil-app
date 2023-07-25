package com.censobrasilapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.CensoTelaBinding

class CensoTela : Fragment() {

    private var _binding: CensoTelaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CensoTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(15, true)

        binding.buttonPesquisa.setOnClickListener {
            findNavController().navigate(R.id.action_CensoTela_to_MoradorTela)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}