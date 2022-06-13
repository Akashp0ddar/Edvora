package com.akash.edvora.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akash.edvora.databinding.ItemNearestRvBinding
import com.akash.edvora.rides.Rides
import com.akash.edvora.rides.RidesItem
import com.bumptech.glide.Glide

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var myList = emptyList<RidesItem>()

    class ViewHolder(val binding: ItemNearestRvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNearestRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvRideResult.text = myList[position].id.toString()
        holder.binding.tvOriginStationResult.text = myList[position].origin_station_code.toString()
        holder.binding.tvStationPathResult.text = myList[position].station_path.toString()
        holder.binding.tvDateResult.text = myList[position].date
        holder.binding.tvDistanceResult.text = myList[position].destination_station_code.toString()
        Glide.with(holder.binding.ivMapImage.context).load(myList[position].map_url).into(holder.binding.ivMapImage)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<RidesItem>) {
        myList = newList
        notifyDataSetChanged()
    }

}