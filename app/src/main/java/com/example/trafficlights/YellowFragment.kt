package com.example.trafficlights

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.trafficlights.databinding.FragmentYellowBinding

class YellowFragment : Fragment() {

    private var _binding: FragmentYellowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
    _binding = FragmentYellowBinding.inflate(layoutInflater, container, false)
        return _binding!!.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: YellowFragmentArgs by navArgs()
        val text = args.yellowArg
        binding.yellowTV.text = text
    }
}