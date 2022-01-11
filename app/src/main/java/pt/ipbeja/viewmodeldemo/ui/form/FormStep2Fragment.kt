package pt.ipbeja.viewmodeldemo.ui.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.google.android.material.snackbar.Snackbar
import pt.ipbeja.viewmodeldemo.R
import pt.ipbeja.viewmodeldemo.databinding.FormStep1FragmentBinding
import pt.ipbeja.viewmodeldemo.databinding.FormStep2FragmentBinding
import java.time.LocalDate

class FormStep2Fragment : Fragment() {

    private lateinit var binding: FormStep2FragmentBinding

    private val viewModel: FormViewModel by navGraphViewModels(R.id.formGraph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FormStep2FragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("ViewModelDemo",viewModel.toString())

        binding.next.setOnClickListener {

            val input = binding.dateOfBirth

            viewModel.dateOfBirth = LocalDate.of(input.year, input.month+1, input.dayOfMonth)

            findNavController().navigate(FormStep2FragmentDirections.actionFormStep2FragmentToFormStep3Fragment())
        }
    }


}