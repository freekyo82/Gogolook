package com.bruce.project.gogolook.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bruce.project.gogolook.R
import com.bruce.project.gogolook.databinding.HomeFragmentBinding
import com.bruce.project.gogolook.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {
    private val viewModel by viewModels<SearchViewModel>()
    private val binding by viewBinding(HomeFragmentBinding::bind)
    private val searchAdapter = SearchAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }

        binding.btSearch.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val searchName = binding.edSearch.text.toString()
                viewModel.getSearchDataList(searchName)
                    .onEach {
                        searchAdapter.submitData(it)
                    }.launchIn(viewLifecycleOwner.lifecycleScope)
            }
        }
    }
}