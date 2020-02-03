package com.example.myapplicationid.user_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationid.R
import com.example.myapplicationid.repository.entity.ResultItem

class ResultItemAdapter( private val callback: OnItemClickListener? ) : RecyclerView.Adapter<ResultItemAdapter.ViewHolder>() {


var list = emptyList<ResultItem>()



    interface OnItemClickListener {
        fun onItemClick (item: ResultItem)
    }

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         private val firstName: TextView = itemView.findViewById(R.id.first_name)
         private val lastName: TextView = itemView.findViewById(R.id.last_name)
         private val imgAvatar: ImageView = itemView.findViewById(R.id.image_view)

        fun bind (data: ResultItem){

            firstName.text = data.firstName.toString()
            lastName.text = data.lastName.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )

    }

    override fun getItemCount() = list.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = list [position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            callback?.onItemClick(list[holder.adapterPosition])
        }

    }
}