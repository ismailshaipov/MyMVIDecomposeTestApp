package com.ismailshaipov.mymvidecomposetestapp.presentation_legacy

import androidx.lifecycle.ViewModel
import com.ismailshaipov.mymvidecomposetestapp.data.RepositoryImpl
import com.ismailshaipov.mymvidecomposetestapp.domain.AddContactUseCase
import com.ismailshaipov.mymvidecomposetestapp.domain.Contact
import com.ismailshaipov.mymvidecomposetestapp.domain.EditContactUseCase

class ContactDetailViewModel : ViewModel() {

    private val repository = RepositoryImpl

    private val addContactUseCase = AddContactUseCase(repository)
    private val editContactUseCase = EditContactUseCase(repository)

    fun addContact(username: String, phone: String) {
        addContactUseCase(username, phone)
    }

    fun editContact(contact: Contact) {
        editContactUseCase(contact)
    }
}
