package com.ujjawal.programmingresouces.model

object Constants {
    const val INTENT_DATA = "intent_data"

    object Default{
        const val USER_NAME = "Ujjawal Dubey"
        const val USER_BIO = "A developer who loves to code, learn latest thing, daily medium reader."
        const val PROFILE_PICTURE = "https://avatars.githubusercontent.com/u/96038205?s=400&u=94b4454069846c7c5f8aebbd9026fadd8b5e3894&v=4"
        val interestedTopics = listOf("Android", "Kotlin", "Jetpack", "Python", "Compose")
        val user = User(
            name = USER_NAME,
            profileImageUrl = PROFILE_PICTURE,
            bio = USER_BIO,
            interestedTopics = interestedTopics
        )
    }
}