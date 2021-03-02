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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import coil.size.Scale
import com.example.androiddevchallenge.PetViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.common.transformation.LinearGradientTransformation
import com.example.androiddevchallenge.ui.theme.orange
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage

private val listHeaderSize = 100.dp
private val maxElevation = 8.dp

@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel: PetViewModel, navController: NavController) {
    val pets = viewModel.pets.collectAsState()

    val listState = rememberLazyListState()
    val context = LocalContext.current

    ConstraintLayout {
        val (backdrop, title, pawImg, subtitle) = createRefs()

        val offset = listState.firstVisibleItemScrollOffset.toFloat()

        Box(
            Modifier.constrainAs(backdrop) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }.fillMaxWidth()
                .height(200.dp)
                .graphicsLayer {
                    clip = true
                    if (listState.firstVisibleItemIndex == 0) {
                        translationY = -offset * 1.32f
                        shape = RoundedCornerShape(
                            bottomEnd = min(listHeaderSize, listHeaderSize - offset.toDp().coerceAtMost(listHeaderSize)),
                            bottomStart = min(listHeaderSize, listHeaderSize - offset.toDp().coerceAtMost(listHeaderSize))
                        )
                        shadowElevation = kotlin.math.max(0f, maxElevation.toPx() * offset / listHeaderSize.toPx())
                    } else {
                        translationY = (-132).dp.toPx()
                        shape = RoundedCornerShape(
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                        shadowElevation = maxElevation.toPx()
                    }
                }
                .background(orange)
        )

        Text(
            text = context.getString(R.string.app_name),
            style = typography.h4,
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .wrapContentWidth()
                .padding(16.dp)
        )

        Text(
            text = context.getString(R.string.app_desc),
            style = typography.caption,
            modifier = Modifier
                .constrainAs(subtitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom)
                }
                .wrapContentWidth()
                .graphicsLayer {
                    alpha = if (listState.firstVisibleItemIndex == 0) {
                        kotlin.math.min(1f, 1 - (offset / 50.dp.toPx()))
                    } else {
                        0f
                    }
                }
        )
        
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_pets_24),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(pawImg) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(top = 24.dp, end = 24.dp)
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            state = listState,
            modifier = Modifier.padding(top = 72.dp, start = 8.dp, end = 8.dp),
            content = {
                items(pets.value.size + 2 /* Spacer */) {
                    if (it <= 1) {
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(listHeaderSize))
                    } else {
                        PetItem(pet = pets.value[it - 2], navController)
                    }
                }
            }
        )
    }
}

@Composable
fun PetItem(pet: Pet, navController: NavController) {
    Button(
        onClick = {
            navController.navigate("pet/${pet.id}")
        },
        shape = MaterialTheme.shapes.large,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.dp)
    ) {
        Card(
            shape = MaterialTheme.shapes.large,
            elevation = 16.dp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ConstraintLayout {
                val (image, name, pawImg, age) = createRefs()

                CoilImage(
                    data = pet.imageUrl,
                    contentScale = ContentScale.Crop,
                    requestBuilder = {
                        scale(Scale.FILL)
                        transformations(LinearGradientTransformation(pet.imageUrl))
                    },
                    fadeIn = true,
                    contentDescription = "",
                    modifier = Modifier
                        .constrainAs(image) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }
                        .fillMaxWidth()
                        .height(300.dp)
                )

                Text(
                    text = pet.name,
                    style = typography.h6,
                    modifier = Modifier
                        .constrainAs(name) {
                            bottom.linkTo(pawImg.top)
                            start.linkTo(image.start)
                        }
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .padding(8.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_pets_24),
                    contentDescription = "Paw Icon",
                    modifier = Modifier
                        .constrainAs(pawImg) {
                            bottom.linkTo(image.bottom)
                            start.linkTo(image.start)
                        }
                        .padding(bottom = 8.dp, start = 8.dp)
                )

                Text(
                    text = "age: ${pet.age} months",
                    style = typography.body2.copy(fontWeight = FontWeight.Medium),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .constrainAs(age) {
                            start.linkTo(pawImg.end)
                            bottom.linkTo(pawImg.bottom)
                            top.linkTo(pawImg.top)
                        }
                        .wrapContentWidth()
                        .padding(bottom = 8.dp, start = 8.dp)
                )
            }
        }
    }

}
