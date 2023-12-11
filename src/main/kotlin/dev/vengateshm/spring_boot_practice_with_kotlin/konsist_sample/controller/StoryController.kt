package dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.controller

import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.Story
import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.StorySort
import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.service.StoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/story")
class StoryController(private val service: StoryService) {
    @GetMapping("/all")
    fun allStories(@RequestParam sort: String? = null): StoryRepresentation {
        val sortedBy = sort?.let { StorySort.from(it) }
        return StoryRepresentation(service.all(sortedBy))
    }
}

data class StoryRepresentation(val stories: List<Story>)