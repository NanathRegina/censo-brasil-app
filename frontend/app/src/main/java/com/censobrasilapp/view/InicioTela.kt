package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.api.Endpoints
import com.censobrasilapp.databinding.InicioBinding
import com.censobrasilapp.model.Morador
import com.censobrasilapp.model.Pesquisa
import com.censobrasilapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Timestamp
import java.time.LocalDate
import java.util.Date

class InicioTela : Fragment() {

    private var _binding: InicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = InicioBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getPesquisa()
        binding.buttonInicio.setOnClickListener {
            //createPesquisa()
            findNavController().navigate(R.id.action_FirstFragment_to_FacesTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getPesquisa() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(Endpoints::class.java)
        val callback = endpoint.getPesquisa()

        callback.enqueue(object : Callback<Pesquisa> {
            override fun onFailure(call: Call<Pesquisa>, t: Throwable) {
                Log.i("pesquisa-erro", t.toString())
                //Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Pesquisa>, response: Response<Pesquisa>) {
                Log.i("pesquisa2",response.body().toString())
            }
        })

    }


}