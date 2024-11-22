package com.example.trafficlights

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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

        (activity as AppCompatActivity).setSupportActionBar(binding.yellowToolbar)
        setHasOptionsMenu(true)

        binding.yellowToolbar.setNavigationIcon(R.drawable.ic_back)
        binding.yellowToolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        val args: YellowFragmentArgs by navArgs()
        val text = args.yellowArg
        binding.yellowTV.text = text
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