package com.censobrasilapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.FaceTelaBinding
import com.google.android.material.progressindicator.LinearProgressIndicator

class FaceTela : Fragment() {

    private var _binding: FaceTelaBinding? = null
    private val binding get() = _binding!!
    lateinit var linear: LinearProgressIndicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FaceTelaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.proximoFaceBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FaceTela_to_UnidadeTela)
        }
        //binding.indicator.setProgressCompat(50, true)
        //linear.setProgressCompat(50, true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}