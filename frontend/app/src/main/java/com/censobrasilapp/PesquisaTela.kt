package com.censobrasilapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.PesquisaTelaBinding

class PesquisaTela : Fragment() {

    private var _binding: PesquisaTelaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PesquisaTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(25, true)

        binding.buttonPesquisa.setOnClickListener {
            findNavController().navigate(R.id.action_PesquisaTela_to_MoradorTela)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}