package com.munstein.basictodokotlin.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.ToggleButton
import com.munstein.basictodokotlin.R
import com.munstein.basictodokotlin.model.Task

/**
 * Created by @Munstein on 01/12/2017. --15:06
 */
class CustomAdapter(context : Context, tasks : List<Task>, checkedChangeListener: CompoundButton.OnCheckedChangeListener) : BaseAdapter() {

    private val inflater = LayoutInflater.from(context)
    private var tasks : List<Task> = tasks
    private var checkedChangeListener  = checkedChangeListener

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = this.inflater.inflate(R.layout.custom_list_item, parent, false)
        var task = tasks.get(position)

        var textDescription = view.findViewById<TextView>(R.id.custom_text_description)
        textDescription.text = task.description

        var toggleFavorite = view.findViewById<ToggleButton>(R.id.custom_toggle_favorite)
        toggleFavorite.isChecked = task.isFavorite
        toggleFavorite.tag = position
        toggleFavorite.setOnCheckedChangeListener(checkedChangeListener)

        return view
    }

    override fun getItem(position: Int): Any {
        return tasks.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return 0;
    }

    override fun getCount(): Int {
        return tasks.size
    }

}