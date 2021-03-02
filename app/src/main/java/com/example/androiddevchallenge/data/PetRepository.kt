/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
                desc = "Dogs (Canis lupus familiaris) are domesticated mammals, not natural wild animals. They were originally bred from wolves. They have been bred by humans for a long time, and were the first animals ever to be domesticated. ... They are a popular pet because they are usually playful, friendly, loyal and listen to humans.",
                imageUrl = "https://images.pexels.com/photos/3726314/pexels-photo-3726314.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 2,
                breed = "Husky",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 1,
                name = "Banjo",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3860304/pexels-photo-3860304.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 3,
                breed = "Labrador",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 2,
                name = "Carlos",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/4587998/pexels-photo-4587998.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 1,
                breed = "Bulldog",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 3,
                name = "Raymond",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3976279/pexels-photo-3976279.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 18,
                breed = "Cocker",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 4,
                name = "Mavrix",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/1390361/pexels-photo-1390361.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 48,
                breed = "Cavalier King Charles",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 5,
                name = "Jungle",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/2664417/pexels-photo-2664417.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 1,
                breed = "Corgi",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 6,
                name = "Barney",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/4588030/pexels-photo-4588030.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
                age = 4,
                breed = "Shar Pei",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 7,
                name = "Damian",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3763313/pexels-photo-3763313.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
                age = 2,
                breed = "Dalmatian",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 8,
                name = "Hector",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/4130054/pexels-photo-4130054.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 23,
                breed = "Golden Retriever",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 9,
                name = "Fritz",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/374898/pexels-photo-374898.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 32,
                breed = "Pug",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            ),
            Pet(
                id = 10,
                name = "Edou",
                desc = "",
                imageUrl = "https://images.pexels.com/photos/3361739/pexels-photo-3361739.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
                age = 43,
                breed = "Shi Tzu",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                )
            )
        )
    }
}
