package dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.data

import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.Story

interface DataStore {
    fun all(): List<Story>
}