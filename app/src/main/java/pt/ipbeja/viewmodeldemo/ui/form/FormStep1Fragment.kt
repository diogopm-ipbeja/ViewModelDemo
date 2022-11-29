package pt.ipbeja.viewmodeldemo.ui.form

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.google.android.material.snackbar.Snackbar
import pt.ipbeja.viewmodeldemo.R
import pt.ipbeja.viewmodeldemo.databinding.FormStep1FragmentBinding

class FormStep1Fragment : Fragment() {

    private lateinit var binding: FormStep1FragmentBinding


    private val viewModel: FormViewModel by navGraphViewModels(R.id.formGraph)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FormStep1FragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.i("FormStep1Fragment", "NavGraph-scoped ViewModel => $viewModel")

        binding.nameInput.addTextChangedListener {
            viewModel.name = it?.toString()
        }

        binding.next.setOnClickListener {
            val input = binding.nameInput.text?.toString()

            if (input.isNullOrBlank()) {
                Snackbar.make(requireView(), "Name is mandatory.", Snackbar.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(FormStep1FragmentDirections.actionFormStep1FragmentToFormStep2Fragment())
            }

        }
    }

}