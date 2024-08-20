package com.nelsonquintanilla.news.ui.articles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nelsonquintanilla.news.domain.model.Article
import com.nelsonquintanilla.news.ui.articles.components.ArticleItem
import com.nelsonquintanilla.news.ui.navigation.NavigationDestination
import com.nelsonquintanilla.news.ui.theme.NewsTheme
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object ArticlesDestination : NavigationDestination {
    override val route = "articles"
}

@Composable
fun ArticlesScreen(
    navigateToArticleDetail: (String) -> Unit,
    viewModel: ArticlesViewModel = hiltViewModel()
) {
    ArticlesScreen(
        uiState = viewModel.uiState,
        onItemClick = navigateToArticleDetail
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesScreen(
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    uiState: ArticlesUiState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Articles") }
            )
        }
    ) { innerPadding ->
        ArticlesBody(
            onItemClick = onItemClick,
            uiState = uiState,
            modifier = modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding()
                )
        )
    }
}

@Composable
fun ArticlesBody(
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    uiState: ArticlesUiState
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(uiState.articles.size) { i ->
            val article = uiState.articles[i]
            ArticleItem(
                article = article,
                modifier = Modifier
                    .clickable {
                        val encodedUrl = URLEncoder.encode(article.webUrl, StandardCharsets.UTF_8.toString())
                        onItemClick(encodedUrl)
                    }
            )
            if (i < uiState.articles.size - 1) {
                HorizontalDivider(
                    modifier = Modifier.padding(
                        horizontal = 4.dp
                    ), thickness = 2.dp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticleScreenPreview() {
    NewsTheme {
        ArticlesScreen(
            uiState = ArticlesUiState(
                articles = List(10) { Article("test") },

            ),
            onItemClick = {}
        )
    }
}