package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.databinding.CensoTelaBinding
import com.censobrasilapp.model.Pesquisa
import com.google.android.material.textfield.TextInputLayout
import kotlinx.serialization.json.JsonBuilder
import org.json.JSONObject


class CensoTela : Fragment() {

    private var _binding: CensoTelaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<CensoTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = CensoTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.indicator.setProgressCompat(15, true)

        binding.buttonPesquisa.setOnClickListener {
            findNavController().navigate(CensoTelaDirections.actionCensoTelaToMoradorTela(getInput()))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Pesquisa {

        val moradoresInputLayout: TextInputLayout = requireView().findViewById(R.id.input_moradores)
        val qtdMoradores: String = moradoresInputLayout.editText?.text.toString()

        val criancasInputLayout: TextInputLayout = requireView().findViewById(R.id.input_criancas)
        val qtdCriancas: String = criancasInputLayout.editText?.text.toString()

        var pesquisa = args.tipoPesquisa
        pesquisa.qtdMoradores = qtdMoradores
        pesquisa.qtdCriancas = qtdCriancas

        return pesquisa

    }
}