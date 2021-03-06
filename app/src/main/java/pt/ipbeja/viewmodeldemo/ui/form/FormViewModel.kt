package pt.ipbeja.viewmodeldemo.ui.form

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.time.LocalDate

class FormViewModel() : ViewModel() {

    var name: String? = null
    var dateOfBirth: LocalDate? = null

    init {
        Log.i("ViewModelDemo","A new FormViewModel created!")
    }

    override fun toString(): String {
        return "name: $name | dob: $dateOfBirth"
    }


}