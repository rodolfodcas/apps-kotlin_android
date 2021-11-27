package com.rodolfod.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //En esta variable hacemos referencia a que es un boton, ademas de buscar el id del boton
        val rollButton: Button = findViewById(R.id.button)

        //Aqui hacemos el evento de escucha, mediante el boton esta esperando un evento de click y hacer click, se inicia el codigo o la activity
        rollButton.setOnClickListener { rollDice() }

        //Aqui iniciamos lanzando un dado por primera vez, para que no se vea vacia la app, al abrirla por primera vez
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6) //Aqui se define el tamaño de numsides, haciendo una instancia a la clase Dice
        val diceRoll = dice.roll() // Aqui guardamos en una variable la funcion apuntando a la clase Dice, quwe es calcuklar numeris aleatorios hasta numsides
        val diceImage: ImageView = findViewById(R.id.imageView) //aqui buscamos los recursos, que son las imagenes y se encuentras mediante id

        /*En las siguientes lineas actualizamos las imagenes, dependienedo de la funcion Roll, que va calculando numeros aleatorios*/

        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            2 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Aqui se esta haciendo referencia a la variable declarada antes del condiconal when, para estala actualizando
        diceImage.setImageResource(drawableResource)

        //aqui se hace referencia a leer en voz alta la descripcion
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}