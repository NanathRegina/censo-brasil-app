package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.databinding.UnidadeTelaBinding


class UnidadeTela : Fragment() {

    private var _binding: UnidadeTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context
    private val items_id = listOf("Sim", "Não")
    private val items_mod = listOf("SN", "FNS", "SMS", "FUNASA", "KM")
    private val items_ref = listOf("Ao lado da(e)(o)", "Antes da(e)(o)", "Após a(o)", "Em frente a(ao)")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = UnidadeTelaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(25, true)

        binding.idAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_id
                )
            )
        }

        binding.modAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_mod
                )
            )
        }

        binding.refAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_ref
                )
            )
        }

        binding.unidadeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_MoradorTela_to_InfoMoradorTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}