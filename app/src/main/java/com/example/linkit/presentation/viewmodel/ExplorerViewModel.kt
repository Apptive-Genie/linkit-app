package com.example.linkit.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.linkit.domain.model.Link
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExplorerViewModel @Inject constructor(

): ViewModel() {
    val links = mutableStateListOf<Link>()
}