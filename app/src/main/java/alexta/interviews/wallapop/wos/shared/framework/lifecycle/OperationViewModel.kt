package alexta.interviews.wallapop.wos.shared.framework.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class OperationViewModel<O : ViewModelOperation>() : ViewModel() {

    private val _operation = MutableLiveData<O>()

    internal val operation: LiveData<O>
        get() = _operation

    internal fun update(value: O) {
        _operation.value = value
    }

}