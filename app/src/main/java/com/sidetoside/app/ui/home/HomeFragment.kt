package com.sidetoside.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sidetoside.app.R
import com.sidetoside.app.databinding.FragmentHomeBinding
import com.sidetoside.app.entity.LeftRight
import com.sidetoside.app.entity.Side

class HomeFragment : Fragment() {

    private val adapter = FeedAdapter()

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        return DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        ).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = this.adapter

        adapter.setItems(
            listOf(
                LeftRight(
                    1,
                    "title",
                    Side("left", "", 123),
                    Side("right", "", 123)
                ),
                LeftRight(
                    2,
                    "title2",
                    Side("left2", "", 123),
                    Side("right2", "", 123)
                ),
                LeftRight(
                    1,
                    "title",
                    Side("left", "", 123),
                    Side("right", "", 123)
                ),
                LeftRight(
                    2,
                    "title2",
                    Side("left2", "", 123),
                    Side("right2", "", 123)
                ),
                LeftRight(
                    1,
                    "title",
                    Side("left", "", 123),
                    Side("right", "", 123)
                ),
                LeftRight(
                    2,
                    "title2",
                    Side("left2", "", 123),
                    Side("right2", "", 123)
                ), LeftRight(
                    1,
                    "title",
                    Side("left", "", 123),
                    Side("right", "", 123)
                ),
                LeftRight(
                    2,
                    "title2",
                    Side("left2", "", 123),
                    Side("right2", "", 123)
                ), LeftRight(
                    1,
                    "title",
                    Side("left", "", 123),
                    Side("right", "", 123)
                ),
                LeftRight(
                    2,
                    "title2",
                    Side("left2", "", 123),
                    Side("right2", "", 123)
                )
            )
        )
    }
}
