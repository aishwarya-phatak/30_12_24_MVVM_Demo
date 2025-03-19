package com.bitcode.a30_12_24_mvvm_demo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.a30_12_24_mvvm_demo.adapters.UsersAdapter
import com.bitcode.a30_12_24_mvvm_demo.databinding.UserFragmentBinding
import com.bitcode.a30_12_24_mvvm_demo.factory.MyViewModelFactory
import com.bitcode.a30_12_24_mvvm_demo.network.UsersApiService
import com.bitcode.a30_12_24_mvvm_demo.repository.UsersRepository
import com.bitcode.a30_12_24_mvvm_demo.viewmodels.UsersViewModel

class UsersFragment : Fragment() {
    private lateinit var userFragmentBinding: UserFragmentBinding
    private lateinit var usersViewModel: UsersViewModel
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        userFragmentBinding = UserFragmentBinding.inflate(layoutInflater)
        initViews()
        initViewModel()
        initAdapters()
        initListeners()
        initObservers()

        usersViewModel.fetchUsers()
        return userFragmentBinding.root
    }

    private fun initViews(){
            userFragmentBinding.recyclerViewForUsers.layoutManager =
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
            )
    }

    private fun initAdapters(){
        usersAdapter = UsersAdapter(usersViewModel.users)
        userFragmentBinding.recyclerViewForUsers.adapter = usersAdapter
    }

    private fun initListeners(){
        userFragmentBinding.recyclerViewForUsers.addOnScrollListener(
            object : RecyclerView.OnScrollListener(){

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if((recyclerView.canScrollVertically(1)) && (newState == RecyclerView.SCROLL_STATE_IDLE)){
                        usersViewModel.fetchUsers()
                    }
                }
            }
        )
    }

    private fun initViewModel(){
        usersViewModel = ViewModelProvider(this,
            MyViewModelFactory(UsersRepository(UsersApiService.getInstance())))
            .get(UsersViewModel::class.java)
    }

    private fun initObservers(){
            usersViewModel.usersUpdateAvailableLiveData.observe(
                viewLifecycleOwner
            ) {
                if(it){
                    usersAdapter.notifyDataSetChanged()
                }
            }
    }
}