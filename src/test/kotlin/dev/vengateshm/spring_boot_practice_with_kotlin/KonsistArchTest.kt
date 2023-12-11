package dev.vengateshm.spring_boot_practice_with_kotlin

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import com.lemonappdev.konsist.api.ext.list.functions
import com.lemonappdev.konsist.api.ext.list.modifierprovider.withModifier
import com.lemonappdev.konsist.api.ext.list.modifierprovider.withValueModifier
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.ext.list.withAnnotationOf
import com.lemonappdev.konsist.api.verify.assertFalse
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.web.bind.annotation.RestController

class KonsistArchTest {
    @Test
    fun `controllers never returns collection`() {
        Konsist
            .scopeFromPackage("dev.vengateshm.spring_boot_practice_with_kotlin/konsist_sample.controller..")
            .classes()
            .withAnnotationOf(RestController::class)
            .functions()
            .assertFalse(additionalMessage = "Don't use Kotlin Collection Types") { function ->
                function.hasReturnType { it.hasNameStartingWith("List") }
            }
    }

    @Test
    fun `all properties in data class are defined in constructor`() {
        Konsist
            .scopeFromPackage("dev.vengateshm.spring_boot_practice_with_kotlin/konsist_sample.model..")
            .classes()
            .withModifier(KoModifier.DATA)
            .properties()
            .assertTrue {
                it.isConstructorDefined
            }
    }

    @Test
    fun `all value classes have value property`() {
        Konsist
            .scopeFromProject()
            .classes()
            .withValueModifier()
            .properties()
            .assertTrue {
                it.name == "value"
            }
    }

    @Test
    fun `all models have serializable annotation`() {
        /*Konsist
            .scopeFromPackage("dev.vengateshm.spring_boot_practice_with_kotlin/konsist_sample.model..")
            .classes()
            .assertTrue { it.hasAnnotationOf(Serializable::class) }*/
    }

    @Test
    fun `architecture boundaries are represented`() {
        Konsist
            .scopeFromProject()
            .assertArchitecture {
                val controllerLayer =
                    Layer("Controller", "dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.controller..")
                val dataLayer = Layer("Data", "dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.data..")
                val modelLayer =
                    Layer("Model", "dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.model..")
                val serviceLayer =
                    Layer("Service", "dev.vengateshm.spring_boot_practice_with_kotlin.konsist_sample.service..")

                controllerLayer.dependsOn(modelLayer)
                controllerLayer.dependsOn(serviceLayer)

                serviceLayer.dependsOn(modelLayer)
                serviceLayer.dependsOn(dataLayer)

                dataLayer.dependsOn(modelLayer)

                modelLayer.dependsOnNothing()
            }
    }
}