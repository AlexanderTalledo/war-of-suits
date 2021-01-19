package alexta.interviews.wallapop.wos.game.di

import alexta.interviews.wallapop.core.game.application.create.GameCreator
import alexta.interviews.wallapop.core.game.infrastructure.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class GameModule {

    @FragmentScoped
    @Provides
    fun provideGameCreator(repository: GameRepository) = GameCreator(repository)

}