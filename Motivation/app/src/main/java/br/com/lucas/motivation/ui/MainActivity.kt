package br.com.lucas.motivation.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lucas.motivation.databinding.ActivityMainBinding
import br.com.lucas.motivation.infra.MotivationConstants
import br.com.lucas.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)
        binding.txtName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)


    }

}