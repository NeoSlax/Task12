package com.example.task13

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.task13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OpenNew {
    var currentItem:Int = R.id.home
    lateinit var binding:ActivityMainBinding
    lateinit var sharedPtr:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, HomeFragment.newInstance()).commit()
    }

    override fun saveNewData(){
        sharedPtr.edit().putString(UserData.Login, UserData.Login).apply()
        sharedPtr.edit().putString(UserData.Password, UserData.Password).apply()
    }

    override fun checkData():Boolean{
        if(sharedPtr.getString(UserData.Login, null) == UserData.Login && sharedPtr.getString(UserData.Password, null) == UserData.Password) {
            binding.bottomNavigationView.visibility = View.VISIBLE
            return true

        }
        else
            return false
    }

    override fun exit(){
        finishAffinity()
    }
}