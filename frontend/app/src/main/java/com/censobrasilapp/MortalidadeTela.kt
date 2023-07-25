package com.censobrasilapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.databinding.MortalidadeTelaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MortalidadeTela : Fragment() {

    private var _binding: MortalidadeTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = MortalidadeTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(100, true)

        binding.buttonInfoMortalidade.setOnClickListener {
            popUp()}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun popUp() {
        MaterialAlertDialogBuilder(activityContext)
            .setMessage(resources.getString(R.string.popup_finalizar))
            .setPositiveButton(resources.getString(R.string.btn_popup_finalizar)) { dialog, which ->

                findNavController().navigate(R.id.action_MortalidadeTela_to_FacesTela)

            }
            .show()
    }
}