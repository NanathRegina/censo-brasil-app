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

class MoradorTela : Fragment() {

    private var _binding: MoradorTelaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<MoradorTelaArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = MoradorTelaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.indicator.setProgressCompat(30, true)
        //Log.i("tesste", args.tipoPesquisa)
        binding.buttonMorador.setOnClickListener {
            Log.i("a hora da verdade", getInput().toString())
            //var quantidadePessoas = getInput()
            //quantidadePessoas.put("", args.tipoPesquisa)
            //findNavController().navigate(R.id.action_MoradorTela_to_InfoMoradorTela)
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
            //(findViewById(radioGroup.getCheckedRadioButtonId()) as RadioButton).text.toString()
        //val sexoMorador: String = sexoInputLayout.editText?.text.toString()

        val nascimentoInputLayout: TextInputLayout = requireView().findViewById(R.id.input_nascimento)
        val nascimentoMorador: String = nascimentoInputLayout.editText?.text.toString()

        var pesquisa = args.pesquisa

        var morador = Morador()
        morador.nome= nomeMorador
        morador.sobrenome = sobrenomeMorador
        morador.sexo = sexoMorador
        morador.dataNascimento = nascimentoMorador

        pesquisa.moradores = listOf(morador)


        /*
        val pesquisaJson = JSONObject()
        pesquisaJson.put("nome", nomeMorador)
        pesquisaJson.put("sobrenome", sobrenomeMorador)
        pesquisaJson.put("sexo", sexoMorador)
        pesquisaJson.put("dataNascimento", nascimentoMorador)
        pesquisaJson.put("",args.)
        Log.d("output", pesquisaJson.toString())
*/
        return pesquisa

    }
}