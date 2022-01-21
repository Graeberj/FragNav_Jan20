package com.example.fragmentnavigation_august9

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private var _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users
    private val userList: MutableList<User> = mutableListOf()

    fun addUser(user: User){
        userList.add(user)
        _users.value = userList
    }

}