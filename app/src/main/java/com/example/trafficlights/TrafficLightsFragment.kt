package com.example.trafficlights

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.trafficlights.databinding.FragmentTrafficLightsBinding

class TrafficLightsFragment : Fragment() {

    private var _binding: FragmentTrafficLightsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTrafficLightsBinding.inflate(layoutInflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding.trafficLightsToolbar)
        setHasOptionsMenu(true)

        binding.greenLightBTN.setOnClickListener {
            val text = binding.greenLightBTN.text.toString()
            val action = TrafficLightsFragmentDirections.actionTrafficLightsFragmentToGreenFragment(text)
            val extras = FragmentNavigatorExtras(
                binding.greenLightBTN to "greenButton"
            )
            findNavController().navigate(action, extras)
        }

        binding.yellowLightBTN.setOnClickListener {
            val text = binding.yellowLightBTN.text.toString()
            val action = TrafficLightsFragmentDirections.actionTrafficLightsFragmentToYellowFragment(text)
            val extras = FragmentNavigatorExtras(
                binding.yellowLightBTN to "yellowButton"
            )
            findNavController().navigate(action, extras)
        }

        binding.redLightBTN.setOnClickListener {
            val text = binding.redLightBTN.text.toString()
            val action = TrafficLightsFragmentDirections.actionTrafficLightsFragmentToRedFragment(text)
            val extras = FragmentNavigatorExtras(
                binding.redLightBTN to "redButton"
            )
            findNavController().navigate(action, extras)
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_item, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> requireActivity().finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}