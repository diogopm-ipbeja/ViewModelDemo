package pt.ipbeja.viewmodeldemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import pt.ipbeja.viewmodeldemo.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {


    private lateinit var binding: SecondFragmentBinding
    private val fragmentScopedViewModel: FragmentScopedViewModel by viewModels()
    private val activityScopedViewModel: ActivityScopedViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("SecondFragment", "onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = SecondFragmentBinding.inflate(inflater).let {
        Log.i("SecondFragment", "onCreateView")
        this.binding = it
        it.root
    }

    override fun onResume() {
        super.onResume()
        Log.i(
            "SecondFragment",
            "Fragment-scoped VM => Counter value is ${fragmentScopedViewModel.incrementAndGetCounter()}"
        )
        Log.i(
            "SecondFragment",
            "Activity-scoped VM => Counter value is ${activityScopedViewModel.incrementAndGetCounter()}"
        )
        binding.button.setOnClickListener {
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("SecondFragment", "onDestroyView")
    }

    override fun onDestroy() {
        Log.i("SecondFragment", "onDestroy")
        super.onDestroy()
    }

}