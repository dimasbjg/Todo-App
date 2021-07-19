package com.dicoding.todoapp.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.data.TaskRepository
import kotlinx.coroutines.launch

class SettingsViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private var _nearestTask =MutableLiveData<Task>()
    val nearesttask: LiveData<Task> = _nearestTask

    fun setNearestTask(){
        viewModelScope.launch {
            _nearestTask.postValue(taskRepository.getNearestActiveTask())
        }
    }

}