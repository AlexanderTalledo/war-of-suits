package alexta.interviews.wallapop.wos.application.view

import alexta.interviews.wallapop.wos.R
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApplicationActivityShould {

    @get:Rule
    val rule = activityScenarioRule<ApplicationActivity>()

    private val scenario: ActivityScenario<ApplicationActivity>
        get() = rule.scenario

    @Test
    fun useApplicationNavigationGraph() {
        scenario.onActivity { activity ->
            val navController = activity.findNavController(R.id.applicationNavigationHostContainer)

            assertThat(navController.graph.id).isEqualTo(R.id.applicationNavigationGraph)
        }
    }

    @Test
    fun haveGameSplashScreenAsStartDestination() {
        scenario.onActivity { activity ->
            val navController = activity.findNavController(R.id.applicationNavigationHostContainer)

            assertThat(navController.graph.startDestination).isEqualTo(R.id.applicationNavigationHostContainer)
        }
    }

    @Test
    fun showGameSplashScreenWhenActivityIsCreated() {
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.onActivity { activity ->
            val navController = activity.findNavController(R.id.applicationNavigationHostContainer)

            assertThat(navController.currentDestination?.id).isEqualTo(R.id.gameSplashFragment)
        }
    }

}