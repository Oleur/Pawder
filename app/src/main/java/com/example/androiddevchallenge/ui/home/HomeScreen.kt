package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import coil.size.Scale
import com.example.androiddevchallenge.PetViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.common.transformation.LinearGradientTransformation
import com.example.androiddevchallenge.ui.theme.orange
import dev.chrisbanes.accompanist.coil.CoilImage

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
                            bottomEnd = min(100.dp, 100.dp - offset.toDp().coerceAtMost(100.dp)),
                            bottomStart = min(100.dp, 100.dp - offset.toDp().coerceAtMost(100.dp))
                        )
                    } else {
                        translationY = (-132).dp.toPx()
                        shape = RoundedCornerShape(
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    }
                }
                .background(orange)
        )

        Text(
            text = context.getString(R.string.app_name),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            ),
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
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Monospace,
                fontStyle = FontStyle.Italic
            ),
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
                            .height(100.dp))
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
            navController.navigate("pet/${pet.id}}")
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
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily.Monospace
                    ),
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
                    contentDescription = "",
                    modifier = Modifier
                        .constrainAs(pawImg) {
                            bottom.linkTo(image.bottom)
                            start.linkTo(image.start)
                        }
                        .padding(bottom = 8.dp, start = 8.dp)
                )

                Text(
                    text = "age: ${pet.age} months",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Monospace
                    ),
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
