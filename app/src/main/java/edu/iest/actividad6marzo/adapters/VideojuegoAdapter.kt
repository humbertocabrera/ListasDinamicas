package edu.iest.actividad6marzo.adapters

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iest.actividad6marzo.R
import edu.iest.actividad6marzo.models.Videojuego


class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, context: Context) {
    //El ArrayList lo hacemos refiriendose a la class que tengo en la carpeta models
    var innerVideojuegos: ArrayList<Videojuego> = videojuegos
    var innerContext: Context = context

    //Los dos puntos indican que lo que sigue de ellos es la clase de la cual queremos heredar
    // algo de ella
    inner class ContenedorDeVista(view: View):
            RecyclerView.ViewHolder(view){
                ///Aquí haremos la asignación de objetos
                val tituloJuego : TextView
                val precio : TextView
                val fotoJuego : ImageView
                val consola : TextView
                val bnComprar : Button

                init {
                    //Asociamos las variables creadas arriba con los elementos de la vista
                    // con la que estamos trabajando.
                    tituloJuego = view.findViewById(R.id.tituloJuego)
                    precio = view.findViewById(R.id.precio)
                    fotoJuego = view.findViewById(R.id.fotoJuego)
                    consola = view.findViewById(R.id.consola)
                    bnComprar = view.findViewById(R.id.bnComprar)
                }
            }
}