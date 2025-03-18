package com.bitcode.a30_12_24_mvvm_demo.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.a30_12_24_mvvm_demo.models.User

class UsersAdapter(private val users : ArrayList<User>) : RecyclerView.Adapter<UsersAdapter.UsersViewModel>() {

    inner class UsersViewModel(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewModel {

    }

    override fun onBindViewHolder(holder: UsersViewModel, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}