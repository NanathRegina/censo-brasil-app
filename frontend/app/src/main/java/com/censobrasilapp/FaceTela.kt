package com.censobrasilapp

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.FaceTelaBinding
import com.google.android.material.textfield.TextInputLayout


class FaceTela : Fragment() {

    private var _binding: FaceTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context
    //banco de dados
    private val items_logradouro = listOf("Rua Hipódromo", "Rua Inácio de Araújo", "Rua 21 de Abril", "Avenida Celso Garcia")
    private val items_bairro = listOf("Brás", "Ipiranga") //banco de dados

    var res = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FaceTelaBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.proximoFaceBtn.setOnClickListener {
            if(validaCampos(view)){
            findNavController().navigate(R.id.action_FaceTela_to_UnidadeTela)}
        }

        binding.logradouroAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_logradouro
                )
            )
        }

        binding.bairroAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_bairro
                )
            )
        }
    }

    private fun validaCampos(view: View): Boolean {
        val textInputLayout: TextInputLayout = view.findViewById(R.id.quadra_input)
        val quadra: String = textInputLayout.editText?.text.toString()

        //Log.i("alo", quadra)
        /*
        if (verificaCampoVazio(quadra).also { res = it }) {
            binding.quadraInput.requestFocus()
            binding.quadraInput.seterror
            return false
        }
        return true
    }

 */
        if (verificaCampoVazio(quadra).also { res = it }) {
            binding.quadraInput.requestFocus()
            binding.quadraInput.error = "Error"
            return false
        }
        return true
    }
    private fun verificaCampoVazio(valor: String): Boolean {
        return TextUtils.isEmpty(valor) || valor.trim { it <= ' ' }.isEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}