package fr.androidmakers.workshop

class PasswordValidator {

    /**
     * A password is valid if
     * - It is between 8 and 32 chars
     * - It has at least one lowercase alphabetical char
     * - It has at least one uppercase alphabetical char
     * - It has at least one digit
     * - It has at least one special character (-_&@!?;:.,=+)
     */
    fun isPasswordValid(password: String): Boolean {
        return password.any { it.isLowerCase() } and
            password.any { it.isUpperCase() } and
            password.any { it.isDigit() } and
            password.any {it in validSpecialChars } and
            (password.length in 8..32)
    }

    companion object {
        val validSpecialChars = "&".toCharArray()
    }
}