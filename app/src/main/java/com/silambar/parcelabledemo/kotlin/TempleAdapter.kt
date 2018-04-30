package com.silambar.parcelabledemo.kotlin

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.silambar.parcelabledemo.R
import java.util.ArrayList

/**
 * Created by silambarasan on 16/03/18.
 */

class TempleAdapter(
    private val temples: ArrayList<Temple>) : RecyclerView.Adapter<TempleAdapter.TempleHolder>() {

  private var onTempleClick: OnTempleClick? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempleHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_temple, parent, false)
    return TempleHolder(view)
  }

  override fun onBindViewHolder(holder: TempleHolder, position: Int) {
    val temple = temples[position]
    holder.templeTitle.text = temple.name
    holder.templeDesc.text = temple.templeInfo?.description
    holder.templeImage.setImageResource(temple.image)
  }

  override fun getItemCount(): Int {
    return temples.size
  }

  fun setClickListener(onTempleClick: OnTempleClick) {
    this.onTempleClick = onTempleClick
  }

  inner class TempleHolder(itemView: View) : ViewHolder(itemView), OnClickListener {

    var templeImage: ImageView = itemView.findViewById(R.id.temple_image)
    var templeTitle: TextView = itemView.findViewById(R.id.temple_title)
    var templeDesc: TextView = itemView.findViewById(R.id.temple_description)

    init {
      itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
      if (onTempleClick != null) {
        onTempleClick?.onClick(v, temples[adapterPosition], adapterPosition)
      }
    }
  }

  interface OnTempleClick {
    fun onClick(view: View, temple: Temple, position: Int)
  }
}
