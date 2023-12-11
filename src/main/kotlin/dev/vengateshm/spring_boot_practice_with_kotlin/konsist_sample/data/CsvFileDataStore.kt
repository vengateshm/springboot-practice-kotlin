package dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.data

import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.Author
import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.Story
import dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model.Title
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import java.io.File

@Repository
class CsvFileDataStore(@Qualifier("csvFile") file: File) : DataStore {

    private val data by lazy {
        file.readLines()
            .map { it.split(",") }
            .map { (title, author) -> Story(Title(title), Author(author)) }
    }

    override fun all() = data
}