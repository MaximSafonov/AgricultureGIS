package com.safonov.agriculturegis.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

@MainThread
inline fun <reified VM : ViewModel> ViewModelStoreOwner.baseViewModels(
    noinline ownerProducer: (() -> ViewModelStoreOwner)? = null,
    noinline constructor: () -> VM,
): ViewModelLazy<VM> {
    val producer = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = constructor() as T
    }

    return ViewModelLazy(
        viewModelClass = VM::class,
        storeProducer = { (ownerProducer?.invoke() ?: this).viewModelStore },
        factoryProducer = { producer }
    )
}