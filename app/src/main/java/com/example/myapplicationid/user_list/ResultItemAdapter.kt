package com.example.myapplicationid.user_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationid.R
import com.example.myapplicationid.repository.entity.ResultItem

class ResultItemAdapter( var list: ArrayList<ResultItem>) : RecyclerView.Adapter<ResultItemAdapter.ViewHolder>() {

//    ,val onClick: ((ResultItem) -> Unit)?

//   val list = emptyList<ResultItem>()

//    private val resItem: MutableList<ResultItem> = LinkedList()


    private var mListener:OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick (position: Int)
    }

    fun setOnItemClickListener (listener: OnItemClickListener? ) {
        mListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var first_name: TextView
         var last_name: TextView
         var imgAvatar: ImageView

        init {
            first_name = itemView.findViewById(R.id.firstName)
            last_name = itemView.findViewById(R.id.lastName)
            imgAvatar =  itemView.findViewById(R.id.imageView)
            itemView.setOnClickListener{
                if (mListener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                   mListener!!.onItemClick(position)
                    }
                }
            }
        }




//        fun bind(item: ResultItem, onClick: ((ResultItem) -> Unit)?) {
//
//            first_name.text = item.firstName
//            last_name.text = item.lastName
//
//            itemView.setOnClickListener { onClick?.invoke(item) }
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = list [position]
        val firstName: String? = currentItem.firstName
        val lastName: String? = currentItem.lastName
        holder.first_name.text = firstName
        holder.last_name.text = lastName


//        holder.bind(list[position], onClick)
    }

//    interface DataCallback {
//        fun itemClicked(data: ResultItem)
//    }
}