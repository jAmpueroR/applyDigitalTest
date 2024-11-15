package com.jampuero.applydigitaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.jampuero.applydigitaltest.ui.NavGraph
import com.jampuero.applydigitaltest.ui.list.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: PostViewModel = hiltViewModel()
            NavGraph(viewModel)
        }
    }
}

