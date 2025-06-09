package com.ismailshaipov.mymvidecomposetestapp.domain

class AddContactUseCase(
    private val repository: Repository
) {

    operator fun invoke(
        username: String,
        phone: String
    ) {
        val contact = Contact(
            username = username,
            phone = phone
        )
        repository.saveContact(contact)
    }
}
