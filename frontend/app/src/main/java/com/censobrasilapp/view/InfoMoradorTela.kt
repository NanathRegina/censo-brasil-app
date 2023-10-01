package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.databinding.InfoMoradorTelaBinding
import com.censobrasilapp.model.Morador
import com.censobrasilapp.model.Pesquisa
import com.google.android.material.textfield.TextInputLayout

class InfoMoradorTela : Fragment() {

    private var _binding: InfoMoradorTelaBinding? = null
    private lateinit var activityContext: Context
    private val binding get() = _binding!!
    private val items_cor = listOf("Branca", "Preta", "Amarela", "Parda", "Indínena")

    private val args by navArgs<InfoMoradorTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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
            findNavController().navigate(InfoMoradorTelaDirections.actionInfoMoradorTelaToMoradoresTela(getInput()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Pesquisa {

        val corInputLayout: TextInputLayout = requireView().findViewById(R.id.input_cor)
        val corMorador: String = corInputLayout.editText?.text.toString()

        val leituraInputLayout: RadioGroup = requireView().findViewById(R.id.radio_group_ler)
        val leituraMorador : String = requireView().findViewById<RadioButton?>(leituraInputLayout.checkedRadioButtonId).text.toString()

        val rendimentosInputLayout: RadioGroup = requireView().findViewById(R.id.radio_group_redimentos)
        var rendimentoMorador : String = requireView().findViewById<RadioButton?>(rendimentosInputLayout.checkedRadioButtonId).text.toString()

        var pesquisa = args.pesquisa

        pesquisa.moradores?.forEach { morador ->
            morador.cor = corMorador.uppercase()
            //TODO: fazer isso de forma mais inteligente
            morador.formaRenda = transformaDados(rendimentoMorador)

            //TODO: incluir rendimento real
            morador.faixaRendimento = "FAIXA1"

            if(leituraMorador != "Sim"){
                morador.leitura = false
            }
        }
        return pesquisa

    }

    fun transformaDados(dado: String): String{
        when (dado) {
            "Valor em dinheiro, produtos ou mercadorias" -> return "DINHEIRO"
            "Outra forma(moradia, alimentação, etc)" -> return "OUTRA"
            else -> {
                return "NENHUMA"
            }
        }

    }
}