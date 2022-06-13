package com.adarshsv.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView



    class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        var userList = mutableListOf<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        val holder = ViewHolder(v)
        /*holder.name = v.findViewById<TextView>(R.id.name)
        holder.email = v.findViewById<TextView>(R.id.email)
        holder.status = v.findViewById<TextView>(R.id.status)*/
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = userList[position].name.toString()
        holder.email.text = userList[position].email.toString()
        holder.status.text = userList[position].status.toString()

    }

    override fun getItemCount(): Int {
        return userList.size
    }
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
              val name = view.findViewById<TextView>(R.id.name)
            val email = view.findViewById<TextView>(R.id.email)
            val status = view.findViewById<TextView>(R.id.status)

           /* fun bind(data : User) {
                name.text = data.name
                email.text = data.email
                status.text = data.status
            }*/


        }
}


