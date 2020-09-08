package br.com.lucas.exercicio102

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkColor.setOnClickListener(this);

    }

    override fun onClick(view: View) {
        val id = view.id;
        if (id == R.id.checkColor) {
            changeColor();
        }
    }


    private fun changeColor() {
        if (checkColor.isChecked) {
            imgColor.setColorFilter(
                resources.getColor(R.color.colorPrimaryDark)
            )
        } else {
            imgColor.setColorFilter(
                resources.getColor(R.color.black)
            )
        }
    }

}