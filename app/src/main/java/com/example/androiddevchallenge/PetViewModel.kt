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
package com.example.androiddevchallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetViewModel @Inject constructor(
    private val repository: PetRepository
) : ViewModel() {

    val pets = MutableStateFlow<List<Pet>>(emptyList())
    val pet = MutableStateFlow<Pet?>(null)

    fun getPets() = viewModelScope.launch(Dispatchers.IO) {
        pets.emit(repository.getPets())
    }

    fun getPet(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        pet.emit(repository.getPet(id))
    }
}