package fr.androidmakers.workshop

import fr.xgouchet.elmyr.annotation.IntForgery
import fr.xgouchet.elmyr.junit5.ForgeExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ForgeExtension::class)
class CalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun `set up`() {
        calculator = Calculator()
    }

    // @RepeatedTest(64)
    // fun `returns sum of a and b`(
    //     @IntForgery a: Int,
    //     @IntForgery b: Int
    // ){
    //     val result = calculator.add(a, b)
    //
    //     assertThat(result)
    //         .isEqualTo(a + b)
    // }

    @RepeatedTest(42)
    fun `addition is commutative`(
        @IntForgery a: Int,
        @IntForgery b: Int
    ) {
        val result_ab = calculator.add(a, b)
        val result_ba = calculator.add(b, a)

        assertThat(result_ab).isEqualTo(result_ba)
    }

    @RepeatedTest(13)
    fun `addition is associative`(
        @IntForgery a: Int,
        @IntForgery b: Int,
        @IntForgery c: Int
    ) {
        val result_ab_c = calculator.add(calculator.add(a, b), c)
        val result_a_bc = calculator.add(a, calculator.add(b, c))

        assertThat(result_a_bc).isEqualTo(result_ab_c)
    }

    @RepeatedTest(13)
    fun `addition has a neutral element which is 0`(
        @IntForgery a: Int
    ) {
        val result_a0 = calculator.add(a, 0)

        assertThat(result_a0).isEqualTo(a)
    }

    @RepeatedTest(2)
    fun `addition follows the integer natural order`(
        @IntForgery a: Int
    ) {
        val result_a11 = calculator.add(calculator.add(a, 1), 1)
        val result_a2 = calculator.add(a, 2)

        assertThat(result_a11).isEqualTo(result_a2)
    }
}