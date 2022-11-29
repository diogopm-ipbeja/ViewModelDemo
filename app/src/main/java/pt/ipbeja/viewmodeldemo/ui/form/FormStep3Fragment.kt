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
import pt.ipbeja.viewmodeldemo.R
import pt.ipbeja.viewmodeldemo.databinding.FormStep1FragmentBinding
import pt.ipbeja.viewmodeldemo.databinding.FormStep3FragmentBinding

class FormStep3Fragment : Fragment() {

    private lateinit var binding: FormStep3FragmentBinding

    private val viewModel: FormViewModel by navGraphViewModels(R.id.formGraph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FormStep3FragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("FormStep3Fragment", "NavGraph-scoped ViewModel => $viewModel")

        binding.name.text = viewModel.name
        binding.dob.text = viewModel.dateOfBirth?.toString()

        binding.finish.setOnClickListener {
            findNavController().popBackStack(R.id.formStep1Fragment, true)
        }
    }
}