package alexta.interviews.wallapop.wos.share.framework.lifecycle

import alexta.interviews.wallapop.wos.shared.framework.lifecycle.ViewModelOperation
import androidx.lifecycle.Observer
import io.mockk.clearMocks
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
abstract class LifecycleUnitTestCase<O : ViewModelOperation> {

    internal val observer = mockk<Observer<O>>(relaxUnitFun = true)

    @BeforeEach
    internal open fun setUp() {
        clearMocks(observer)
    }

}