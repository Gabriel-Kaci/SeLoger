package com.seloger.presentation.home

import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.seloger.core.domain.Announcement
import com.seloger.view.AnnouncementView

class AnnouncementAdapter(private var items: List<Announcement>) :
    RecyclerView.Adapter<AnnouncementAdapter.ViewHolder>() {

    private var itemClickListener: (Int, Announcement) -> Unit = { _, _ -> }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(AnnouncementView(parent.context))

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.bindData(items[position])
        holder.view.setOnClickListener {
            itemClickListener(
                holder.adapterPosition,
                items[holder.adapterPosition]
            )
        }
    }

    override fun getItemCount() = items.size

    fun updateData(data: List<Announcement>) {
        items = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(l: (Int, Announcement) -> Unit) {
        itemClickListener = l
    }

    class ViewHolder(val view: AnnouncementView) : RecyclerView.ViewHolder(view)
}