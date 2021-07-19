package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.TASK_ID
import java.text.SimpleDateFormat

class DetailTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val viewModel: DetailTaskViewModel
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this,factory).get(DetailTaskViewModel::class.java)

        val extras = intent.getIntExtra(TASK_ID, 0)
        viewModel.setTaskId(extras)
        val title = findViewById<TextView>(R.id.detail_ed_title)
        val description = findViewById<TextView>(R.id.detail_ed_description)
        val dueDate = findViewById<TextView>(R.id.detail_ed_due_date)

        viewModel.task.observe(this, {data ->
            if (data != null) {
                title.text = data.title
                description.text = data.description
                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
                val date = simpleDateFormat.format(data.dueDateMillis)
                dueDate.text = date
            }
        })

        val buttonDelete = findViewById<Button>(R.id.btn_delete_task)

        buttonDelete.setOnClickListener {
            viewModel.deleteTask()
            finish()
        }

    }
}