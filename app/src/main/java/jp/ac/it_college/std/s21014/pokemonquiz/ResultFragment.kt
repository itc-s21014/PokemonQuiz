package jp.ac.it_college.std.s21014.pokemonquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.it_college.std.s21014.pokemonquiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvResult.apply {
            layoutManager = LinearLayoutManager(activity).apply {
                addItemDecoration(DividerItemDecoration(activity, orientation))
            }
            adapter = ResultAdapter(args.resultDataArray.toList())
        }
        binding.btTitle.setOnClickListener{
            Navigation.findNavController(it).navigate(
                ResultFragmentDirections.resultToTitle()
            )
        }
        binding.tvMode.text = getString(R.string.mode, if (args.isHard) getString(R.string.hard) else getString(R.string.easy))
        binding.tvScore.text = getString(R.string.score, args.resultDataArray.filter { r -> r.yourAnswer == r.correctAnswer }.size)
    }
}