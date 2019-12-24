package com.sidetoside.app.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sidetoside.app.App
import com.sidetoside.app.R
import com.sidetoside.app.databinding.FragmentHomeBinding
import com.sidetoside.app.network.CompareAPI

class HomeFragment : Fragment() {

    private val compareAPI: CompareAPI by lazy {
        (requireActivity().application as App).retrofit.create(CompareAPI::class.java)
    }

    private lateinit var vm: HomeViewModel
    private val adapter: FeedAdapter = FeedAdapter()

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java).apply {
            setup(compareAPI)
        }.also { this.vm = it }
        return DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        ).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@HomeFragment.adapter
        }
        subscribe(vm.bundle)
    }

    private fun subscribe(bundle: HomeViewModel.LiveBundle) = with(bundle) {
        compares.observe(this@HomeFragment, Observer {
            Log.d("TEST", it.toString())
            adapter.setItems(it)
        })
    }
}
