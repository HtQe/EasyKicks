package com.example.easykicks.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easykicks.Model.CategoryModel
import com.example.easykicks.Model.ItemsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase= FirebaseDatabase.getInstance()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        val categoryLiveData = MutableLiveData<MutableList<CategoryModel>>()
        val ref=firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<CategoryModel>()
                for (chilldSnapShot in snapshot.children) {
                    val list = chilldSnapShot.getValue(CategoryModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                categoryLiveData.value = lists

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return categoryLiveData
    }
    fun loadBestSellers(): LiveData<MutableList<ItemsModel>> {
        val BestSellerLiveData = MutableLiveData<MutableList<ItemsModel>>()
        val ref=firebaseDatabase.getReference("BestSeller")


        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemsModel>()
                for (childSnapShot in snapshot.children) {
                    val list = childSnapShot.getValue(ItemsModel::class.java)
                    if(list!=null){
                        lists.add(list)
                    }
                }
                BestSellerLiveData.value = lists

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return BestSellerLiveData


    }

    fun loadItem(cateoguId:String): LiveData<MutableList<ItemsModel>> {
        val ItemsLiveData = MutableLiveData<MutableList<ItemsModel>>()
        val ref=firebaseDatabase.getReference("Item")
        val query: Query=ref.orderByChild("cateogryId").equalTo(cateoguId)




        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemsModel>()
                for (childSnapShot in snapshot.children) {
                    val list = childSnapShot.getValue(ItemsModel::class.java)
                    if(list!=null){
                        lists.add(list)
                    }
                }
                ItemsLiveData.value = lists

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return ItemsLiveData


    }
}

