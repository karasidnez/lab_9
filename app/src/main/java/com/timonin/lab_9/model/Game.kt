package com.timonin.lab_9.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Game(
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @DrawableRes val imageResourceId: Int
)