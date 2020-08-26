package br.com.lucas.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id;
        if (id == R.id.btnCalc) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOk()) {
            try {
                val distance = edtDistance.text.toString().toFloat()
                val price = edtPrice.text.toString().toFloat()
                val autonomy = edtAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                txtValue.text = "R$ ${"%.2f".format(totalValue)}"
            } catch (error: Exception) {
                Toast.makeText(this, getString(R.string.validation_nan), Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.btnCalc_validation), Toast.LENGTH_SHORT)
                .show()
        }

    }

    private fun validationOk(): Boolean = (edtPrice.text.trim().toString().isNotEmpty() &&
            edtDistance.text.trim().toString().isNotEmpty() &&
            edtAutonomy.text.trim().toString().isNotEmpty() &&
            edtAutonomy.text.trim().toString() != "0")
}