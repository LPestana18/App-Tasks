package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasks.service.Model.PriorityModel
import com.example.tasks.service.Model.TaskModel
import com.example.tasks.service.listener.ValidationListener
import com.example.tasks.service.repository.PriorityRepository

class TaskFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mPriorityrepository = PriorityRepository(application)

    private val mPriorityList = MutableLiveData<List<PriorityModel>>()
    var priorities: MutableLiveData<List<PriorityModel>> = mPriorityList

    fun listPriorities(){
        mPriorityList.value = mPriorityrepository.list()
    }

    fun save(task: TaskModel) {

    }

}