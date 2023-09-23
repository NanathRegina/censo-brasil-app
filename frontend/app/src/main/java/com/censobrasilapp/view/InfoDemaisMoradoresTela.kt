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
import com.censobrasilapp.databinding.InfoDemaisMoradoresTelaBinding

class InfoDemaisMoradoresTela : Fragment() {

    private var _binding: InfoDemaisMoradoresTelaBinding? = null
    private lateinit var activityContext: Context
    private val binding get() = _binding!!
    private val items_parentesco = listOf("Cônjuge ou companheiro(a)", "Filho(a) ou enteado(a)", "Pai, mãe, padrasto ou madrasta")
    private val items_info_prestada = listOf("A própria pessoa", "Outro morador", "Não morador")
    private val items_cor = listOf("Branca", "Preta", "Amarela", "Parda", "Indínena")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = InfoDemaisMoradoresTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(70, true)
        binding.autoCor.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_cor
                )
            )
        }

        binding.autoParentesco.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_parentesco
                )
            )
        }

        binding.autoInfoPrestada.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_info_prestada
                )
            )
        }
        binding.buttonInfoDemaisMoradores.setOnClickListener {
            findNavController().navigate(R.id.action_InfoDemaisMoradoresTela_to_InfoDomicilioTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}