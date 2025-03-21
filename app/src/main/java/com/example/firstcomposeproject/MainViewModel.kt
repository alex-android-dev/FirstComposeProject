package com.example.firstcomposeproject

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
    val models = _models as LiveData<List<InstagramModel>>

    fun changeFollowingStatus(model: InstagramModel) {
        _models.value = _models.value?.map { currentItem ->
            if (currentItem == model) {
                currentItem.copy(isFollowed = !currentItem.isFollowed)
            } else {
                currentItem
            }
        }
    }

}