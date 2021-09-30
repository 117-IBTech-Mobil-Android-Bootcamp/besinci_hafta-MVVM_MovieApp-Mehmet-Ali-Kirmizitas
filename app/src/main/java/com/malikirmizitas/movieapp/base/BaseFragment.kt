package com.malikirmizitas.movieapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.malikirmizitas.movieapp.R

/**
 * This fragment is parent of our fragments.
 * We declare onCreateView, onViewCreated functions, getStatusBarColor
 */

abstract class BaseFragment<VM : ViewModel?, DB : ViewDataBinding> : Fragment(), IBaseFragment {

    abstract var viewModel: VM?
    protected lateinit var dataBinding: DB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
        observeLiveData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        prepareViewModel()
    }

    override fun onResume() {
        super.onResume()

        /**
         * Setting up statusBar color by getStatusBarColor function
         */
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), getStatusBarColor())
    }

    override fun getStatusBarColor() = R.color.white

    abstract fun getLayoutID(): Int
    abstract fun observeLiveData()
    abstract fun prepareView()
    abstract fun prepareViewModel()
    override fun shouldCheckInternetConnection() = true

}