package fr.androidmakers.workshop

import fr.xgouchet.elmyr.Forge
import fr.xgouchet.elmyr.ForgeConfigurator
import fr.xgouchet.elmyr.jvm.useJvmFactories

class MyForgeConfig : ForgeConfigurator {
    /**
     * Allows you to configure a [Forge] instance.
     */
    override fun configure(forge: Forge) {
        forge.useJvmFactories()
        forge.addFactory(UserForgeryFactory())
    }
}