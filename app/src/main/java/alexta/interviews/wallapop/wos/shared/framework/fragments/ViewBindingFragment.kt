package alexta.interviews.wallapop.wos.shared.framework.fragments

import alexta.interviews.wallapop.wos.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<VB : ViewBinding> : Fragment() {

    internal abstract var viewBinding: VB?

    internal abstract fun initObservers()

    internal abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = viewBinding?.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private val navHostFragment by lazy {
        activity?.supportFragmentManager
            ?.findFragmentById(R.id.applicationNavigationHostContainer) as NavHostFragment
    }

    private val navController by lazy { navHostFragment.navController }

    internal fun navigateTo(@IdRes destination: Int) {
        navController.navigate(destination)
    }

}