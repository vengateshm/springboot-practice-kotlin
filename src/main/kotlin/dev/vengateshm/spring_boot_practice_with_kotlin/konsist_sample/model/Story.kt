package dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model

data class Story(val title: Title, val author: Author) {
    //var isAvailableToRead = true
}

@JvmInline
value class Author(val value: String)

@JvmInline
value class Title(val value: String)