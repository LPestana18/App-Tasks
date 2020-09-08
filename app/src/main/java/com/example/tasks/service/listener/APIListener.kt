package com.example.tasks.service.listener

import com.example.tasks.service.Model.HeaderModel

interface APIListener {

    fun onSuccess(model: HeaderModel)

    fun onFailure(str: String)
}