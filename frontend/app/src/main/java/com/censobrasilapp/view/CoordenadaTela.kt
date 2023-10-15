package com.censobrasilapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.databinding.CoordenadaTelaBinding
import com.censobrasilapp.databinding.UnidadeTelaBinding
import com.censobrasilapp.model.Face
import com.censobrasilapp.model.Pesquisa
import com.censobrasilapp.model.Unidade
import com.google.android.material.textfield.TextInputLayout


class CoordenadaTela : Fragment() {

    private var _binding: CoordenadaTelaBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityContext: Context
    private val args by navArgs<CoordenadaTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = CoordenadaTelaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        activityContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(25, true)

        binding.proximoCoordenadaBtn.setOnClickListener {
            var face = args.face
            Log.i("face", face.toString())
            face.qtdUnidades = "1"

            face.unidades?.forEach { unidade ->
               unidade.coordenada = "-23.5448887,-46.6089089"
            }
            Log.i("Coordenada tela", face.toString())
            //findNavController().navigate(R.id.action_MoradorTela_to_InfoMoradorTela)
            findNavController().navigate(CoordenadaTelaDirections.actionCoordenadaTelaToEspeciesTela(face))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}