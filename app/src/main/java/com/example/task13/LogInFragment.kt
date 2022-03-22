package com.example.task13
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.task13.databinding.FragmentLoginBinding
import java.util.*

class LogInFragment : Fragment() {
    lateinit var interf:OpenNew
    lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.login.setOnClickListener {
            UserData.Login = binding.LogIn.text.toString()
            UserData.Password = binding.password.text.toString()
            if(interf.checkData()){
                Navigation.findNavController(binding.root).navigate(R.id.toHome)
            }
            else{
                Navigation.findNavController(binding.root).navigate(R.id.toRegistration)
            }
        }
        binding.registration.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.toRegistration)
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
        fun newInstance() = LogInFragment()
    }

}