package pt.ipbeja.viewmodeldemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import pt.ipbeja.viewmodeldemo.databinding.ThirdFragmentBinding

class ThirdFragment : Fragment() {


    private lateinit var binding: ThirdFragmentBinding
    private val fragmentScopedViewModel: FragmentScopedViewModel by viewModels()
    private val activityScopedViewModel: ActivityScopedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ThirdFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ThirdFragmentBinding.inflate(inflater).let {
        Log.i("ThirdFragment", "onCreateView")
        this.binding = it
        it.root
    }

    override fun onResume() {
        super.onResume()
        Log.i(
            "ThirdFragment",
            "Fragment-scoped VM => Counter value is ${fragmentScopedViewModel.incrementAndGetCounter()}"
        )
        Log.i(
            "ThirdFragment",
            "Activity-scoped VM => Counter value is ${activityScopedViewModel.incrementAndGetCounter()}"
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("ThirdFragment", "onDestroyView")
    }

    override fun onDestroy() {
        Log.i("ThirdFragment", "onDestroy")
        super.onDestroy()
    }

}