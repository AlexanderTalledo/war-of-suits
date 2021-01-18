package alexta.interviews.wallapop.wos.game.splash.view

import alexta.interviews.wallapop.wos.R
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaBackgroundAssertions.assertHasBackground
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertTextColorIs
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameSplashFragmentShould {

    @Test
    fun displayRedContainer() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashRedContainer

        assertDisplayed(viewId)
        assertHasBackground(viewId, R.color.suit_red)
    }

    @Test
    fun displayBlackContainer() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashBlackContainer

        assertDisplayed(viewId)
        assertHasBackground(viewId, R.color.suit_black)
    }

    @Test
    fun displayGameAcronym() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashAcronymTextView

        assertDisplayed(viewId, R.string.game_splash_acronym)
        assertTextColorIs(viewId, R.color.white)
    }

    @Test
    fun displayGameName() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashNameTextView

        assertDisplayed(viewId, R.string.game_splash_name)
        assertTextColorIs(viewId, R.color.white)
    }

    @Test
    fun displayCardSuitIconOne() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashSuitOneImageView

        assertDisplayed(viewId)
    }

    @Test
    fun displayCardSuitIconTwo() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashSuitTwoImageView

        assertDisplayed(viewId)
    }

    @Test
    fun displayCardSuitIconThree() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashSuitThreeImageView

        assertDisplayed(viewId)
    }

    @Test
    fun displayCardSuitIconFour() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashSuitFourImageView

        assertDisplayed(viewId)
    }

    @Test
    fun displayGameStart() {
        launchFragmentInContainer<GameSplashFragment>()
        val viewId = R.id.gameSplashStartTextView

        assertDisplayed(viewId, R.string.game_splash_start)
        assertTextColorIs(viewId, R.color.white)
    }

}