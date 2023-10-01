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
import com.censobrasilapp.databinding.InfoDomicilioTelaBinding
import com.censobrasilapp.model.Morador
import com.censobrasilapp.model.Pesquisa
import com.google.android.material.textfield.TextInputLayout

class InfoDomicilioTela : Fragment() {

    private var _binding: InfoDomicilioTelaBinding? = null
    private lateinit var activityContext: Context
    private val binding get() = _binding!!
    private val items_agua =
        listOf("Rede geral de distribuição", "Poço", "Carro-pipa", "Água da chuva armazenada")

    private val args by navArgs<InfoDomicilioTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = InfoDomicilioTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(80, true)
        binding.autoAgua.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_agua
                )
            )
        }
        binding.buttonInfoDomicilio.setOnClickListener {
            findNavController().navigate(
                InfoDomicilioTelaDirections.actionInfoDomicilioTelaToDemaisInfoDomicilioTela(
                    getInput()
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Pesquisa {

        val abastecimentoInputLayout: TextInputLayout = requireView().findViewById(R.id.input_agua)
        var abastecimentoDomicilio: String = abastecimentoInputLayout.editText?.text.toString()

        val distribuicaoInputLayout: RadioGroup = requireView().findViewById(R.id.radio_group_rede)
        val distribuicaoDomicilio: String =
            requireView().findViewById<RadioButton?>(distribuicaoInputLayout.checkedRadioButtonId).text.toString()

        val aguaInputLayout: RadioGroup =
            requireView().findViewById(R.id.radio_group_agua_utilizada)
        val aguaDomicilio: String =
            requireView().findViewById<RadioButton?>(aguaInputLayout.checkedRadioButtonId).text.toString()


        abastecimentoDomicilio = transformaDados(abastecimentoDomicilio)

        var pesquisa = args.pesquisa
        pesquisa.tipoAbastecimento = abastecimentoDomicilio
        pesquisa.aguaEncanada = aguaDomicilio

        if (distribuicaoDomicilio != "Sim") {
            pesquisa.acessoDistribuicao = false
        }

        return pesquisa

    }


    fun transformaDados(dado: String): String{
        when (dado) {
            "Rede geral de distribuição" -> return "REDE_GERAL"
            "Poço" -> return "POCO"
            "Carro-pipa" ->  return "CARRO_PIPA"
            else -> {
                return "CHUVA"
            }
        }

    }
}