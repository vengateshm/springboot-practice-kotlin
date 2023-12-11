package dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.util.ResourceUtils
import java.io.File


@Configuration
class CsvFileDataStoreConfiguration {
    @Bean
    @Qualifier("csvFile")
    fun csvFile(): File {
        return File(ResourceUtils.getFile("classpath:stories.csv").toURI())
    }
}