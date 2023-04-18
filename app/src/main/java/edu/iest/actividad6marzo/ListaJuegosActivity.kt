package edu.iest.actividad6marzo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.iest.actividad6marzo.adapters.VideojuegoAdapter
import edu.iest.actividad6marzo.models.FakerVideojuego

class ListaJuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_juegos_activity)

        val fabPreferencias = findViewById<FloatingActionButton>(R.id.floatActButton)

        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        val CANTIDAD_COLUMNAS = 2
        val administradorDeLayouts = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        //LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //GridLayoutManager(this, CANTIDAD_COLUMNAS)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)

        fabPreferencias.setOnClickListener{
            val i = Intent(this, preferencias::class.java)
            startActivity(i)
        }

    }
}