package edu.iest.actividad6marzo

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.iest.actividad6marzo.adapters.VideojuegoAdapter
import edu.iest.actividad6marzo.models.FakerVideojuego

class ListaJuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_juegos_activity)

        //Creamos variables para relacionarlas con los elementos de la vista
        val fabPreferencias = findViewById<FloatingActionButton>(R.id.floatActButton)
        val btnOrientacion = findViewById<Button>(R.id.orientacion)
        val btnDosColumnas = findViewById<Button>(R.id.dosColumnas)
        val btnTresColumnas = findViewById<Button>(R.id.tresColumnas)

        //Llamamos a la clase Faker Videjuegos para obtener la lista de juegos con la función
        //getVideogames
        val juegos = FakerVideojuego().getVideogames()

        //Creamos una variable para relacionar el RecyclerView de la vista
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        var isPortrait = true

        // este se usa si nuestro layout fuera de grid
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )



        //val CANTIDAD_COLUMNAS = 2
        //val administradorDeLayouts = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        //LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //GridLayoutManager(this, CANTIDAD_COLUMNAS)

        //  usamos el administrador de layouts para utilizar nuestro layout de juego para el
        //  recycler view con Linear layout
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = VideojuegoAdapter(juegos, this)

        fabPreferencias.setOnClickListener{
            val i = Intent(this, preferencias::class.java)
            startActivity(i)
        }

        btnOrientacion.setOnClickListener{
            // if isPortrait true, change to Landscape
            requestedOrientation = if (isPortrait) {
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                // else change to Portrait
            } else {
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
            // opposite the value of isPortrait
            isPortrait = !isPortrait
        }

        btnDosColumnas.setOnClickListener {
            val gridLayoutManager = GridLayoutManager(this, 2)
            recycler.layoutManager = gridLayoutManager
        }

        btnTresColumnas.setOnClickListener {
            val gridLayoutManager = GridLayoutManager(this, 3)
            recycler.layoutManager = gridLayoutManager
        }

    }
}