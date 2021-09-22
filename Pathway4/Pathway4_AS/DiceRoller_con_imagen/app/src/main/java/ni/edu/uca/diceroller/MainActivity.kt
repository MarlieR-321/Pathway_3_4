package ni.edu.uca.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()

        val rollButton = findViewById<View>(R.id.btnRoll) as Button
        rollButton.setOnClickListener { rollDice() }
    }
    private fun rollDice(){
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage:ImageView = findViewById<ImageView>(R.id.ivDice)

        val drawable = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawable)
        diceImage.contentDescription = diceRoll.toString()
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG).show()
    }
}



class Dice(private val numSides: Int) {

    //Regresa un numero random
    fun roll(): Int {
        return (1..numSides).random()
    }
}