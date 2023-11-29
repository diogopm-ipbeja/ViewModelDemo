package pt.ipbeja.viewmodeldemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import pt.ipbeja.viewmodeldemo.databinding.MainFragmentBinding
import kotlin.random.Random

class MainFragment : Fragment() {


    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = MainFragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.startForm.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                MainFragmentDirections.actionMainFragmentToFormGraph(
                    Random.nextInt()
                )
            )
        )
        binding.secondFragmentBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                MainFragmentDirections.actionMainFragmentToSecondFragment()
            )
        )
    }

}