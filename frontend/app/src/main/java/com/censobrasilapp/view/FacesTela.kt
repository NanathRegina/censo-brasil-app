package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.api.FaceServiceApi
import com.censobrasilapp.databinding.FacesTelaBinding
import com.censobrasilapp.model.Face
import com.censobrasilapp.utils.NetworkUtils
import com.google.android.gms.maps.MapFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FacesTela : Fragment() {

    private var _binding: FacesTelaBinding? = null

    private lateinit var activityContext: Context
    private val binding get() = _binding!!

    var adapter: MyAdapter? = null

    private lateinit var btnIniciar: Button

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

        val fragment: Fragment = Mapa()

        childFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()


        buscaFaces(
            onSuccessGetFaces = { it ->

                val listView: ListView = requireView().findViewById(R.id.listview_1)
                adapter = MyAdapter(activityContext, it)
                listView.adapter = adapter

            },
            onRequestError = {
                //implementação para quando a requisição falhar
            }
        )
        binding.buttonAdcFace.setOnClickListener {
            popUp()
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
                findNavController().navigate(FacesTelaDirections.actionFacesTelaToFaceTela())
            }
            .setNegativeButton(resources.getString(R.string.btn_popup_nao)) { dialog, which ->

            }
            .show()
    }

    fun buscaFaces(
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
                Log.i("[buscaFaces] Sucesso!", response.body().toString())

                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    onSuccessGetFaces.invoke(response.body()!!)
                } else {
                    onRequestError()
                }
            }

        })

    }
}

    class MyAdapter(
        private val context: Context,
        private val arrayList: List<Face>

    ) : BaseAdapter() {
        private lateinit var status: TextView
        private lateinit var unidade: TextView
        private lateinit var logradouro: TextView
        private lateinit var btnIniciar: Button
        override fun getCount(): Int {
            return arrayList.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            var convertView = convertView
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
            status = convertView.findViewById(R.id.status)
            unidade = convertView.findViewById(R.id.unidade)
            logradouro = convertView.findViewById(R.id.logradouro)
            btnIniciar = convertView.findViewById(R.id.button_faces)

            when (arrayList[position].status) {
                "NAO_INICIADO" -> status.text = "Ainda não respondido"
                "EM_ANDAMENTO" -> status.text = "Em andamento"
                "PAUSADO" -> status.text = "Pausado"
                "FINALIZADO" -> status.text = "Finalizado"
            }

            when (arrayList[position].status) {
                "NAO_INICIADO" -> btnIniciar.isEnabled = true
                "EM_ANDAMENTO" -> btnIniciar.isEnabled = true
                "PAUSADO" -> btnIniciar.isEnabled = true
                "FINALIZADO" -> btnIniciar.isEnabled = false
            }

            unidade.text = "Unidades: " + arrayList[position].qtdUnidades
            logradouro.text =
                arrayList[position].quadra + "-" + arrayList[position].id + " - " + arrayList[position].logradouro
            return convertView
        }
    }
