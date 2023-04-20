package edu.iest.actividad6marzo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import edu.iest.actividad6marzo.R
import edu.iest.actividad6marzo.models.Videojuego


class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, context: Context) :
    RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista> (){
    //El ArrayList lo hacemos refiriendose a la class que tengo en la carpeta models
    var innerVideojuegos: ArrayList<Videojuego> = videojuegos
    var innerContext: Context = context

    //Los dos puntos indican que lo que sigue de ellos es la clase de la cual queremos heredar
    // algo de ella
    inner class ContenedorDeVista(view: View):
            RecyclerView.ViewHolder(view), View.OnClickListener {
                ///Aquí haremos la asignación de objetos
                val tituloJuego : TextView
                val precio : TextView
                val fotoJuego : ImageView
                val consola : TextView
                val clasificacion: TextView
                val bnComprar : Button

                init {
                    //Asociamos las variables creadas arriba con los elementos de la vista
                    // con la que estamos trabajando.
                    tituloJuego = view.findViewById(R.id.tituloJuego)
                    precio = view.findViewById(R.id.precio)
                    fotoJuego = view.findViewById(R.id.fotoJuego)
                    consola = view.findViewById(R.id.consola)
                    clasificacion = view.findViewById(R.id.clasificacion)
                    bnComprar = view.findViewById(R.id.bnComprar)

                    bnComprar.setOnClickListener(this)
                }

        //
        override fun onClick(p0: View?) {
            //Aqui ocupamos pasa el contexto que definimos arriba
            val miSharedPreferences = innerContext.getSharedPreferences("PERSISTENCIA",
                AppCompatActivity.MODE_PRIVATE)
            val edad = miSharedPreferences.getInt("edad", 5)


            if(adapterPosition >= 0){
                val videojuego: Videojuego = innerVideojuegos.get(adapterPosition)
                if (edad <= 5 && (videojuego.clasificacion == "R" ||
                            videojuego.clasificacion == "T")){
                    val toast = Toast.makeText(innerContext,
                        "No tienes la edad para comprar", Toast.LENGTH_SHORT).show()
                }else{
                    val toast = Toast.makeText(innerContext, "Comprado",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //Se crean estos tres elementos dado que daba error al agregar :
    //    RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista> ()

    //Que vista queremos repetir
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_2, parent, false)

        return ContenedorDeVista(view)
    }

    //Que información se muestra
    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val videojuego: Videojuego = innerVideojuegos.get(position)
        holder.tituloJuego.text = videojuego.nombre
        holder.consola.text = videojuego.consola
        holder.clasificacion.text = videojuego.clasificacion
        holder.precio.text = videojuego.precio.toString()
        holder.fotoJuego.setImageResource(videojuego.imagen)
    }

    //Cuantas veces la vamos a repetir
    override fun getItemCount(): Int {
        return innerVideojuegos.size
    }
}