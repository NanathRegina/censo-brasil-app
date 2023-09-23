package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.databinding.InfoDomicilioTelaBinding

class InfoDomicilioTela : Fragment() {

    private var _binding: InfoDomicilioTelaBinding? = null
    private lateinit var activityContext: Context
    private val binding get() = _binding!!
    private val items_agua = listOf("Rede geral de distribuição", "Poço", "Carro-pipa", "Água da chuva armazenada")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
            findNavController().navigate(R.id.action_InfoDomicilioTela_to_DemaisInfoDomicilioTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}