package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.databinding.MenuPesquisaBinding


class MenuPesquisa : Fragment() {

    private var _binding: MenuPesquisaBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MenuPesquisaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPresencial.setOnClickListener {
            Log.i("entrando", "aqui")


            val bundle = Bundle()
            bundle.putString("tipoPesquisa", "PRESENCIAL")

            val censoTela= CensoTela()
            censoTela.arguments = bundle

            fragmentManager?.beginTransaction()?.replace(R.id.menu_pesquisa, censoTela)?.commit()


            Log.i("argumentos", censoTela.arguments.toString())
            Log.i("indo", "indo pra lá")
            findNavController().navigate(R.id.action_MenuPesquisa_to_EtapasTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}