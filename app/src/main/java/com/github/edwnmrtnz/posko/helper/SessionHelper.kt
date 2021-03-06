package com.github.edwnmrtnz.posko.helper

import com.github.edwnmrtnz.posko.data.model.User
import com.github.edwnmrtnz.posko.data.repository.user.UserDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserRepository

class SessionHelper (private val userRepository: UserRepository) {

    fun isLoggedIn() : Boolean {
        return false
    }

    fun authenticateUser (account_name : String, email_address : String, password : String, callback : UserDataSource.AuthenticateUserCallback){
        userRepository.authenticateUser(account_name, email_address, password, object : UserDataSource.AuthenticateUserCallback{
            override fun onAuthenticated(user: User) {
                callback.onAuthenticated(user)
            }

            override fun onFailed(message: String, statusCode: Int) {
                callback.onFailed(message, statusCode)
            }
        })
    }
}