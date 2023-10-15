package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.api.FaceServiceApi
import com.censobrasilapp.databinding.EspecieTelaBinding
import com.censobrasilapp.databinding.UnidadeTelaBinding
import com.censobrasilapp.model.Face
import com.censobrasilapp.model.Unidade
import com.censobrasilapp.utils.NetworkUtils
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime


class EspecieTela : Fragment() {

    private var _binding: EspecieTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context

    private val items_domicilio = listOf("DPPO - Domicílio Particular Permanente Ocupado",
        "DPPUO - Domicílio Particular Permanente de Uso Ocasional", "DPPV - Domicílio Particular Permanente Vago",
        "DPIO - Domicílio Particular Improvisado Ocupado", "DCCM - Domicílio Coletivo com Morador")

    private val items_edificacao = listOf("Casa", "Casa de vila ou condomínio", "Apartamento",
        "Habitação em casa de cômodos ou cortiços", "Habitação indígena sem paredes ou maloca")
    private val args by navArgs<EspecieTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = EspecieTelaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(25, true)

        binding.domicilioAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_domicilio
                )
            )
        }

        binding.edificacaoAuto.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.dropdown_id,
                    items_edificacao
                )
            )
        }

        binding.proximoEspecieBtn.setOnClickListener {
            try{
                createFace(getInput())
                Log.i("Especie tela", getInput().toString())
            }catch (e: Exception){
                Log.e("[Tela] Erro ao cadastrar face", e.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Face {

        val domicilioInputLayout: TextInputLayout = requireView().findViewById(R.id.input_domicilio)
        val domicilio: String = domicilioInputLayout.editText?.text.toString()

        val edificacaoInputLayout: TextInputLayout = requireView().findViewById(R.id.input_edificacao)
        val edificacao: String = edificacaoInputLayout.editText?.text.toString()

        val responsavelInputLayout: TextInputLayout = requireView().findViewById(R.id.input_responsavel)
        val responsavel: String = responsavelInputLayout.editText?.text.toString()

        val telefoneInputLayout: TextInputLayout = requireView().findViewById(R.id.input_telefone)
        val telefone: String = telefoneInputLayout.editText?.text.toString()

        val emailInputLayout: TextInputLayout = requireView().findViewById(R.id.input_email)
        val email: String = emailInputLayout.editText?.text.toString()

        var face = args.face

        Log.i("especie tela, dentro", face.toString())
        face.unidades?.forEach { unidade ->
            unidade.especie!!.especieDomicilio = domicilio
            unidade.especie!!.especieEdificio = edificacao
            unidade.especie!!.nomeResponsavel = responsavel
            unidade.especie!!.telefoneResponsavel = telefone
            unidade.especie!!.emailResponsavel = email
        }

        return face

    }

    fun createFace(face: Face) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(FaceServiceApi::class.java)
        face.dataInclusao = LocalDateTime.now().toString()
        face.status = "NAO_INICIADO"
        val callback = endpoint.createFace(face)

        callback.enqueue(object : Callback<Face> {
            override fun onFailure(call: Call<Face>, t: Throwable) {
                Log.i("[createFace] Erro ao cadastrar face: ", t.toString())
                //popUpErro()
            }

            override fun onResponse(call: Call<Face>, response: Response<Face>) {
                Log.i("[createFace] Sucesso!",response.toString())
                findNavController().navigate(EspecieTelaDirections.actionEspecieTelaToFacesTela())
                //popUpSucesso()
            }
        })

    }
}