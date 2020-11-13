package br.com.lucas.motivation.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.lucas.motivation.R
import br.com.lucas.motivation.databinding.ActivityMainBinding
import br.com.lucas.motivation.infra.MotivationConstants
import br.com.lucas.motivation.infra.SecurityPreferences
import br.com.lucas.motivation.repository.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mphraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        binding.txtName.text = resources.getString(R.string.hello, name)

        //logica initial de selecao
        binding.imgAll.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()


        binding.btnNewPhrase.setOnClickListener(this)
        binding.imgAll.setOnClickListener(this)
        binding.imgHappy.setOnClickListener(this)
        binding.imgMorning.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(R.id.imgAll, R.id.imgHappy, R.id.imgMorning)

        if (id == R.id.btnNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        binding.imgAll.setColorFilter(resources.getColor(R.color.white))
        binding.imgHappy.setColorFilter(resources.getColor(R.color.white))
        binding.imgMorning.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            R.id.imgAll -> {
                binding.imgAll.setColorFilter(resources.getColor(R.color.colorAccent))
                mphraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.imgHappy -> {
                binding.imgHappy.setColorFilter(resources.getColor(R.color.colorAccent))
                mphraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imgMorning -> {
                binding.imgMorning.setColorFilter(resources.getColor(R.color.colorAccent))
                mphraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }

    private fun handleNewPhrase() {
        val phrase = Mock().getPhrase(mphraseFilter)
        binding.txtPhrase.text = phrase
    }

}