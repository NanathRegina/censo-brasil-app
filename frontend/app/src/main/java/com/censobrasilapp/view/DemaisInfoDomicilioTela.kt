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
import com.censobrasilapp.databinding.DemaisInfoDomicilioTelaBinding
import com.censobrasilapp.model.Pesquisa
import com.google.android.material.textfield.TextInputLayout

class DemaisInfoDomicilioTela : Fragment() {

    private var _binding: DemaisInfoDomicilioTelaBinding? = null
    private lateinit var activityContext: Context
    private val binding get() = _binding!!
    private val items_esgoto = listOf("Rede geral ou pluvial", "Ligada à rede", "Não ligada à rede", "Fossa rudimentar ou buraco")
    private val items_lixo = listOf("Coletado no domicílio por serviço de limpeza", "Depositado em caçamba de serviço de limpeza", "Queimado na propriedade", "Enterrado na propriedade")

    private val args by navArgs<DemaisInfoDomicilioTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DemaisInfoDomicilioTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(90, true)

        binding.autoEsgoto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_esgoto
                )
            )
        }

        binding.autoLixo.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_lixo
                )
            )
        }

        binding.buttonDemaisInfoDomicilio.setOnClickListener {
            findNavController().navigate(DemaisInfoDomicilioTelaDirections.actionDemaisInfoDomicilioTelaToMortalidadeTela(getInput()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Pesquisa {

        val banheirosInputLayout: TextInputLayout = requireView().findViewById(R.id.input_banheiros)
        val banheirosDomicilio: String = banheirosInputLayout.editText?.text.toString()

        val esgotoInputLayout: TextInputLayout = requireView().findViewById(R.id.input_esgoto)
        val esgotoDomicilio: String = esgotoInputLayout.editText?.text.toString()

        val lixoInputLayout: TextInputLayout = requireView().findViewById(R.id.input_lixo)
        val lixoDomicilio: String = lixoInputLayout.editText?.text.toString()

        var pesquisa = args.pesquisa
        pesquisa.qtdBanheiro = banheirosDomicilio
        pesquisa.esgoto = esgotoDomicilio
        pesquisa.lixo = lixoDomicilio

        return pesquisa

    }
}