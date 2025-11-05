package com.example.easykicks.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.easykicks.Model.CategoryModel
import com.example.easykicks.Model.ItemModel
import com.example.easykicks.Repository.MainRepository

class MainViewModel(private val repository: MainRepository):ViewModel() {

    //private val repository= MainRepository()

    val category: LiveData<MutableList<CategoryModel>> = repository.loadCategory()


    val bestSeller: LiveData<MutableList<ItemModel>> = repository.loadBestSellers()

}


