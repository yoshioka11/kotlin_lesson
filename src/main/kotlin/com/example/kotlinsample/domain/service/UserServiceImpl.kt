package com.example.kotlinsample.domain.service

import com.example.kotlinsample.domain.entity.User
import com.example.kotlinsample.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun getUserList(): List<User>{
        return userRepository.selectUserList()
    }

    override fun getUserById(id: Int?): User {
        return userRepository.selectUserById(id)
    }

    override fun getInsertUser(user: User): List<User> {
        userRepository.insertUserById(user)
        return userRepository.selectUserList()
    }

    override fun getUpdateUser(id: Int, user: User): User {
        user.id = id
        return userRepository.selectUserById(id)
    }

    override fun getDeleteUserById(id: Int?): User {
        userRepository.deleteUserById(id)
        return userRepository.selectUserById(id)
    }
}