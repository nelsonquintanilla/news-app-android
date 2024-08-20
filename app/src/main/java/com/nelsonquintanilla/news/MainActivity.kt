package com.nelsonquintanilla.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.nelsonquintanilla.news.ui.navigation.ArticlesApp
import com.nelsonquintanilla.news.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsTheme {
                ArticlesApp()
//                Scaffold(
//                    topBar = {
//                        TopAppBar(
//                            title = { Text(text = "News") }
//                        )
//                    }
//                ) { innerPadding ->
//                    val modifier = Modifier
//                        .padding(
//                            start = 16.dp,
//                            end = 16.dp
//                        )
//                    ArticlesScreen(
//                        modifier = modifier.fillMaxWidth(),
//                        contentPadding = innerPadding
//                    )
//                }
            }
        }
    }
}