package com.uxstate.catfacts.domain.repository

interface CatRepository {


   suspend fun getCatFacts()
}