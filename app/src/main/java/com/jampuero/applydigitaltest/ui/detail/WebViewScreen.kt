package com.jampuero.applydigitaltest.ui.detail

import android.content.Context
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewScreen(
    url: String,
    onBackPressed: () -> Unit
) {
    val context :Context = LocalContext.current
    val webView = remember { WebView(context) }

    LaunchedEffect(url) {
        webView.loadUrl(url)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { paddingValues ->
            AndroidView(
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                factory = {
                    webView.apply {
                        settings.javaScriptEnabled = true
                    }
                }
            )
        }
    )
}