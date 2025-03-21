package com.example.firstcomposeproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _initialList = mutableListOf<InstagramModel>().apply {
        repeat(500) { index ->
            add(
                InstagramModel(
                    id = index,
                    title = "Title number: $index",
                    isFollowed = Random.nextBoolean(),
                )
            )
        }
    }

    private val _models = MutableLiveData<List<InstagramModel>>(_initialList)
    val models: LiveData<List<InstagramModel>> = _models

    fun changeFollowingStatus(model: InstagramModel) {
        val list = _models.value?.toMutableList() ?: mutableListOf()

        list.replaceAll { it ->
            if (it.id == model.id) {
                it.copy(isFollowed = !it.isFollowed)
            } else {
                it
            }
        }

        _models.value = list
    }

    fun delete(model: InstagramModel) {
        val list = _models.value?.toMutableList() ?: mutableListOf()
        list.remove(model)
        _models.value = list

        Log.d("MainActivity", "item ${model.id} deleted")
        Log.d("MainActivity", "size of models: ${_models.value?.size}")
    }

}