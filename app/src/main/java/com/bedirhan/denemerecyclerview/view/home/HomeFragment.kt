package com.bedirhan.denemerecyclerview.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bedirhan.denemerecyclerview.adapter.RecyclerAdapter
import com.bedirhan.denemerecyclerview.databinding.FragmentHomeBinding
import com.bedirhan.denemerecyclerview.view.home.viewmodel.HomeViewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel
    private val recyclerAdapter : RecyclerAdapter by lazy {
        RecyclerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.showUsers()



        binding.recyclerViewHomeFragment.adapter = recyclerAdapter
        observeLiveData()
    }
    private fun observeLiveData(){
        viewModel.userList.observe(viewLifecycleOwner){
            recyclerAdapter.setData(it)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}