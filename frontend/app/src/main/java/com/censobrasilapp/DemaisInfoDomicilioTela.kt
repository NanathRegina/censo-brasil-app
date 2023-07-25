package com.censobrasilapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.DemaisInfoDomicilioTelaBinding

class DemaisInfoDomicilioTela : Fragment() {

    private var _binding: DemaisInfoDomicilioTelaBinding? = null
    private lateinit var activityContext: Context
    private val binding get() = _binding!!
    private val items_esgoto = listOf("Rede geral ou pluvial", "Ligada à rede", "Não ligada à rede", "Fossa rudimentar ou buraco")
    private val items_lixo = listOf("Coletado no domicílio por serviço de limpeza", "Depositado em caçamba de serviço de limpeza", "Queimado na propriedade", "Enterrado na propriedade")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
            findNavController().navigate(R.id.action_DemaisInfoDomicilioTela_to_MortalidadeTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}