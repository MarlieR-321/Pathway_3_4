package ni.edu.uca.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<View>(R.id.btnRoll) as Button
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG).show()
            val txtRoll = findViewById<View>(R.id.txtRoll) as TextView

            //Crea objetos con su numero de lados y manda la funcion en el texto
            val dice = Dice(5)
            txtRoll.text = "${dice.roll()}"
        }
    }
}

class Dice(private val numSides: Int) {

    //Regresa un numero random
    fun roll(): Int {
        return (1..numSides).random()
    }
}