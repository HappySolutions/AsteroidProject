package com.udacity.asteroidradar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.R
import kotlinx.android.synthetic.main.astroid_list_item.view.*

class AsrtoidListAdapter: RecyclerView.Adapter<AsrtoidListAdapter.AstroidsViewHolder>() {


    private var astrList: List<Asteroid>? = null
    fun setAstroidList(astList: List<Asteroid>){
        this.astrList = astList
    }

    class AstroidsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val maintxt = view.maintxt
        val subtxt = view.subtxt
        val statusIMG = view.statusIMG

        fun bind(data: Asteroid) {
            maintxt.text = data.codename
            subtxt.text = data.closeApproachDate
            statusIMG.setImageResource(
                when (data.isPotentiallyHazardous) {
                    true -> R.drawable.asteroid_safe
                    else -> R.drawable.asteroid_hazardous
                }
            )
        }

        companion object {
            fun from(parent: ViewGroup): AstroidsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.astroid_list_item, parent, false)

                return AstroidsViewHolder(view)
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstroidsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.astroid_list_item, parent, false)
        return AstroidsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AstroidsViewHolder, position: Int) {
        holder.bind(astrList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(astrList == null ) return 0
        else
            return astrList?.size!!
    }
}