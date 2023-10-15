package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.databinding.EspeciesTelaBinding


class EspeciesTela : Fragment() {

    private var _binding: EspeciesTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context
    private val args by navArgs<EspeciesTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = EspeciesTelaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(25, true)
        Log.i("Especies tela", args.face.toString())

        binding.buttonAdcEspecies.setOnClickListener {
            findNavController().navigate(EspeciesTelaDirections.actionEspeciesTelaToEspecieTela(args.face))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}