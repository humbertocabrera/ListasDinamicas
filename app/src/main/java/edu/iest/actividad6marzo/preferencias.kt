package edu.iest.actividad6marzo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView

class preferencias : AppCompatActivity() {

    //Inicilaizamos las variables
    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvAltura: TextView
    private lateinit var tvMonedero: TextView

    //Asignamos las llaves para usar las preferencias
    private val NOMBRE_KEY = "nombre"
    private val EDAD_KEY = "edad"
    private val ALTURA_KEY = "altura"
    private val MONEDERO_KEY = "monedero"

    //Seteamos las variables
    private var nombre: String =  ""
    private var edad: Int = 0
    private var altura: Float = 0F
    private var monedero: Float = 0F

    //Función OnCreate. El código dentro de la función corre al crearse la aplicación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias)

        getPreferences()

        //Botón de regresar
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnRegresar.setOnClickListener{
            val i = Intent(this, ListaJuegosActivity::class.java)
            startActivity(i)
        }
    }

    //Función para obtener los datos de la preferencias
    private fun getPreferences(){
        //Linkeamos los elementos del View con las variables previamente inicializadas
        tvNombre = findViewById(R.id.tvNombrePref)
        tvEdad  = findViewById(R.id.tvEdadPref)
        tvAltura = findViewById(R.id.tvAlturaPref)
        tvMonedero = findViewById(R.id.tvMonederoPref)

        if(TextUtils.isEmpty(nombre)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            nombre = miSharedPreferences.getString(NOMBRE_KEY,"").toString()
            edad = miSharedPreferences.getInt(EDAD_KEY,0)
            altura = miSharedPreferences.getFloat(ALTURA_KEY,0F)
            monedero = miSharedPreferences.getFloat(MONEDERO_KEY,0F)

            tvNombre.setText(nombre)
            tvEdad.setText(edad.toString())
            tvAltura.setText(altura.toString())
            tvMonedero.setText(monedero.toString())
        }
    }

}