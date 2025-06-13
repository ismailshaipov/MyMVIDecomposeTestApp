package com.ismailshaipov.mymvidecomposetestapp.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.statekeeper.consume
import com.ismailshaipov.mymvidecomposetestapp.data.RepositoryImpl
import com.ismailshaipov.mymvidecomposetestapp.domain.AddContactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultAddContactComponent(componentContext: ComponentContext) : AddContactComponent,
    ComponentContext by componentContext {

    private val repository = RepositoryImpl

    private val addContactUseCase = AddContactUseCase(repository)

    init {
        stateKeeper.register(KEY) {
            model.value
        }
    }


    private val _model = MutableStateFlow(
        stateKeeper.consume(KEY) ?: AddContactComponent.Model("", "")
    )

    override val model: StateFlow<AddContactComponent.Model>
        get() = _model.asStateFlow()

    override fun onUsernameChanged(username: String) {
        _model.value = _model.value.copy(username = username)
    }

    override fun onPhoneChanged(phone: String) {
        _model.value = _model.value.copy(phone = phone)
    }

    override fun onSaveContactClicked() {
        val (username, phone) = _model.value
        addContactUseCase(username, phone)
    }

    companion object {
        private const val KEY = "DefaultAddContactComponent"
    }
}