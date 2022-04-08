package fr.androidmakers.workshop

import fr.xgouchet.elmyr.junit5.ForgeExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ForgeExtension::class)
class CalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun `set up`(){
        calculator = Calculator()
    }

    @Test
    fun `returns sum of a and b`(){
        assertThat(calculator.add(2, 2))
            .isEqualTo(4)
    }
}