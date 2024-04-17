package com.example.todo_aap

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var todoList: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoList = mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList)
        listView = findViewById(R.id.listView)
        listView.adapter = adapter

        val addButton = findViewById<Button>(R.id.addButton)
        val editText = findViewById<EditText>(R.id.editText)

        addButton.setOnClickListener {
            val newTask = editText.text.toString()
            if (newTask.isNotEmpty()) {
                todoList.add(newTask)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            todoList.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }
    }
}
