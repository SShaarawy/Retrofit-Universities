package com.example.kotlinretrofit.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinretrofit.R
import com.example.kotlinretrofit.model.Dog

class RecyclerViewAdapter(private val uniList: List<Dog>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    class RowHolder(view: View) : RecyclerView.ViewHolder(view)

    //arrayOf("#58BA05","#FF45BCCA","#FF0000","#FFFFFF")
    //private val colors = arrayOf("#58BA05","#FF45BCCA","#FF0000","#FFFFFF")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val length = uniList?.get(position)?.web_pages?.size
        var str = ""
        for (i in 0 until length!!) {
            if (i != (length - 1)) {
                str += uniList?.get(position)?.web_pages?.get(i) + ",\n"
            } else {
                str += uniList?.get(position)?.web_pages?.get(i)
            }
        }
        holder.itemView.findViewById<TextView>(R.id.tvWebPages).text = str
        holder.itemView.findViewById<TextView>(R.id.tvName).text = uniList[position].name
        holder.itemView.findViewById<TextView>(R.id.tvAlphaTwoCode).text =
            uniList[position].alpha_two_code
        holder.itemView.findViewById<TextView>(R.id.tvCountry).text = uniList[position].country
        //  holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 4]))
    }

    override fun getItemCount(): Int {
        return uniList.size
    }
}