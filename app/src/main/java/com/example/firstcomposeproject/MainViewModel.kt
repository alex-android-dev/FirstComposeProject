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
    val models : LiveData<List<InstagramModel>> = _models

    fun changeFollowingStatus(model: InstagramModel) {
        _models.value = _models.value?.map { currentItem ->
            if (currentItem == model) {
                currentItem.copy(isFollowed = !currentItem.isFollowed)
            } else {
                currentItem
            }
        }
    }

    fun delete(model: InstagramModel) {

        _models.value = (_models.value as MutableList<InstagramModel>).apply {
            remove(model)
        }

        Log.d("MainActivity", "item ${model.id} deleted")
        Log.d("MainActivity", "size of models: ${_models.value?.size}")
    }

}