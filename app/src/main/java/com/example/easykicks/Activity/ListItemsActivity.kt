package com.example.easykicks.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easykicks.R
import com.example.easykicks.ViewModel.MainViewModel
import com.example.easykicks.databinding.ActivityListItemsBinding

class ListItemsActivity : AppCompatActivity() {
    lateinit var binding: ActivityListItemsBinding
    private val viewModel= MainViewModel()
    private var id: String = ""
    private var title: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)

        binding = ActivityListItemsBinding.inflate(layoutInflater)

        getBundle()

    }

    private fun getBundle() {
        id=intent.getStringExtra("id").toString()
        title=intent.getStringExtra("title").toString()

    }
}