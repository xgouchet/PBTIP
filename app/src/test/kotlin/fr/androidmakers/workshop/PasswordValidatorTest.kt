package fr.androidmakers.workshop

import fr.xgouchet.elmyr.Forge
import fr.xgouchet.elmyr.annotation.StringForgery
import fr.xgouchet.elmyr.annotation.StringForgeryType
import fr.xgouchet.elmyr.junit5.ForgeConfiguration
import fr.xgouchet.elmyr.junit5.ForgeExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ForgeExtension::class)
@ForgeConfiguration(value = MyForgeConfig::class)
internal class PasswordValidatorTest {

    lateinit var testedValidator: PasswordValidator

    @BeforeEach
    fun `set up`() {
        testedValidator = PasswordValidator()
    }

    @RepeatedTest(13)
    fun `validation fails if uppercase alpha char is missing`(
        @StringForgery(regex = "[a-z]{6,30}[0-9][&@=_;-]") password: String
    ) {
        val isValid = testedValidator.isPasswordValid(password)

        assertThat(isValid).isFalse()
    }

    @RepeatedTest(13)
    fun `validation fails if lowercase alpha char is missing`(
        @StringForgery(regex = "[A-Z]{6,30}[0-9][&@=_;-]") password: String
    ) {
        val isValid = testedValidator.isPasswordValid(password)

        assertThat(isValid).isFalse()
    }

    @RepeatedTest(13)
    fun `validation fails if too few characters 2`(
        @StringForgery(regex = "[a-zA-Z0-9*+]{0,7}") password: String
    ) {
        val isValid = testedValidator.isPasswordValid(password)

        assertThat(isValid).isFalse()
    }

    @RepeatedTest(13)
    fun `validation fails if too few characters`(
        @StringForgery(regex = "[a-z][A-Z][0-9][&@=_;-][a-zA-Z0-9]{0,3}") password: String
    ) {
        val isValid = testedValidator.isPasswordValid(password)

        assertThat(isValid).isFalse()
    }

    @RepeatedTest(13)
    fun `validation fails if too many characters`(
        forge: Forge
    ) {
        val orderedPassword =
            forge.aStringMatching("[a-z][A-Z][0-9][&@=_;-][a-zA-Z0-9&@=_;-]{29,64}")

        repeat(13) {
            val shuffledPassword = forge.shuffle(orderedPassword.toCharArray().toList())
                .toCharArray().concatToString()

            val isValid = testedValidator.isPasswordValid(shuffledPassword)

            assertThat(isValid).isFalse()
        }
    }

    @RepeatedTest(100)
    fun `validation succeeds for valid password`(
        @StringForgery(regex = "[a-z][A-Z][0-9][&@=_;-][a-zA-Z0-9&@=_;-]{4,28}") password: String
    ) {
        val isValid = testedValidator.isPasswordValid(password)

        assertThat(isValid).isTrue()
    }
}