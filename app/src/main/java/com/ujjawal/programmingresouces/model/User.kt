package com.ujjawal.programmingresouces.model

data class User(
    val name: String?,
    val profileImageUrl: String?,
    val bio: String?,
    val interestedTopics: List<String>?
)