package alexta.interviews.wallapop.wos.game.di

import alexta.interviews.wallapop.core.game.application.create.GameCreator
import alexta.interviews.wallapop.wos.game.splash.viewmodel.GameSplashViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class GameModuleTest {

    @Provides
    @Singleton
    fun provideGameViewModel(creator: GameCreator) = GameSplashViewModel(creator)

    @Provides
    fun provideGameCreator() = GameCreator()

}