package jp.ac.it_college.std.s21014.pokemonquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import jp.ac.it_college.std.s21014.pokemonquiz.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private var _binding: FragmentTitleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btEasy.setOnClickListener {
            Navigation.findNavController(it).navigate(
                TitleFragmentDirections.titleToSelect(false)
            )
        }
        binding.btHard.setOnClickListener {
            Navigation.findNavController(it).navigate(
                TitleFragmentDirections.titleToSelect(true)
            )
        }
    }
}