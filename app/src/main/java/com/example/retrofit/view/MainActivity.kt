package com.example.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.dataBinding.ActivityMainBinding
import com.example.retrofit.view.adapter.RecyclerAdapter
import com.example.retrofit.viewmodel.mainViewModel
import com.example.retrofit.viewmodel.viewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: mainViewModel
    private val adapter:RecyclerAdapter by lazy {RecyclerAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory()).get(mainViewModel::class.java)
        setUpRecycler()

        binding.refresh.setOnRefreshListener { viewModel.getDataViewModel() }

        viewModel.data.observe(this, Observer {
            adapter.setList(it)
            leyoutAnimation()
            binding.refresh.isRefreshing = false
        })

    }

    private fun leyoutAnimation()  {
        val context = binding.recycler.context
        val LayoutAnimationController = AnimationUtils.loadLayoutAnimation(context, )
        LayoutAnimationController.also { binding.recycler.layoutAnimation = it }
        binding.recycler.adapter?.notifyDataSetChanged()
        binding.recycler.scheduleLayoutAnimation()

    }

    private fun setUpRecycler() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }
}