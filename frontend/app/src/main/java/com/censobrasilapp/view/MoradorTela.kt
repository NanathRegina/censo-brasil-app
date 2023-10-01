package com.censobrasilapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.censobrasilapp.R
import com.censobrasilapp.databinding.MoradorTelaBinding
import com.censobrasilapp.model.Morador
import com.censobrasilapp.model.Pesquisa
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

class MoradorTela : Fragment() {

    private var _binding: MoradorTelaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<MoradorTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MoradorTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(30, true)
        binding.buttonMorador.setOnClickListener {
            findNavController().navigate(MoradorTelaDirections.actionMoradorTelaToInfoMoradorTela(getInput()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getInput(): Pesquisa {

        val nomeInputLayout: TextInputLayout = requireView().findViewById(R.id.input_nome)
        val nomeMorador: String = nomeInputLayout.editText?.text.toString()

        val sobrenomeInputLayout: TextInputLayout = requireView().findViewById(R.id.input_sobrenome)
        val sobrenomeMorador: String = sobrenomeInputLayout.editText?.text.toString()

        val sexoInputLayout: RadioGroup = requireView().findViewById(R.id.radio_group_sexo)
        val sexoMorador : String = requireView().findViewById<RadioButton?>(sexoInputLayout.checkedRadioButtonId).text.toString()

        val nascimentoInputLayout: TextInputLayout = requireView().findViewById(R.id.input_nascimento)
        val nascimentoMorador: String = nascimentoInputLayout.editText?.text.toString()

        var pesquisa = args.pesquisa

        var morador = Morador()
        morador.nome= nomeMorador
        morador.sobrenome = sobrenomeMorador
        morador.sexo = sexoMorador

        var dia  = nascimentoMorador.split("/")[0]
        var mes  = nascimentoMorador.split("/")[1]
        var ano  = nascimentoMorador.split("/")[2]

        var dataFormatada = "$ano-$mes-$dia"

        val formatter = LocalDate.parse(dataFormatada)
        morador.dataNascimento = formatter.toString()

        pesquisa.moradores = listOf(morador)
        return pesquisa

    }
}