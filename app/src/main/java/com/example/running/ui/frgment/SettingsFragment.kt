package com.example.running.ui.frgment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.running.R
import com.example.running.di.other.Constants.KEY_NAME
import com.example.running.di.other.Constants.KEY_WEIGHT
import com.example.running.ui.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import java.security.Key
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings){

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFieldsFromSharedPref()


        btnApplyChanges.setOnClickListener {
            val success = applyChagesToSharedPref()
            if (success){
                Snackbar.make(view, "Saved changes", Snackbar.LENGTH_LONG).show()

            }else{
                Snackbar.make(view, "Please fill out all", Snackbar.LENGTH_LONG).show()

            }
        }

    }

    private fun loadFieldsFromSharedPref(){
        val name = sharedPreferences.getString(KEY_NAME, "")
        val weigth = sharedPreferences.getFloat(KEY_WEIGHT, 80f)
        etName.setText(name)
        etWeight.setText(weigth.toString())
    }

    private fun applyChagesToSharedPref(): Boolean{
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()
        if (nameText.isEmpty()  || weightText.isEmpty()){
            return false
        }
        sharedPreferences.edit()
            .putString(KEY_NAME,nameText)
            .putFloat(KEY_WEIGHT, weightText.toFloat())
            .apply()
        val toolbarText = "Let's go $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }

}