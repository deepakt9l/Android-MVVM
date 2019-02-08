package com.example.androidmvvm.database.posts

import android.arch.persistence.room.*
import com.example.androidmvvm.model.Post
import io.reactivex.Single

@Dao
interface PostsDao {

    @Query("SELECT * FROM post")
    fun getPosts(): Single<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<Post>)

    @Query("SELECT * FROM post WHERE id = :id")
    fun getPostById(id: Int):Single<Post>

    @Update
    fun updatePost(post: Post)
}