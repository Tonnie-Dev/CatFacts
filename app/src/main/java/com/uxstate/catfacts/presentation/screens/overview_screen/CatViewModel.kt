package com.uxstate.catfacts.presentation.screens.overview_screen

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import com.uxstate.catfacts.domain.model.CatFact
import com.uxstate.catfacts.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(private val repository: CatRepository) : ViewModel() {
 //instantiate a Pager instance


}