package pt.ipbeja.viewmodeldemo.ui.form

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.time.LocalDate

// o objecto SavedStateHandle é injetado automaticamente
class FormViewModel(private val stateHandle: SavedStateHandle) : ViewModel() {

    // Podemos criar um objeto Args a partir desse stateHandle
    private val args = FormStep1FragmentArgs.fromSavedStateHandle(stateHandle)

    // Ou aceder diretamente usando o nome do argumento
    private val myArg = stateHandle.get<Int>("someArg")

    var name: String? = null
    var dateOfBirth: LocalDate? = null

    init {
        Log.i(
            "FormViewModel",
            "A new FormViewModel created! (navArgs: ${args.someArg} == stateHandle: $myArg)"
        )
    }

    override fun toString(): String {
        return "name: $name | dob: $dateOfBirth"
    }

    override fun onCleared() {
        Log.i("FormViewModel", "DESTROYED!")
        super.onCleared()
    }

}