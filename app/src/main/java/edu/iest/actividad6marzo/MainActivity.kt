package edu.iest.actividad6marzo

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvBienvenido: TextView
    private lateinit var etNombre: EditText
    private lateinit var etAltura: EditText
    private lateinit var etEdad: EditText
    private lateinit var etMonedero: EditText
    private lateinit var bnGuardar: Button
    private lateinit var switchPreferencias: SwitchCompat
    private val NOMBRE_KEY = "nombre"
    private val ALTURA_KEY = "altura"
    private val EDAD_KEY = "edad"
    private val MONEDERO_KEY = "monedero"
    private val SWITCH_KEY = "switch_estado"
    private val NOMBRE_INSTANCIA = "nombre_instancia"

    private var nombre: String = ""
    private var edad: Int = 0
    private var altura: Float = 0F
    private var monedero: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PREFERENCIAS", "onCreate")
        setContentView(R.layout.activity_main)

        var actionBar: ActionBar?
        actionBar = supportActionBar
        var colorDrawable: ColorDrawable
        colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionBar!!.setBackgroundDrawable(colorDrawable)

        inicializarVistas()

        Log.d("PREFERENCIAS", savedInstanceState?.getString(NOMBRE_KEY).toString())
//nombre = savedInstanceState?.getString(NOMBRE_KEY).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PREFERENCIAS", "onSaveInstanceState")
        outState.putString(NOMBRE_KEY, nombre )
        outState?.run {
            putString(NOMBRE_KEY, nombre)
        }
// call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)

    }

    override fun onResume() {
        Log.d("PREFERENCIAS", "onResume")
        if(TextUtils.isEmpty(nombre)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            //Al tener activo el Switch de Preferences, cuando re-abramos la app deben salir
            //los datos previamente guardados.
            nombre = miSharedPreferences.getString(NOMBRE_KEY, "").toString()
            altura = miSharedPreferences.getFloat(ALTURA_KEY, 0F)
            monedero = miSharedPreferences.getFloat(MONEDERO_KEY, 0F)
            edad = miSharedPreferences.getInt(EDAD_KEY, 0)

        }
        //Seteamos la info en los campos
        etNombre.setText(nombre)
        etAltura.setText(altura.toString())
        etMonedero.setText(monedero.toString())
        etEdad.setText(edad.toString())
        super.onResume()
    }

    override fun onStart() {
        Log.d("PREFERENCIAS", "onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("PREFERENCIAS", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("PREFERENCIAS", "onDestroy")
        super.onDestroy()
    }

    private fun cambiarTextoBienvenida(nombre: String) {
        if (!TextUtils.isEmpty(nombre)) {
            tvBienvenido.text = "Bienvenido"
        }
    }

    private fun inicializarVistas() {
        tvBienvenido = findViewById(R.id.textSize)
        etNombre = findViewById(R.id.etNombre)
        etAltura = findViewById(R.id.etAltura2)
        etEdad = findViewById(R.id.etEdad)
        etMonedero = findViewById(R.id.etMonedero)
        bnGuardar = findViewById(R.id.button)
        switchPreferencias = findViewById(R.id.switchPreferencias)

        bnGuardar.setOnClickListener {
            if(switchPreferencias.isChecked()){

                nombre = etNombre.text.toString()
                altura = etAltura.text.toString().toFloat()
                monedero = etMonedero.text.toString().toFloat()
                edad = Integer.valueOf(etEdad.text.toString())
                cambiarTextoBienvenida(nombre)

                val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
                val editor = miSharedPreferences.edit()

                editor.putString(NOMBRE_KEY, nombre)
                editor.putFloat(ALTURA_KEY, altura)
                editor.putFloat(MONEDERO_KEY, monedero)
                editor.putInt(EDAD_KEY,edad)
                editor.apply()
            }
            //Cambiar de Pantalla va aquí
            val i = Intent(this, ListaJuegosActivity::class.java)
            startActivity(i)
        }

    }
}