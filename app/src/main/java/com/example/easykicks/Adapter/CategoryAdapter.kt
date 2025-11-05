package com.example.easykicks.Adapter

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easykicks.Activity.ListItemsActivity
import com.example.easykicks.Model.CategoryModel
import com.example.easykicks.databinding.ViewholderCategoryBinding
import com.example.easykicks.R
import com.google.firebase.database.Transaction

class CategoryAdapter(val items: MutableList<CategoryModel>)
    :RecyclerView.Adapter<CategoryAdapter.Viewholder>() {
    inner class Viewholder(val binding: ViewholderCategoryBinding)
        :RecyclerView.ViewHolder(binding.root)

    private var selectedPosition = -1
    private var lastSelectedPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): CategoryAdapter.Viewholder {
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)

    }

    override fun onBindViewHolder(holder: CategoryAdapter.Viewholder, position:Int) {
        val item = items[position]
        holder.binding.titleCat.text=item.title
        Glide.with(holder.itemView.context).load(item.picUrl).into(holder.binding.pacCat)

        if(selectedPosition==position){
            holder.binding.pacCat.setBackgroundResource(R.drawable.green_bg)
            ImageViewCompat.setImageTintList(holder.binding.pacCat, ColorStateList.valueOf(
                ContextCompat.getColor(holder.itemView.context, R.color.white)))

        }else{
            holder.binding.pacCat.setBackgroundResource(R.drawable.gray_oval_bg)
            ImageViewCompat.setImageTintList(holder.binding.pacCat, ColorStateList.valueOf(
                ContextCompat.getColor(holder.itemView.context, R.color.black)))
        }
        holder.binding.root.setOnClickListener {
            if(position!= RecyclerView.NO_POSITION){
                lastSelectedPosition=selectedPosition
                selectedPosition=position
                notifyItemChanged(lastSelectedPosition)
                notifyItemChanged(selectedPosition)
            }
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(holder.itemView.context, ListItemsActivity::class.java).apply{
                    putExtra("id",item.id.toString())
                    putExtra("title",item.title)
                    putExtra("picUrl",item.picUrl)

                }
                ContextCompat.startActivity(holder.itemView.context,intent,null)
            },500)
        }
    }

    override fun getItemCount(): Int = items.size
}