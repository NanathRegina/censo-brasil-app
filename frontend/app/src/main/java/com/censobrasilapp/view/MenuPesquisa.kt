package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.MenuPesquisaBinding
import com.censobrasilapp.model.Pesquisa
import org.json.JSONArray
import org.json.JSONObject
import java.util.Objects


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

        var pesquisa = Pesquisa()
            pesquisa.tipoPesquisa = "PRESENCIAL"

        //tipoPesquisa.put("tipoPesquisa","PRESENCIAL")

        binding.buttonPresencial.setOnClickListener {
            findNavController().navigate(MenuPesquisaDirections.actionMenuPesquisaToEtapasTela(pesquisa))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}