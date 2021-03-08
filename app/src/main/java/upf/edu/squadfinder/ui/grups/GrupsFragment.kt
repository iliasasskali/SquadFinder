package upf.edu.squadfinder.ui.grups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.databinding.FragmentGrupsBinding
import upf.edu.squadfinder.ui.grups.GrupsRecyclerViewAdapter

class GrupsFragment : Fragment() {

    private lateinit var grupsViewModel: GrupsViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<GrupsRecyclerViewAdapter.ViewHolder>? = null

    private var _binding: FragmentGrupsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGrupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewGrups.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = GrupsRecyclerViewAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}