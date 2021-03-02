package com.example.androiddevchallenge.data

data class Pet(
    val id: Int,
    val name: String,
    val desc: String,
    val imageUrl: String,
    val age: Int,
    val breed: String,
    val infoList: List<PetInfo>
)

data class PetInfo(
    val category: String,
    val value: Int
)