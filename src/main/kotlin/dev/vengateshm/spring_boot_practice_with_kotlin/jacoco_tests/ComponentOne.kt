package dev.vengateshm.spring_boot_practice_with_kotlin.jacoco_tests

import org.springframework.stereotype.Component

@Component
class ComponentOne {

    @ExcludeCode
    fun one(): String = "example"

    fun two(arg: Int): Double =
        if (arg > 0)
            10.0
        else
            20.0
}