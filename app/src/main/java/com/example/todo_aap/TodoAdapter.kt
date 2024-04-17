package com.example.todo_aap


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class TodoAdapter(private val context: Context, private val todoList: List<Todo>) : BaseAdapter() {

    override fun getCount(): Int {
        return todoList.size
    }

    override fun getItem(position: Int): Any {
        return todoList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_list_item_todo, parent, false)
            viewHolder = ViewHolder()
            viewHolder.titleTextView = view.findViewById(R.id.titleTextView)
            viewHolder.descriptionTextView = view.findViewById(R.id.descriptionTextView)
            viewHolder.completedCheckbox = view.findViewById(R.id.completedCheckbox)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val todo = todoList[position]
        viewHolder.titleTextView.text = todo.title
        viewHolder.descriptionTextView.text = todo.description
        viewHolder.completedCheckbox.isChecked = todo.isCompleted

        return view!!
    }

    private class ViewHolder {
        lateinit var titleTextView: TextView
        lateinit var descriptionTextView: TextView
        lateinit var completedCheckbox: CheckBox
    }
}
