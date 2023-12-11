package dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.service

import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.data.DataStore
import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.Story
import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.StorySort
import org.springframework.stereotype.Service

@Service
class StoryService(private val dataStore: DataStore) {
    fun all(sort: StorySort? = null): List<Story> {
        val stories = dataStore.all()

        return when (sort) {
            StorySort.AUTHOR -> stories.sortedBy { it.author.value }
            StorySort.TITLE -> stories.sortedBy { it.title.value }
            else -> stories
        }
    }
}