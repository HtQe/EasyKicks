package com.example.easykicks.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.easykicks.Model.CategoryModel
import com.example.easykicks.Model.ItemsModel
import com.example.easykicks.Repository.MainRepository

class MainViewModel:ViewModel(){

    private val repository=MainRepository()

    //private val repository= MainRepository()

    val category: LiveData<MutableList<CategoryModel>> = repository.loadCategory()


    val bestSeller: LiveData<MutableList<ItemsModel>> = repository.loadBestSellers()

}


