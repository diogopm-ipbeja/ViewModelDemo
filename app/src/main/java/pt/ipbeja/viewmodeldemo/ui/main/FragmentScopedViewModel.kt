package pt.ipbeja.viewmodeldemo.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import java.time.LocalDate

class FragmentScopedViewModel(app: Application) : AndroidViewModel(app) {

     var counter = 0

     init {
          Log.i("FragmentScopedViewModel", "created a new ViewModel")
     }

     fun incrementAndGetCounter() : Int {
          return ++counter
     }

     override fun onCleared() {
          Log.i("FragmentScopedViewModel","DESTROYED!")
          super.onCleared()
     }

}