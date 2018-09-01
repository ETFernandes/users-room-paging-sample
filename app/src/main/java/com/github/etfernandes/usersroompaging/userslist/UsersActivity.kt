package com.github.etfernandes.usersroompaging.userslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.etfernandes.usersroompaging.R
import kotlinx.android.synthetic.main.activity_users_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersActivity : AppCompatActivity() {

    private val viewModel: UsersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)

        val adapter = UsersAdapter()
        usersRecyclerView.adapter = adapter
        usersRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        viewModel.users.observe(this, Observer { adapter.submitList(it) })
    }
}
