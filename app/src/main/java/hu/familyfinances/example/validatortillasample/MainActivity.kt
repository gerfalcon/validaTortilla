package hu.familyfinances.example.validatortillasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import hu.familyfinances.example.validatortillasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.registrationRegister.setOnClickListener {
            viewModel.onRegisterClicked()
        }
    }
}