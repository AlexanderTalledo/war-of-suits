package alexta.interviews.wallapop.wos.game.di

import alexta.interviews.wallapop.core.game.application.create.GameCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.mockito.Mockito

@Module
@InstallIn(ApplicationComponent::class)
class GameModuleTest {

    @Provides
    internal fun provideGameCreator(): GameCreator = Mockito.mock(GameCreator::class.java)

}