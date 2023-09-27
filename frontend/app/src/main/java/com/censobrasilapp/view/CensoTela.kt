package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.databinding.CensoTelaBinding
import com.censobrasilapp.model.Pesquisa
import com.google.android.material.textfield.TextInputLayout
import kotlinx.serialization.json.JsonBuilder
import org.json.JSONObject


class CensoTela : Fragment() {

    private var _binding: CensoTelaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<CensoTelaArgs>()

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
            //var quantidadePessoas = getInput()
            //Log.i("teste", quantidadePessoas.toString())
            findNavController().navigate(CensoTelaDirections.actionCensoTelaToMoradorTela(getInput()))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Pesquisa {

        val moradoresInputLayout: TextInputLayout = requireView().findViewById(R.id.input_moradores)
        val qtdMoradores: String = moradoresInputLayout.editText?.text.toString()

        val criancasInputLayout: TextInputLayout = requireView().findViewById(R.id.input_criancas)
        val qtdCriancas: String = criancasInputLayout.editText?.text.toString()

        var pesquisa = args.tipoPesquisa
        pesquisa.qtdMoradores = qtdMoradores
        pesquisa.qtdCriancas = qtdCriancas
        //val pesquisaJson = JSONObject()
        //pesquisaJson.put("qtdMoradores", qtdMoradores)
        //pesquisaJson.put("qtdCriancas", qtdCriancas)


        //var pesquisa = pesquisaJson.put("",args.tipoPesquisa)

        //Log.d("output", pesquisaJson.toString())

        return pesquisa

    }
    /*
    fun createPesquisa(moradores: String, criancas: String) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(Endpoints::class.java)
        val callback = endpoint.createPesquisa(
            Pesquisa(args.tipoPesquisa,moradores,
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
            }

            override fun onResponse(call: Call<Pesquisa>, response: Response<Pesquisa>) {
                Log.i("create",response.toString())
                Log.i("create",response.body().toString())
            }
        })

    }

     */
}