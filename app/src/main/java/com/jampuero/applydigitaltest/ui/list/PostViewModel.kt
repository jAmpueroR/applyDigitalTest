package com.jampuero.applydigitaltest.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jampuero.applydigitaltest.data.model.PostEntity
import com.jampuero.applydigitaltest.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _posts = MutableStateFlow<List<PostEntity>>(emptyList())
    val posts: StateFlow<List<PostEntity>> = _posts.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            fetchPosts()
            repository.posts.collectLatest { posts ->
                _posts.value = posts
            }
        }
    }

    fun refreshPosts() {
        viewModelScope.launch {
            _isRefreshing.value = true
            repository.fetchAndSavePosts()
            _isRefreshing.value = false
        }
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.fetchAndSavePosts()
            _isLoading.value = false
        }
    }

    fun deletePost(postEntity: PostEntity) = viewModelScope.launch {
        repository.deletePost(postEntity)
    }
}
