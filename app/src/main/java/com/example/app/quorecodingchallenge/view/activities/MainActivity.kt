package com.example.app.quorecodingchallenge.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.quorecodingchallenge.R
import com.example.app.quorecodingchallenge.databinding.ActivityMainBinding
import com.example.app.quorecodingchallenge.view.adapters.NewsListAdapter
import com.example.app.quorecodingchallenge.viewmodel.NewsListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : NewsListViewModel
    val adapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        rvNewsList.layoutManager = LinearLayoutManager(this)
        rvNewsList.adapter = adapter
        viewModel.newsList.observe(this, Observer { adapter.setNewsList(it.articles) })
        binding.viewmodel = viewModel
    }
}
