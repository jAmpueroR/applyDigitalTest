package com.jampuero.applydigitaltest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "posts")
data class PostEntity(
    @SerializedName("story_id")
    @PrimaryKey val id: String,
    @SerializedName("story_title")
    val title: String?,
    val author: String?,
    val created_at: String?,
    @SerializedName("story_url")
    val url: String?,
    @SerializedName("comment_text")
    val body: String?,
    val deleted:Boolean = false
)