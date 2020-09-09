package com.example.tasks.service.listener

import com.example.tasks.service.Model.HeaderModel

interface APIListener<T> {

    fun onSuccess(model: T)

    fun onFailure(str: String)
}