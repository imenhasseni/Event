package com.example.mobeliteevents.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobeliteevents.R
import com.example.mobeliteevents.model.CategoryItem

class CategoryItemAdapter(private val context: Context, private val CategoryItem : List<CategoryItem>): RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder>() {
    class CategoryItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView
        init {
            itemImage= itemView.findViewById(R.id.item_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
      return CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_row_items, parent, false ))
    }

    override fun getItemCount(): Int {
        return  CategoryItem.size
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
     holder.itemImage.setImageResource(CategoryItem[position].imageUrl)
    }
}
