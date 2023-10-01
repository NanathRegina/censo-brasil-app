package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.api.Endpoints
import com.censobrasilapp.databinding.MortalidadeTelaBinding
import com.censobrasilapp.model.Pesquisa
import com.censobrasilapp.utils.NetworkUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MortalidadeTela : Fragment() {

    private var _binding: MortalidadeTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context

    private val args by navArgs<MortalidadeTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MortalidadeTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(100, true)

        binding.buttonInfoMortalidade.setOnClickListener {
            try{
                createPesquisa(getInput())
            }catch (e: Exception){
                Log.e("[Tela] Erro ao cadastrar pesquisa", e.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Pesquisa {

        val mortalidadeInputLayout: RadioGroup = requireView().findViewById(R.id.radio_group_mortalidade)
        val mortalidade : String = requireView().findViewById<RadioButton?>(mortalidadeInputLayout.checkedRadioButtonId).text.toString()

        var pesquisa = args.pesquisa

        if(mortalidade == "Sim"){
            pesquisa.falecimento = true
        }

        return pesquisa

    }

    fun popUpSucesso() {
        MaterialAlertDialogBuilder(activityContext)
            .setMessage(resources.getString(R.string.popup_finalizar))
            .setPositiveButton(resources.getString(R.string.btn_popup_finalizar)) { dialog, which ->
                findNavController().navigate(MortalidadeTelaDirections.actionMortalidadeTelaToFacesTela())

            }
            .show()
    }

    fun popUpErro() {
        MaterialAlertDialogBuilder(activityContext)
            .setMessage(resources.getString(R.string.popup_finalizar_erro))
            .setTitle(resources.getString(R.string.popup_erro_titulo))
            .setPositiveButton(resources.getString(R.string.btn_popup_finalizar)) { dialog, which ->
                findNavController().navigate(MortalidadeTelaDirections.actionMortalidadeTelaToFacesTela())

            }
            .show()
    }
    fun createPesquisa(pesquisa: Pesquisa) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(Endpoints::class.java)
        pesquisa.dataPesquisa = LocalDateTime.now().toString()
        val callback = endpoint.createPesquisa(pesquisa)

        callback.enqueue(object : Callback<Pesquisa> {
            override fun onFailure(call: Call<Pesquisa>, t: Throwable) {
                Log.i("[createPesquisa] Erro ao cadastrar pesquisa: ", t.toString())
                popUpErro()
            }

            override fun onResponse(call: Call<Pesquisa>, response: Response<Pesquisa>) {
                Log.i("[createPesquisa] Sucesso!",response.toString())
                popUpSucesso()
            }
        })

    }
}