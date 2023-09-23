package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.databinding.InicioBinding
import com.censobrasilapp.viewmodel.PesquisaViewModel
import java.text.DateFormat
import java.util.Calendar
import java.util.Locale

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
        val pesquisaViewModel = ViewModelProvider(this).get(PesquisaViewModel::class.java)

        pesquisaViewModel.pesquisa.observe(viewLifecycleOwner, Observer { pesquisa ->
            Log.i("pesquisa", pesquisa.toString())}
        )
        binding.buttonInicio.setOnClickListener {

            findNavController().navigate(R.id.action_FirstFragment_to_FacesTela)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}