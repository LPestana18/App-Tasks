package com.example.tasks.service.repository

import android.content.Context
import com.example.tasks.service.Model.PriorityModel
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.repository.local.TaskDatabase
import com.example.tasks.service.repository.remote.PriorityService
import com.example.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class PriorityRepository(val context: Context): BaseRepository(context){

    private val mRemote = RetrofitClient.createService(PriorityService::class.java)
    private val mDatabase = TaskDatabase.getDatabase(context).priorityDAO()

    fun all(param: APIListener<List<PriorityModel>>) {

        if(!isConnectionAvailable(context)) {
            return
        }

        val call: Call<List<PriorityModel>> = mRemote.list()
        call.enqueue(object : Callback<List<PriorityModel>> {

            override fun onFailure(call: Call<List<PriorityModel>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<PriorityModel>>,
                response: Response<List<PriorityModel>>
            ) {

                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    mDatabase.clear()
                    response.body()?.let { mDatabase.save(it) }
                }
            }
        })
    }

    fun list() = mDatabase.list()


    fun save(list: List<PriorityModel>) {
        mDatabase.clear()
        mDatabase.save(list)
    }

    fun getDescription(id: Int) = mDatabase.getDescription(id)

}