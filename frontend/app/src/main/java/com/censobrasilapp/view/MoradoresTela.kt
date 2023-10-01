package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.api.Endpoints
import com.censobrasilapp.databinding.MoradoresTelaBinding
import com.censobrasilapp.model.Morador
import com.censobrasilapp.model.Pesquisa
import com.censobrasilapp.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoradoresTela : Fragment() {

    private var _binding: MoradoresTelaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<MoradoresTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MoradoresTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(50, true)

        binding.buttonAdcMorador.setOnClickListener {
            findNavController().navigate(MoradoresTelaDirections.actionMoradoresTelaToDemaisMoradoresTela(args.pesquisa))
        }

        binding.buttonMoradores.setOnClickListener {
            findNavController().navigate(MoradoresTelaDirections.actionMoradoresTelaToInfoDomicilioTela (args.pesquisa))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}