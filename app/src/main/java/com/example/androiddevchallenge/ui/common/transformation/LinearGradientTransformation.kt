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
package com.example.androiddevchallenge.ui.common.transformation

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import coil.bitmap.BitmapPool
import coil.size.Size
import coil.transform.Transformation

class LinearGradientTransformation(
    private val id: String
) : Transformation {

    override fun key() = "image_$id"

    override suspend fun transform(pool: BitmapPool, input: Bitmap, size: Size): Bitmap {
        val x: Int = input.width
        val y: Int = input.height

        val gradientBitmap: Bitmap = input.copy(input.config, true)
        val canvas = Canvas(gradientBitmap)

        val startColor = Color.parseColor("#FF535353")
        val endColor = Color.TRANSPARENT

        val grad =
            LinearGradient(x / 2f, y.toFloat(), x / 2f, y / 2f, startColor, endColor, Shader.TileMode.CLAMP)

        canvas.drawPaint(
            Paint(Paint.DITHER_FLAG).apply {
                shader = null
                isDither = true
                isFilterBitmap = true
                shader = grad
            }
        )
        input.recycle()
        return gradientBitmap
    }
}
