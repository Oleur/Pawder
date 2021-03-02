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
package com.example.androiddevchallenge.ui.pet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.size.Scale
import com.example.androiddevchallenge.PetViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.PetInfo
import com.example.androiddevchallenge.ui.theme.blueDark
import com.example.androiddevchallenge.ui.theme.blueLight
import com.example.androiddevchallenge.ui.theme.dark
import com.example.androiddevchallenge.ui.theme.greenDark
import com.example.androiddevchallenge.ui.theme.greenLight
import com.example.androiddevchallenge.ui.theme.orangeDark
import com.example.androiddevchallenge.ui.theme.orangeLight
import com.example.androiddevchallenge.ui.theme.redDark
import com.example.androiddevchallenge.ui.theme.redLight
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetDetailScreen(petId: Int, viewModel: PetViewModel) {
    val context = LocalContext.current

    viewModel.getPet(petId)

    val pet = viewModel.pet.collectAsState().value
    checkNotNull(pet) { return }

    val scrollState = rememberScrollState()

    ConstraintLayout {
        val (backdrop, body, button) = createRefs()

        CoilImage(
            data = pet.imageUrl,
            contentScale = ContentScale.Crop,
            requestBuilder = {
                scale(Scale.FILL)
            },
            fadeIn = true,
            contentDescription = "",
            modifier = Modifier
                .constrainAs(backdrop) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .fillMaxWidth()
                .height(400.dp)
                .graphicsLayer {
                    translationY = -scrollState.value * 0.33f
                }
        )

        Column(modifier = Modifier
            .constrainAs(body) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            .fillMaxWidth()
            .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(364.dp)
            )
            PetDetails(pet = pet)
        }

        Button(
            shape = RoundedCornerShape(24.dp),
            onClick = {  },
            modifier = Modifier
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 32.dp)
                }
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 32.dp, end = 32.dp)
        ) {
            Text(
                text = context.getString(R.string.adopt),
                style = typography.h5.copy(color = dark),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun PetDetails(pet: Pet) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .graphicsLayer {
                shadowElevation = 4.dp.toPx()
            }
            .background(
                colors.surface,
                RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            )
            .padding(bottom = 112.dp)
    ) {
        val context = LocalContext.current
        val (name, breed, mapImg, mapText, sectionAbout, sectionDetails, rowDetails, about) = createRefs()

        Text(
            text = pet.name,
            style = typography.h3,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Text(
            text = pet.breed,
            style = typography.subtitle1,
            modifier = Modifier
                .constrainAs(breed) {
                    top.linkTo(name.bottom, margin = 4.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Text(
            text = pet.breed,
            style = typography.subtitle1,
            modifier = Modifier
                .constrainAs(breed) {
                    top.linkTo(name.bottom, margin = 4.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_map_24),
            contentDescription = "Map Icon",
            modifier = Modifier
                .constrainAs(mapImg) {
                    top.linkTo(breed.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Text(
            text = "All around the world!",
            style = typography.body1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(mapText) {
                    start.linkTo(mapImg.end, margin = 8.dp)
                    bottom.linkTo(mapImg.bottom)
                    top.linkTo(mapImg.top)
                }
                .wrapContentWidth()
        )

        Text(
            text = context.getString(R.string.details),
            style = typography.h5,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(sectionDetails) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(mapImg.bottom, margin = 32.dp)
                }
                .wrapContentWidth()
        )

        Row(
            modifier = Modifier
                .constrainAs(rowDetails) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(sectionDetails.bottom, margin = 4.dp)
                }
                .height(166.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            pet.infoList.forEachIndexed { index, petInfo ->
                PetInfoCard(index % 4, petInfo)
            }
            Spacer(modifier = Modifier.size(16.dp))
        }

        Text(
            text = context.getString(R.string.about),
            style = typography.h5,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(sectionAbout) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(rowDetails.bottom, margin = 24.dp)
                }
                .wrapContentWidth()
        )

        Text(
            text = pet.desc,
            style = typography.subtitle1,
            modifier = Modifier
                .constrainAs(about) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(sectionAbout.bottom, margin = 4.dp)
                }
                .wrapContentWidth()
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun PetInfoCard(position: Int, info: PetInfo) {
    val bgColors = arrayListOf(
        orangeLight, blueLight, redLight, greenLight
    )
    val bgDarkColors = arrayListOf(
        orangeDark, blueDark, redDark, greenDark
    )

    Card(
        backgroundColor = bgColors[position],
        elevation = 8.dp,
        modifier = Modifier
            .padding(start = 16.dp)
            .size(150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = info.category,
                textAlign = TextAlign.Center,
                style = typography.h6.copy(color = dark),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                .wrapContentWidth()
                .wrapContentWidth()
            ) {
                CircularProgressIndicator(
                    progress = info.value/100f,
                    color = bgDarkColors[position],
                    strokeWidth = 8.dp,
                    modifier = Modifier.size(56.dp)
                )
                CircularProgressIndicator(
                    progress = 1f,
                    color = bgDarkColors[position],
                    strokeWidth = 4.dp,
                    modifier = Modifier.size(52.dp).alpha(0.25f)
                )
                Text(
                    text = "${info.value}%",
                    textAlign = TextAlign.Center,
                    style = typography.body1.copy(fontWeight = FontWeight.Medium)
                )
            }
        }
    }
}