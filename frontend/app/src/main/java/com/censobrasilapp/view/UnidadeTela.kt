package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.widget.addTextChangedListener
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

        binding.idAuto.addTextChangedListener {
            val idInputLayout: TextInputLayout = view.findViewById(R.id.id_input)
            val id: String = idInputLayout.editText?.text.toString()

            if(id == "Sim") {
                binding.numeroInput.isEnabled = true
                binding.modificadorInput.isEnabled = false
                binding.refInput.isEnabled = false
                binding.referenciaInput.isEnabled = false
            }
            else{
                binding.numeroInput.isEnabled = false
                binding.modificadorInput.isEnabled = true
                binding.refInput.isEnabled = true
                binding.referenciaInput.isEnabled = true
            }
        }

        binding.unidadeBtn.setOnClickListener {
            if(validaCampos(view)) {
                findNavController().navigate(UnidadeTelaDirections.actionUnidadeTelaToCoordenadaTela(getInput()))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validaCampos(view: View): Boolean {

        val idInputLayout: TextInputLayout = view.findViewById(R.id.id_input)
        val id: String = idInputLayout.editText?.text.toString()

        val numInputLayout: TextInputLayout = view.findViewById(R.id.numero_input)
        val num: String = numInputLayout.editText?.text.toString()

        val modInputLayout: TextInputLayout = view.findViewById(R.id.modificador_input)
        val mod: String = modInputLayout.editText?.text.toString()

        val refInputLayout: TextInputLayout = view.findViewById(R.id.ref_input)
        val ref: String = refInputLayout.editText?.text.toString()

        val referenciaInputLayout: TextInputLayout = view.findViewById(R.id.referencia_input)
        val referencia: String = referenciaInputLayout.editText?.text.toString()

        if(id.isEmpty()){
            binding.idInput.requestFocus()
            binding.idInput.error = "Error"
            return false
        }else{
            binding.idInput.isErrorEnabled = false
            if(id == "Sim"){
                if(num.isEmpty()){
                    binding.numeroInput.requestFocus()
                    binding.numeroInput.error = "Error"
                    return false
                }else{
                    binding.numeroInput.isErrorEnabled = false
                }
            }else{
                if(mod.isEmpty()){
                    binding.modificadorInput.requestFocus()
                    binding.modificadorInput.error = "Error"
                    return false
                }else{
                    binding.modificadorInput.isErrorEnabled = false
                }

                if(ref.isEmpty()){
                    binding.refInput.requestFocus()
                    binding.refInput.error = "Error"
                    return false
                }else{
                    binding.refInput.isErrorEnabled = false
                }

                if(referencia.isEmpty()){
                    binding.referenciaInput.requestFocus()
                    binding.referenciaInput.error = "Error"
                    return false
                }else{
                    binding.referenciaInput.isErrorEnabled = false
                }
            }        }


        binding.unidadeBtn.isEnabled = true
        return true
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
        unidade.modificador = if(!modificador.isEmpty()) modificador else "EMPTY"
        unidade.tipoReferencia = transformaDados(tipoReferencia)
        unidade.referencia = referencia

        face.unidades = listOf(unidade)

        return face

    }

    fun transformaDados(dado: String): String{
        when (dado) {
            "Ao lado da(e)(o)" -> return "AO_LADO"
            "Antes da(e)(o)" -> return "ANTES_DA"
            "Após a(o)" ->  return "APOS_A"
            "Em frente a(ao)" ->  return "EM_FRENTE"
            else -> {
                return "EMPTY"
            }
        }

    }
}