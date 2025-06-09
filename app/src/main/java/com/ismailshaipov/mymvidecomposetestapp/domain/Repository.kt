package com.ismailshaipov.mymvidecomposetestapp.domain

import kotlinx.coroutines.flow.Flow

interface Repository {

    val contacts: Flow<List<Contact>>

    fun saveContact(contact: Contact)
}
