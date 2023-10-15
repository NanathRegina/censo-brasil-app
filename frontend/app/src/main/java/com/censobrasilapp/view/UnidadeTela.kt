package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.databinding.UnidadeTelaBinding
import com.censobrasilapp.model.Face
import com.censobrasilapp.model.Pesquisa
import com.censobrasilapp.model.Unidade
import com.google.android.material.textfield.TextInputLayout


class UnidadeTela : Fragment() {

    private var _binding: UnidadeTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context
    private val items_id = listOf("Sim", "Não")
    private val items_mod = listOf("SN", "FNS", "SMS", "FUNASA", "KM")
    private val items_ref =
        listOf("Ao lado da(e)(o)", "Antes da(e)(o)", "Após a(o)", "Em frente a(ao)")
    private val args by navArgs<UnidadeTelaArgs>()

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
            Log.i("Unidade tela", getInput().toString())
            //findNavController().navigate(R.id.action_MoradorTela_to_InfoMoradorTela)
            findNavController().navigate(UnidadeTelaDirections.actionUnidadeTelaToCoordenadaTela(getInput()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Face {

        val idInputLayout: TextInputLayout = requireView().findViewById(R.id.id_input)
        val identificacao: String = idInputLayout.editText?.text.toString()

        val numeroInputLayout: TextInputLayout = requireView().findViewById(R.id.numero_input)
        val numero: String = numeroInputLayout.editText?.text.toString()

        val modificadorInputLayout: TextInputLayout = requireView().findViewById(R.id.modificador_input)
        val modificador: String = modificadorInputLayout.editText?.text.toString()

        val tipoReferenciaInputLayout: TextInputLayout = requireView().findViewById(R.id.ref_input)
        val tipoReferencia: String = tipoReferenciaInputLayout.editText?.text.toString()

        val referenciaInputLayout: TextInputLayout = requireView().findViewById(R.id.referencia_input)
        val referencia: String = referenciaInputLayout.editText?.text.toString()

        var face = args.face
        var unidade = Unidade()

        if (identificacao != "Sim") {
            unidade.identificacao = false
        }
        unidade.numero = numero
        unidade.modificador = modificador
        unidade.tipoReferencia = tipoReferencia
        unidade.referencia = referencia

        face.unidades = listOf(unidade)

        return face

    }
}