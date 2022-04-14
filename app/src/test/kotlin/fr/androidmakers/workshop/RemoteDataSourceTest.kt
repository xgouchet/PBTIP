package fr.androidmakers.workshop

import fr.xgouchet.elmyr.junit5.ForgeExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness

@ExtendWith(ForgeExtension::class, MockitoExtension::class)
@MockitoSettings(strictness = Strictness.LENIENT)
internal class RemoteDataSourceTest {

    fun `handles successful log in`() {
    }
}