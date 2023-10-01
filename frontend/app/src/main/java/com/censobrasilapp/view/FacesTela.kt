package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.censobrasilapp.R
import com.censobrasilapp.databinding.FacesTelaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FacesTela : Fragment() {

    private var _binding: FacesTelaBinding? = null

    private lateinit var activityContext: Context
    private val binding get() = _binding!!

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


}