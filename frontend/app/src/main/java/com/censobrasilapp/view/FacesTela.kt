package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.api.FaceServiceApi
import com.censobrasilapp.api.PesquisaServiceApi
import com.censobrasilapp.databinding.FacesTelaBinding
import com.censobrasilapp.model.Face
import com.censobrasilapp.model.Pesquisa
import com.censobrasilapp.utils.NetworkUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import retrofit2.awaitResponse
import java.time.LocalDateTime


class FacesTela : Fragment() {

    private var _binding: FacesTelaBinding? = null

    private lateinit var activityContext: Context
    private val binding get() = _binding!!

    var array = arrayOf(
        "Melbourne",
        "Vienna",
        "Vancouver",
        "Toronto",
        "Calgary",
        "Adelaide",
        "Perth",
        "Auckland",
        "Helsinki",
        "Hamburg",
        "Munich",
        "New York",
        "Sydney",
        "Paris",
        "Cape Town",
        "Barcelona",
        "London",
        "Bangkok"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FacesTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buscaFaces(
            onSuccessGetFaces = {
                //Lista de faces
                Log.d("teste", it.size.toString())
            },
            onRequestError = {
                //implementação para quando a requisição falhar
            }
        )
        //Log.i("faces", faces.toString())
        //setContentView(activityContext, R.layout.activity_main)
        binding.listview1.apply {
            setAdapter(
                ArrayAdapter(
                    activityContext,
                    R.layout.listview_item,
                    array
                )
            )
        }

        val adapter = ArrayAdapter(
            activityContext,
            R.layout.listview_item, array
        )

        val listView: ListView = requireView().findViewById(R.id.listview_1)
        //findViewById(R.id.listview_1)
        listView.adapter = adapter

        binding.buttonAdcFace.setOnClickListener {
            popUp()
        }

        binding.buttonFaces.setOnClickListener {
            findNavController().navigate(R.id.action_FacesTela_to_MenuPesquisa)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun popUp() {
        MaterialAlertDialogBuilder(activityContext)
            .setTitle(resources.getString(R.string.popup_faces))
            .setMessage(resources.getString(R.string.popup_message_faces))
            .setPositiveButton(resources.getString(R.string.btn_popup_sim)) { dialog, which ->
                findNavController().navigate(R.id.action_FacesTela_to_FaceTela)
            }
            .setNegativeButton(resources.getString(R.string.btn_popup_nao)) { dialog, which ->

            }
            .show()
    }

    private fun buscaFaces(
        onSuccessGetFaces: (List<Face>) -> Unit,
        onRequestError: () -> Unit
    ) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(FaceServiceApi::class.java)
        val callback = endpoint.getFaces()


        callback.enqueue(object : Callback<List<Face>> {
            override fun onFailure(call: Call<List<Face>>, t: Throwable) {
                Log.i("[buscaFaces] Erro ao buscar as faces: ", t.toString())
                onRequestError()
            }

            override fun onResponse(call: Call<List<Face>>, response: Response<List<Face>>) {
                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    onSuccessGetFaces.invoke(response.body()!!)
                } else {
                    onRequestError()
                }
            }

        })
    }

}