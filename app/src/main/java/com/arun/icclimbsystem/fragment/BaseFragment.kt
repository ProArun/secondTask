package com.arun.icclimbsystem.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.arun.icclimbsystem.data.MainRepository
import com.arun.icclimbsystem.data.NoteApi
import com.arun.icclimbsystem.viewModel.ViewModelFactory

abstract class BaseFragment<VM : ViewModel, B : ViewBinding> : Fragment() {
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = getFragmentLayoutBinding(inflater, container).also {
        val api = NoteApi()
        val repository = MainRepository(api)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(getViewModelClass())
        binding = it
    }.root

    abstract fun getViewModelClass(): Class<VM>
    abstract fun getFragmentLayoutBinding(inflater: LayoutInflater, container: ViewGroup?): B

}