package cn.dev.knowall.controller

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.dev.knowall.R
import cn.dev.knowall.activity.DisplayActivity
import cn.dev.knowall.activity.DisplayActivity.Companion.IMG_ID
import cn.dev.knowall.activity.DisplayActivity.Companion.TITLE
import cn.dev.knowall.utils.Item
import com.bumptech.glide.Glide
import java.util.*

class CardAdapter(private val itemList: ArrayList<Item>) :
        RecyclerView.Adapter<CardAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCase.text = itemList[position].imageName
        Glide.with(holder.itemView.context).load(itemList[position].imageID).into(holder.ivCase)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DisplayActivity::class.java)
            intent.putExtra(IMG_ID, itemList[position].imageID)
            intent.putExtra(TITLE, itemList[position].imageName)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = itemList.size
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivCase: ImageView = itemView.findViewById(R.id.iv_case)
        var tvCase: TextView = itemView.findViewById(R.id.tv_case)
    }
}
