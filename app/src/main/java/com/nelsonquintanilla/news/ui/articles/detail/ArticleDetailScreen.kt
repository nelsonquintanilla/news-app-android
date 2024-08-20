package com.nelsonquintanilla.news.ui.articles.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import com.nelsonquintanilla.news.ui.navigation.NavigationDestination

object ArticleDetailDestination : NavigationDestination {
    override val route = "detail"
    const val ITEM_URL_ARG = "item_url_arg"
    val routeWithArgs = "$route/{$ITEM_URL_ARG}"
}

@Composable
fun ArticleDetailScreen(
    onNavigateUp: () -> Unit,
    articlesViewModel: ArticleDetailViewModel = hiltViewModel()
) {
    ArticleDetailScreen(
        detailUiState = articlesViewModel.detailUiState,
        onNavigateUp = onNavigateUp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(
    detailUiState: DetailUiState,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail") },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        ArticleDetailBody(
            detailUiState = detailUiState,
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding()
                )
                .verticalScroll(rememberScrollState())
        )
    }
}

@Composable
fun ArticleDetailBody(
    detailUiState: DetailUiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(text = detailUiState.webUrl)
    }
}
