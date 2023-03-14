package edu.iest.actividad6marzo.models

import android.provider.MediaStore.Video
import edu.iest.actividad6marzo.R

class FakerVideojuego {


    fun getVideogames() : ArrayList<Videojuego>{
        var videogames: ArrayList<Videojuego>
        videogames = arrayListOf<Videojuego>()

        var videojuego = Videojuego(1,"Valorant", precio = 249F,
            "PC", R.drawable.valorant)
        videogames.add(videojuego)

        videogames.add(Videojuego(2,"Overwatch", precio = 1000F,
            "Multi", R.drawable.overwatch))
        videogames.add(Videojuego(3,"Minecraft", precio = 500F,
            "Multi", R.drawable.minecraft))
        videogames.add(Videojuego(4,"Mario Bros", precio = 1600F,
            "Nintendo", R.drawable.mario))
        videogames.add(Videojuego(5,"Halo", precio = 1600F,
            "Xbox", R.drawable.halo))
        videogames.add(Videojuego(6,"Resident Evil 4", precio = 1000F,
            "Multi", R.drawable.game04))
        videogames.add(Videojuego(6,"Tales of the Abyss", precio = 700F,
            "Playstation", R.drawable.abyss))

        return videogames
    }
}