package com.ismailshaipov.mymvidecomposetestapp.presentation

import com.ismailshaipov.mymvidecomposetestapp.domain.Contact
import kotlinx.coroutines.flow.StateFlow

interface ContactListComponent {

    val model: StateFlow<Model>

    fun onContactClicked(contact: Contact)

    fun onAddContactClicked()

    data class Model(
        val contactsList: List<Contact>
    )
}