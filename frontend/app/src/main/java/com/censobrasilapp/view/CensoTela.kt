package com.censobrasilapp.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.api.Endpoints
import com.censobrasilapp.databinding.CensoTelaBinding
import com.censobrasilapp.model.Morador
import com.censobrasilapp.model.Pesquisa
import com.censobrasilapp.utils.NetworkUtils
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CensoTela : Fragment() {

    private var _binding: CensoTelaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CensoTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(15, true)

        binding.buttonPesquisa.setOnClickListener {
            getInfoToCreate()
            findNavController().navigate(R.id.action_CensoTela_to_MoradorTela)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInfoToCreate(){
        val moradoresInputLayout: TextInputLayout = requireView().findViewById(R.id.input_moradores)
        val qtdMoradores: String = moradoresInputLayout.editText?.text.toString()

        val criancasInputLayout: TextInputLayout = requireView().findViewById(R.id.input_criancas)
        val qtdCriancas: String = criancasInputLayout.editText?.text.toString()

        Log.i("moradores", qtdMoradores)
        Log.i("criancas", qtdCriancas)
        createPesquisa(qtdMoradores, qtdCriancas)
    }
    fun createPesquisa(moradores: String, criancas: String) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()
        Log.i("cheguei aqui", arguments?.getString("tipoPesquisa").toString())

        val endpoint = retrofitClient.create(Endpoints::class.java)
        val callback = endpoint.createPesquisa(
            Pesquisa("",moradores,
                criancas, listOf(
                    Morador("Nat", "Silva", "F",
                        "2023-09-18T01:23:30.127+00:00", "1", "0",
                        "PARDA","DINHEIRO", 10.0, "FAIXA1","Nat",
                        null)
                ), "CHUVA",false,
                "sim", "sim", "não", "sim", true,
                "2023-09-18T01:23:30.127+00:00", null)
        )

        callback.enqueue(object : Callback<Pesquisa> {
            override fun onFailure(call: Call<Pesquisa>, t: Throwable) {
                Log.i("pesquisa-create", t.toString())
                //Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Pesquisa>, response: Response<Pesquisa>) {
                Log.i("create",response.toString())
                Log.i("create",response.body().toString())
            }
        })

    }
}