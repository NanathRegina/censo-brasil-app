package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.databinding.EtapasTelaBinding

class EtapasTela : Fragment() {

    private var _binding: EtapasTelaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<EtapasTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = EtapasTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //argumentos recebidos da tela MenuPesquisa
        Log.d("argumentos recebidos", args.tipoPesquisa)
        binding.buttonEtapas.setOnClickListener {
            findNavController().navigate(R.id.action_FaceTela_to_PesquisaTela)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}