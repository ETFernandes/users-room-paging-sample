package com.github.etfernandes.usersroompaging.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.etfernandes.usersroompaging.databinding.ItemUserBinding
import com.github.etfernandes.usersroompaging.model.User

class UsersAdapter : PagedListAdapter<User, UsersAdapter.ViewHolder>(UsersDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binder: ItemUserBinding) : RecyclerView.ViewHolder(binder.root) {

        fun bind(user: User) {
            binder.user = user
            binder.executePendingBindings()
        }
    }

    private object UsersDiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) = true
    }
}
