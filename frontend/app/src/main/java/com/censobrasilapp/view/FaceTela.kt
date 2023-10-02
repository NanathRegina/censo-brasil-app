package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.databinding.FaceTelaBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Random


class FaceTela : Fragment() {

    private var _binding: FaceTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context
    //banco de dados
    private val items_logradouro = listOf("Rua Hipódromo", "Rua Inácio de Araújo", "Rua 21 de Abril", "Avenida Celso Garcia")
    private val items_bairro = listOf("Brás", "Ipiranga") //banco de dados
    private val items_quadra = listOf("001", "002", "003", "004", "005")

    var res = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FaceTelaBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myRandom = Random()
        val cepEditText: TextInputEditText = view.findViewById(R.id.cep_text)

        cepEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                validaCampos(view)


            }
            })

        binding.faceText.setText((myRandom.nextInt(100)).toString())

        binding.quadraAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_quadra
                )
            )
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

        binding.proximoFaceBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FaceTela_to_UnidadeTela)}
    }

    private fun validaCampos(view: View): Boolean {

        val cepInputLayout: TextInputLayout = view.findViewById(R.id.cep_input)
        val cep: String = cepInputLayout.editText?.text.toString()


        if (verificaCampoVazio(cep).also { res = it }) {
            binding.cepInput.requestFocus()
            binding.cepInput.error = "Error"
            binding.proximoFaceBtn.isEnabled = false
            return false
        }
        binding.proximoFaceBtn.isEnabled = true
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