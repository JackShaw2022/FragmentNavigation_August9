package com.example.fragmentnavigation_august9.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fragmentnavigation_august9.data.User
import com.example.fragmentnavigation_august9.data.UserEmail
import com.example.fragmentnavigation_august9.data.UserName
import com.example.fragmentnavigation_august9.data.UserPassword

class UserViewModel: ViewModel() {

    private var _userNames: MutableLiveData<List<UserName>> = MutableLiveData()
    val userNames: LiveData<List<UserName>> get() = _userNames
    private val userNameList: MutableList<UserName> = mutableListOf()

    private var _userEmails: MutableLiveData<List<UserEmail>> = MutableLiveData()
    val userEmails: LiveData<List<UserEmail>> get() = _userEmails
    private val userEmailList: MutableList<UserEmail> = mutableListOf()

    private var _userPasswords: MutableLiveData<List<UserPassword>> = MutableLiveData()
    val userPasswords: LiveData<List<UserPassword>> get() = _userPasswords
    private val userPasswordList: MutableList<UserPassword> = mutableListOf()

    private var _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users
    private val userList: MutableList<User> = mutableListOf()

    fun addUserName(userName: UserName) {
        userNameList.add(userName)

        _userNames.value = userNameList
    }
    fun addUserEmail(userEmail: UserEmail) {
        userEmailList.add(userEmail)

        _userEmails.value = userEmailList
    }
    fun addUserPassword(userPassword: UserPassword){
        userPasswordList.add(userPassword)

        _userPasswords.value = userPasswordList
    }
    fun addUser(user: User){
        userList.add(user)

        _users.value = userList
    }
}