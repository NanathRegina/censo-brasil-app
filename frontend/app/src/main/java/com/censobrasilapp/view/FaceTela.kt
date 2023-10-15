package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.api.FaceServiceApi
import com.censobrasilapp.databinding.FaceTelaBinding
import com.censobrasilapp.model.Face
import com.censobrasilapp.utils.NetworkUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.util.regex.Matcher
import java.util.regex.Pattern


class FaceTela : Fragment() {

    private var _binding: FaceTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context

    //banco de dados
    private val items_logradouro = listOf("Rua Hipódromo", "Rua Inácio de Araújo", "Rua 21 de Abril", "Avenida Celso Garcia")
    private val items_bairro = listOf("Brás", "Ipiranga", "Mooca")
    private val items_quadra = listOf("1", "2", "3", "4", "5")

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

        binding.inputFace.isEnabled = false

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
            if(binding.checkUnidade.isChecked){
                try{
                    createFace(getInput())
                }catch (e: Exception){
                    Log.e("[Tela] Erro ao cadastrar face sem unidade", e.toString())
                }
            }
            else{
                if(validaCampos(view)) {
                    findNavController().navigate(
                        FaceTelaDirections.actionFaceTelaToUnidadeTela(
                            getInput()
                        )
                    )

                }}}
    }

    fun createFace(face: Face) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(FaceServiceApi::class.java)
        face.dataInclusao = LocalDateTime.now().toString()
        face.status = "FINALIZADO"
        val callback = endpoint.createFace(face)

        callback.enqueue(object : Callback<Face> {
            override fun onFailure(call: Call<Face>, t: Throwable) {
                Log.i("[createFace] Erro ao cadastrar face: ", t.toString())
                popUpErro()
            }

            override fun onResponse(call: Call<Face>, response: Response<Face>) {
                Log.i("[createFace] Sucesso!",response.toString())
                //findNavController().navigate(EspecieTelaDirections.actionEspecieTelaToFacesTela())
                popUpSucesso()
            }
        })

    }

    fun popUpSucesso() {
        MaterialAlertDialogBuilder(activityContext)
            .setMessage(resources.getString(R.string.popup_finalizar_face))
            .setPositiveButton(resources.getString(R.string.btn_popup_finalizar)) { dialog, which ->
                findNavController().navigate(FaceTelaDirections.actionFaceTelaToFacesTela())

            }
            .show()
    }
    fun popUpErro() {
        MaterialAlertDialogBuilder(activityContext)
            .setMessage(resources.getString(R.string.popup_finalizar_erro_face))
            .setTitle(resources.getString(R.string.popup_erro_titulo))
            .setPositiveButton(resources.getString(R.string.btn_popup_finalizar)) { dialog, which ->
                findNavController().navigate(FaceTelaDirections.actionFaceTelaToFacesTela())

            }
            .show()
    }

    private fun validaCampos(view: View): Boolean {

        val quadraInputLayout: TextInputLayout = view.findViewById(R.id.input_quadra)
        val quadra: String = quadraInputLayout.editText?.text.toString()

        if(quadra.isEmpty()){
            binding.inputQuadra.requestFocus()
            binding.inputQuadra.error = "Error"
            return false
        }else{
            binding.inputQuadra.isErrorEnabled = false
        }

        val logradouroInputLayout: TextInputLayout = view.findViewById(R.id.input_logradouro)
        val logradouro: String = logradouroInputLayout.editText?.text.toString()

        if(logradouro.isEmpty()){
            binding.inputLogradouro.requestFocus()
            binding.inputLogradouro.error = "Error"
            return false
        }else{
            binding.inputLogradouro.isErrorEnabled = false
        }

        val cepInputLayout: TextInputLayout = view.findViewById(R.id.input_cep)
        val cep: String = cepInputLayout.editText?.text.toString()

        if (verificaCampoVazio(cep) || cep.length < 8) {
            binding.inputCep.requestFocus()
            binding.inputCep.error = "Informe CEP válido"


            return false
        }else{
            binding.inputCep.isErrorEnabled = false
        }

        val bairroInputLayout: TextInputLayout = view.findViewById(R.id.input_bairro)
        val bairro: String = bairroInputLayout.editText?.text.toString()

        if(bairro.isEmpty()){
            binding.inputBairro.requestFocus()
            binding.inputBairro.error = "Error"
            return false
        }else{
            binding.inputBairro.isErrorEnabled = false
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

    fun getInput(): Face {

        val quadraInputLayout: TextInputLayout = requireView().findViewById(R.id.input_quadra)
        val quadra: String = quadraInputLayout.editText?.text.toString()

        val logradouroInputLayout: TextInputLayout = requireView().findViewById(R.id.input_logradouro)
        val logradouro: String = logradouroInputLayout.editText?.text.toString()

        val cepInputLayout: TextInputLayout = requireView().findViewById(R.id.input_cep)
        val cep: String = cepInputLayout.editText?.text.toString()

        val bairroInputLayout: TextInputLayout = requireView().findViewById(R.id.input_bairro)
        val bairro: String = bairroInputLayout.editText?.text.toString()

        val narInputLayout: CheckBox = requireView().findViewById(R.id.check_unidade)
        val nar : Boolean = narInputLayout.isChecked

        var face = Face()
        face.quadra = quadra
        face.logradouro = logradouro
        face.cep = cep
        face.bairro = bairro
        face.nar = nar

        return face

    }
}