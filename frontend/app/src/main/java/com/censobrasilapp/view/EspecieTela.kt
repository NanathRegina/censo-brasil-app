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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

        binding.indicator.setProgressCompat(70, true)

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
        var domicilio: String = domicilioInputLayout.editText?.text.toString()

        val edificacaoInputLayout: TextInputLayout = requireView().findViewById(R.id.input_edificacao)
        var edificacao: String = edificacaoInputLayout.editText?.text.toString()

        val responsavelInputLayout: TextInputLayout = requireView().findViewById(R.id.input_responsavel)
        val responsavel: String = responsavelInputLayout.editText?.text.toString()

        val telefoneInputLayout: TextInputLayout = requireView().findViewById(R.id.input_telefone)
        val telefone: String = telefoneInputLayout.editText?.text.toString()

        val emailInputLayout: TextInputLayout = requireView().findViewById(R.id.input_email)
        val email: String = emailInputLayout.editText?.text.toString()

        var face = args.face

        domicilio = transformaDados(domicilio)
        edificacao = transformaDados(edificacao)

        face.unidades?.forEach { unidade ->
            unidade.especie!!.especieDomicilio = domicilio
            unidade.especie!!.especieEdificio = edificacao
            unidade.especie!!.nomeResponsavel = responsavel
            unidade.especie!!.telefoneResponsavel = telefone
            unidade.especie!!.emailResponsavel = email
        }

        return face

    }

    fun transformaDados(dado: String): String{
        when (dado) {
            "DPPO - Domicílio Particular Permanente Ocupado" -> return "DPPO"
            "DPPUO - Domicílio Particular Permanente de Uso Ocasional" -> return "DPPUO"
            "DPPV - Domicílio Particular Permanente Vago" ->  return "DPPV"
            "DPIO - Domicílio Particular Improvisado Ocupado" ->  return "DPIO"
            "DCCM - Domicílio Coletivo com Morador" ->  return "DCCM"
            "Casa" ->  return "CASA"
            "Casa de vila ou condomínio" ->  return "CASA_VILA"
            "Apartamento" ->  return "APARTAMENTO"
            "Habitação em casa de cômodos ou cortiços" ->  return "HABITACAO_COMODOS"
            "Habitação indígena sem paredes ou maloca" ->  return "HABITACAO_INDIGENA"
            else -> {
                return ""
            }
        }

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
                popUpErro()
            }

            override fun onResponse(call: Call<Face>, response: Response<Face>) {
                Log.i("[createFace] Sucesso!",response.toString())
                if(response.code() == 200) {
                    popUpSucesso()
                }

            }
        })

    }

    fun popUpErro() {
        MaterialAlertDialogBuilder(activityContext)
            .setMessage(resources.getString(R.string.popup_finalizar_erro_face))
            .setTitle(resources.getString(R.string.popup_erro_titulo))
            .setPositiveButton(resources.getString(R.string.btn_popup_finalizar)) { dialog, which ->
                findNavController().navigate(EspecieTelaDirections.actionEspecieTelaToFacesTela())

            }
            .show()
    }

    fun popUpSucesso() {
        MaterialAlertDialogBuilder(activityContext)
            .setMessage(resources.getString(R.string.popup_finalizar_face))
            .setPositiveButton(resources.getString(R.string.btn_popup_finalizar)) { dialog, which ->
                findNavController().navigate(EspecieTelaDirections.actionEspecieTelaToMenuPesquisa())

            }
            .show()
    }
}