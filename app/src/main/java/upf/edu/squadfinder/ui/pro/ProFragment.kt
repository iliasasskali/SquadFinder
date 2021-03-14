package upf.edu.squadfinder.ui.pro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import upf.edu.squadfinder.R
import upf.edu.squadfinder.databinding.FragmentProBinding

class ProFragment : Fragment() {

    private lateinit var proViewModel: ProViewModel
    private lateinit var proAdvantages: ListView

    private var _binding: FragmentProBinding? = null
    private val binding get() = _binding!!

    private val proAdvantagesStrings = arrayOf(
            "Elimina la publicitat",
            "Crea grups de forma ilimitada",
            "Crea esdeveniments de forma ilimitada",
            "Properament funcionalitats exclusives")

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.proAdvantages.apply {
            binding.proAdvantages.adapter = ArrayAdapter(context, R.layout.llista_pro, proAdvantagesStrings)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
