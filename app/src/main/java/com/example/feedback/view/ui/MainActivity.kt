package com.example.feedback.view.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.feedback.R
import com.example.feedback.databinding.ActivityMainBinding
import com.example.feedback.factory.AppViewModelFactory
import com.example.feedback.utils.vm
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, MainActivityViewModel::class) }
    private lateinit var binding: ActivityMainBinding
    var spinnerValue = arrayOf("Quality", "Color", "Material", "Design")
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        setSpinnerValue()
    }


    private fun setSpinnerValue() {
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerValue)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        with(spinner)
        {
            adapter = aa
        }
    }
}