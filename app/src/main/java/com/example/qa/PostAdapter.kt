package com.example.qa

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.poll.view.*

class PostAdapter(var activity: Activity, var postList:List<Post>)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(activity).inflate(R.layout.poll, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var title: TextView = view.title;
    var description: TextView = view.description;
    //var question:

    // for binding post info to view
    fun bind(item: Post) {
        title.text = item.title
        description.text = item.description
    }
}