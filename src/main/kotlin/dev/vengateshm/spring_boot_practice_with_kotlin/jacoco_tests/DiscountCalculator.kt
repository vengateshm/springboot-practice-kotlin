package dev.vengateshm.spring_boot_practice_with_kotlin.jacoco_tests

class DiscountCalculator {
    fun calculateDiscount(customerType: String, purchaseAmount: Double): Double {
        return when (customerType) {
            "Regular" -> purchaseAmount * 0.95
            "VIP" -> if (purchaseAmount > 100) purchaseAmount * 0.90 else purchaseAmount * 0.95
            else -> purchaseAmount // No discount for unregistered customers
        }
    }
}