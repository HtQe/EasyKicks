package com.example.easykicks.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easykicks.Model.ItemsModel
import com.example.easykicks.databinding.ViewholderBestSellerBinding
import com.example.easykicks.databinding.ViewholderItem1Binding
import com.example.easykicks.databinding.ViewholderItem2Binding
import kotlinx.coroutines.NonDisposableHandle.parent

class ListItemsAdapter(val items:MutableList<ItemsModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        const val VIEW_TYPE_ITEM1 = 0
        const val VIEW_TYPE_ITEM2 = 1
    }

    private var context: Context? = null

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) VIEW_TYPE_ITEM1 else VIEW_TYPE_ITEM2
    }

    override fun getItemCount(): Int = items.size

    class ViewholderItem1(val binding: ViewholderItem1Binding) :
        RecyclerView.ViewHolder(binding.root)

    class ViewholderItem2(val binding: ViewholderItem2Binding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        context = parent.context
        return when (viewType) {
            VIEW_TYPE_ITEM1 -> {
                val binding = ViewholderItem1Binding.inflate(
                    LayoutInflater.from(context), parent, false
                )
                ViewholderItem1(binding)
            }

            VIEW_TYPE_ITEM2 -> {
                val binding = ViewholderItem2Binding.inflate(
                    LayoutInflater.from(context), parent, false
                )
                ViewholderItem2(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        fun bindCommonData(
            titleTxt: String,
            priceTxt: String,
            ratingBar: Float,
            picUrl: String,
            logo: String
        ) {
            when (holder) {
                is ViewholderItem1 -> {
                    holder.binding.titleTxt.text = titleTxt
                    holder.binding.priceTxt.text = priceTxt
                    holder.binding.ratingBar.rating = ratingBar

                    Glide.with(holder.itemView.context)
                        .load(picUrl)
                        .into(holder.binding.pic)

                    Glide.with(holder.itemView.context)
                        .load(logo)
                        .into(holder.binding.logo)
                }

                is ViewholderItem2 -> {
                    holder.binding.titleTxt.text = titleTxt
                    holder.binding.priceTxt.text = priceTxt
                    holder.binding.ratingBar.rating = ratingBar

                    Glide.with(holder.itemView.context)
                        .load(picUrl)
                        .into(holder.binding.pic)

                    Glide.with(holder.itemView.context)
                        .load(logo)
                        .into(holder.binding.logo)
                }
            }

        }
        bindCommonData(
            item.title,
            "${item.price} JD",
            item.rating.toFloat(),
            item.picUrl[0],
            item.logo
        )
    }
}

