package pt.ipbeja.viewmodeldemo.ui.form

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import pt.ipbeja.viewmodeldemo.R
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
        Log.i(
            "FormStep2Fragment", "NavGraph-scoped ViewModel => $viewModel"
        )

        if (viewModel.dateOfBirth == null) {
            viewModel.dateOfBirth = LocalDate.now()
        }

        viewModel.dateOfBirth?.run {
            // DatePicker month starts at 0, LocalDate starts at 1 ¯\_(ツ)_/¯
            binding.dateOfBirth.updateDate(year, monthValue - 1, dayOfMonth)
        }


        binding.dateOfBirth.setOnDateChangedListener { _, year, month, day ->
            Log.i(FormStep2Fragment::class.java.simpleName, "Date changed to $year/$month/$day")

            // DatePicker month starts at 0, LocalDate starts at 1 ¯\_(ツ)_/¯
            viewModel.dateOfBirth = LocalDate.of(year, month + 1, day)
        }

        binding.next.setOnClickListener {
            findNavController().navigate(FormStep2FragmentDirections.actionFormStep2FragmentToFormStep3Fragment())
        }
    }


}