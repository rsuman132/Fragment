package com.rs132studio.fragment.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rs132studio.fragment.Model.Contacts
import com.rs132studio.fragment.R

class ContactAdapter(private val contactList: ArrayList<Contacts>, private val listener : OnItemClicked)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val CONTACT_LEFT_ALIGN = 1
        const val CONTACT_RIGHT_ALIGN = 2
    }
    inner class ContactViewHolder1(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var name : TextView = itemView.findViewById(R.id.contact_name)
        var description : TextView = itemView.findViewById(R.id.contact_description)
        var cImage : ImageView = itemView.findViewById(R.id.contact_Images)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemDetailsClicked(position)
            }
        }

    }

    inner class ContactViewHolder2(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var name : TextView = itemView.findViewById(R.id.contact_name_Right)
        var description : TextView = itemView.findViewById(R.id.contact_description_Right)
        var cImage : ImageView = itemView.findViewById(R.id.contact_Images_Right)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemDetailsClicked(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return if(viewType == CONTACT_LEFT_ALIGN) {
            ContactViewHolder1(
                LayoutInflater.from(parent.context).inflate(R.layout.contact_details_list, parent, false)
            )
        }else {
            ContactViewHolder2(
                LayoutInflater.from(parent.context).inflate(R.layout.contact_detail_list2, parent, false)
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = contactList[position]
        if (getItemViewType(position) == CONTACT_LEFT_ALIGN){
            val holder = holder as ContactViewHolder1
            holder.name.text = item.name
            holder.description.text = item.description
            holder.cImage.setImageResource(item.cImages)
        } else {
            val holder = holder as ContactViewHolder2
            holder.name.text = item.name
            holder.description.text = item.description
            holder.cImage.setImageResource(item.cImages)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun getItemViewType(position: Int): Int {
        val element = contactList[position]
        return if (element.name.length <= 7) {
            CONTACT_LEFT_ALIGN
        } else  {
            CONTACT_RIGHT_ALIGN
        }
    }


    interface OnItemClicked{
        fun onItemDetailsClicked(position: Int)
    }
}