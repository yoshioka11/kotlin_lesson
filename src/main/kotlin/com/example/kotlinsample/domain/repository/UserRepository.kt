package com.example.kotlinsample.domain.repository

import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import com.example.kotlinsample.domain.entity.User

@Mapper
@Repository
interface UserRepository{

    @Select("SELECT * FROM user;")
    fun selectUserList(): List<User>

    @Select("SELECT * FROM user WHERE id = #{id}")
    fun selectUserById(@Param("id") id: Int?): User

    @Insert("INSERT INTO user(name,hobby) values(#{name}, #{hobby})")
    fun insertUserById(user: User): Int

    @Update("UPDATE user SET name=#{name}, hobby=#{hobby} WHERE id=#{id}")
    fun updateUserById(user: User): Int

    @Delete("DELETE FROM user WHERE id=#{id}")
    fun deleteUserById(@Param("id") id: Int?): Int
}