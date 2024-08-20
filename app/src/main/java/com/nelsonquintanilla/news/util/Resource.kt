package com.nelsonquintanilla.news.util

// TODO: Check if kotlin provides a default approach to do this
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>(isLoading: Boolean = false): Resource<T>()
}