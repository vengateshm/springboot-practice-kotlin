package dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model

enum class StorySort {
    AUTHOR,
    TITLE;

    companion object {
        fun from(value: String): StorySort {
            return StorySort.valueOf(value.uppercase())
        }
    }
}