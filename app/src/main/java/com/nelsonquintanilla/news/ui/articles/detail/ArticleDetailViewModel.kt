package com.nelsonquintanilla.news.ui.articles.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var detailUiState: DetailUiState by mutableStateOf(DetailUiState())
        private set
    private val itemUrl: String = checkNotNull(savedStateHandle[ArticleDetailDestination.ITEM_URL_ARG])

    init {
        detailUiState = detailUiState.copy(
            webUrl = itemUrl
        )
    }
}