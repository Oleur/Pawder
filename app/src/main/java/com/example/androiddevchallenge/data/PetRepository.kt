package com.example.androiddevchallenge.data

import javax.inject.Inject

class PetRepository @Inject constructor() {

    fun getPets() = pets

    fun getPet(id: Int): Pet? = pets.find { it.id == id }

    companion object {
        private val pets = listOf(
            Pet(
                id = 0,
                name = "Alpha",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3726314/pexels-photo-3726314.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 2,
                breed = "Husky"
            ),
            Pet(
                id = 1,
                name = "Banjo",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3860304/pexels-photo-3860304.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 3,
                breed = "Labrador"
            ),
            Pet(
                id = 2,
                name = "Carlos",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/4587998/pexels-photo-4587998.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 1,
                breed = "Bulldog"
            ),
            Pet(
                id = 3,
                name = "Raymond",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3976279/pexels-photo-3976279.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 18,
                breed = "Cocker"
            ),
            Pet(
                id = 4,
                name = "Mavrix",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/1390361/pexels-photo-1390361.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 48,
                breed = "Cavalier King Charles"
            ),
            Pet(
                id = 5,
                name = "Jungle",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/2664417/pexels-photo-2664417.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 1,
                breed = "Corgi"
            ),
            Pet(
                id = 6,
                name = "Barney",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/4588030/pexels-photo-4588030.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
                age = 4,
                breed = "Shar Pei"
            ),
            Pet(
                id = 7,
                name = "Damian",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3763313/pexels-photo-3763313.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
                age = 2,
                breed = "Dalmatian"
            )
        )
    }
}