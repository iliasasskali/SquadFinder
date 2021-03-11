package upf.edu.squadfinder.ui.pro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import upf.edu.squadfinder.R
import upf.edu.squadfinder.databinding.FragmentGrupsBinding
import upf.edu.squadfinder.databinding.FragmentProBinding
import upf.edu.squadfinder.ui.grups.GrupsRecyclerViewAdapter

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
