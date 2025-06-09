package com.ismailshaipov.mymvidecomposetestapp.domain

import kotlinx.coroutines.flow.Flow

class GetContactsUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<Contact>> = repository.contacts
}
