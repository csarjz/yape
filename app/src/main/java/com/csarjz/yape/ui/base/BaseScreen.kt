package com.csarjz.yape.ui.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.csarjz.yape.ui.theme.YapeTheme

@Composable
fun BaseScreen(content: @Composable () -> Unit) {
    YapeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            content()
        }
    }
}
