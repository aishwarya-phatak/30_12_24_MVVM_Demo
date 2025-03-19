package com.bitcode.a30_12_24_mvvm_demo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.a30_12_24_mvvm_demo.bindingadapters.loadImageToImageView
import com.bitcode.a30_12_24_mvvm_demo.databinding.UserViewBinding
import com.bitcode.a30_12_24_mvvm_demo.models.User

class UsersAdapter(private val users : ArrayList<User>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    inner class UsersViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val usersViewBinding = UserViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(com.bitcode.a30_12_24_mvvm_demo.R.layout.user_view,null)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.usersViewBinding.user = users[position]
    }

    override fun getItemCount(): Int {
        return users.size
    }
}