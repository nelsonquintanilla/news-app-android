package com.nelsonquintanilla.news.ui.articles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nelsonquintanilla.news.domain.repository.ArticlesRepository
import com.nelsonquintanilla.news.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesRepository: ArticlesRepository
) : ViewModel() {

    var uiState by mutableStateOf(ArticlesUiState(isLoading = true))
        private set

    init {
        getAllArticles()
    }
    private fun getAllArticles() {
        viewModelScope.launch {
            articlesRepository.getAllArticles().collect{ result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            uiState = uiState.copy(
                                articles = it,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> Unit
                    is Resource.Error -> Unit
                }
            }
        }
    }
}