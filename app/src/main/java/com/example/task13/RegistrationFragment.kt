package com.example.task13

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.task13.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    lateinit var interf:OpenNew
    lateinit var binding: FragmentRegistrationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registration.setOnClickListener {
            UserData.Login = binding.login.text.toString()
            UserData.Password = binding.password.text.toString()
            interf.saveNewData()
            Navigation.findNavController(binding.root).navigate(R.id.toLogin)
        }
        binding.exit.setOnClickListener {
            interf.exit()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OpenNew){
            interf = context
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()


    }
}