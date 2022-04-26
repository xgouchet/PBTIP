package fr.androidmakers.workshop

import android.accounts.Account
import fr.xgouchet.elmyr.Forge
import fr.xgouchet.elmyr.ForgeryFactory

class UserForgeryFactory : ForgeryFactory<User> {

    /**
     * @param forge the forge instance to use to generate a forgery
     * @return a new instance of type T, randomly generated with the help of the forge instance
     */
    override fun getForgery(forge: Forge): User {
        return User(
            username = forge.anAlphabeticalString(),
            email = forge.aStringMatching("[a-z]{5,12}\\.[a-z]{4,10}@[a-z]{7,13}\\.com"),
            birthDate = forge.getForgery(),
            accountType = forge.aValueFrom(AccountType::class.java),
            preferences = forge.aNullable {
                aMap {
                    anAsciiString() to anElementFrom(
                        anInt(),
                        aLong(),
                        aFloat(),
                        aBool(),
                        aSubStringOf { anHexadecimalString() },
                        aList { anInt() }
                    )
                }
            }
        )
    }
}