package dev.vengateshm.spring_boot_practice_with_kotlin.jacoco_tests

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DiscountCalculatorTest {
    private val discountCalculator = DiscountCalculator()

    @Test
    fun `Regular customer should get 5 percent discount`() {
        val result = discountCalculator.calculateDiscount("Regular", 100.0)
        assertEquals(95.0, result, 0.01)
    }

    @Test
    fun `VIP customer should get 10 percent discount when purchase amount is above 100`() {
        val result = discountCalculator.calculateDiscount("VIP", 150.0)
        assertEquals(135.0, result, 0.01)
    }

    @Test
    fun `VIP customer should get 5 percent discount when purchase amount is 100 or below`() {
        val result = discountCalculator.calculateDiscount("VIP", 100.0)
        assertEquals(95.0, result, 0.01)
    }

    @Test
    fun `Unregistered customer should get no discount`() {
        val result = discountCalculator.calculateDiscount("Unregistered", 100.0)
        assertEquals(100.0, result, 0.01)
    }
}