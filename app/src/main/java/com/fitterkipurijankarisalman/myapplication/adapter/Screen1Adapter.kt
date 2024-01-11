package com.fitterkipurijankarisalman.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitterkipurijankarisalman.myapplication.R
import com.fitterkipurijankarisalman.myapplication.databinding.SingleItemBinding
import com.fitterkipurijankarisalman.myapplication.model.Model

class Screen1Adapter constructor(
    private val context: Context,
    private var list: ArrayList<Model>
) : RecyclerView.Adapter<Screen1Adapter.Screen1ViewHolder>() {

    private lateinit var callback: AdapterCallback

    private lateinit var filterList: ArrayList<Model>

    public fun initAdapterCallback(listener: AdapterCallback) {
        callback = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Screen1ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.single_item,
            parent,
            false
        )

        return Screen1ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Screen1ViewHolder, position: Int) {
        holder.binding.singleItemBtn.text = list[position].name
        holder.binding.singleItemBtn.setOnClickListener {
            callback.onButtonClick(
                list[position].clickIndex
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Screen1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = SingleItemBinding.bind(itemView)
    }

    fun setFilter(newList: ArrayList<Model>) {
        list = ArrayList()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    interface AdapterCallback {
        fun onButtonClick(position: Int)
    }
}