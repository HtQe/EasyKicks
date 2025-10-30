package com.example.easykicks

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easykicks.Activity.BaseActivity
import com.example.easykicks.Adapter.CategoryAdapter
import com.example.easykicks.ViewModel.MainViewModel
import com.example.easykicks.databinding.ActivityMainBinding
import com.example.easykicks.databinding.ViewholderCategoryBinding

class MainActivity : BaseActivity() {
    private val viewModel = MainViewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategoryList()
    }

    private fun initCategoryList() {
        binding.progressBarCategory.visibility= View.VISIBLE
        viewModel.category.observe(this,{
            binding.viewCategories.layoutManager=
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            binding.viewCategories.adapter= CategoryAdapter(it)
            binding.progressBarCategory.visibility=View.GONE
        })
    }
}