package pt.ipbeja.viewmodeldemo.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel

class ActivityScopedViewModel(app: Application) : AndroidViewModel(app) {

    var counter = 0

    init {
        Log.i("ActivityScopedViewModel", "created a new ViewModel")
    }

    fun incrementAndGetCounter(): Int {
        return ++counter
    }

    override fun onCleared() {
        Log.i("ActivityScopedViewModel", "DESTROYED!")
        super.onCleared()
    }

}