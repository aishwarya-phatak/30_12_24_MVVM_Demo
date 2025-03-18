package com.bitcode.a30_12_24_mvvm_demo.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcode.a30_12_24_mvvm_demo.repository.UsersRepository
import com.bitcode.a30_12_24_mvvm_demo.viewmodels.UsersViewModel

class MyViewModelFactory (private val usersRepository: UsersRepository) : ViewModelProvider.Factory{
    override fun<T : ViewModel> create(modelClass: Class<T>):T{
        return UsersViewModel(usersRepository) as T
    }
}