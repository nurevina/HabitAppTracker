package com.dicoding.habitapp.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dicoding.habitapp.databinding.ActivityAuthenticationBinding
import com.dicoding.habitapp.ui.ViewModelFactory

class AuthenticationActivity : AppCompatActivity() {

    private val binding : ActivityAuthenticationBinding by lazy {
        ActivityAuthenticationBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        binding.rgaction.setOnCheckedChangeListener { radioGroup, radioButton, checked, checkedId ->
            Toast.makeText(
                this@AuthenticationActivity,
                "$checkedId and ${radioButton?.id}",
                Toast.LENGTH_SHORT
            ).show()
        }

        viewModel.onGetAuthUiType.observe(
            this,::onGetUiType
        )
    }

    private fun onGetUiType(type : AuthUIType){
        when(type){
            AuthUIType.SIGN_IN -> setupSignInView()
            AuthUIType.SIGN_UP -> setupSignUpView()
        }
    }

    private fun setupSignInView(){
        binding.rbSignIn.isSelected = true
        binding.fullname.visibility = View.GONE
    }
    private fun setupSignUpView(){
        binding.rbSignUp.isSelected = false
        binding.fullname.visibility = View.VISIBLE
    }
}