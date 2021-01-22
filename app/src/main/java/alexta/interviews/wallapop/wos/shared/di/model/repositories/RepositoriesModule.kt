package alexta.interviews.wallapop.wos.shared.di.model.repositories

import alexta.interviews.wallapop.core.game.domain.GameDataSource
import alexta.interviews.wallapop.core.game.infrastructure.GameRepository
import alexta.interviews.wallapop.wos.game.model.InMemoryGameDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoriesModule {

    @Provides
    @Singleton
    internal fun provideGameRepository(dataSource: GameDataSource) = GameRepository(dataSource)

    @Provides
    internal fun provideGameDataSource(): GameDataSource = InMemoryGameDataSource()

}