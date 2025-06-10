package com.ismailshaipov.mymvidecomposetestapp.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.statekeeper.consume
import com.ismailshaipov.mymvidecomposetestapp.data.RepositoryImpl
import com.ismailshaipov.mymvidecomposetestapp.domain.Contact
import com.ismailshaipov.mymvidecomposetestapp.domain.EditContactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultEditContactComponent(
    private val contact: Contact,
    componentContext: ComponentContext
) : EditContactComponent, ComponentContext by componentContext {

    private val repository = RepositoryImpl
    private val editContactUseCase = EditContactUseCase(repository)

    init {
        stateKeeper.register(KEY) {
            model.value
        }
    }


    private val _model = MutableStateFlow(
        stateKeeper.consume(KEY) ?: EditContactComponent.Model(contact.username, contact.phone)
    )

    override val model: StateFlow<EditContactComponent.Model>
        get() = _model.asStateFlow()

    override fun onUsernameChanged(username: String) {
        _model.value = _model.value.copy(username = username)
    }

    override fun onPhoneChanged(phone: String) {
        _model.value = _model.value.copy(phone = phone)
    }

    override fun onSaveContactClicked() {
        val (username, phone) = _model.value
        editContactUseCase(
            contact.copy(
                username = username,
                phone = phone
            )
        )
    }

    companion object {
        private const val KEY = "DefaultEditContactComponent"
    }
}