package upf.edu.squadfinder.ui.esdeveniments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.databinding.FragmentEsdevenimentsBinding
import upf.edu.squadfinder.ui.esdeveniments.EsdevenimentsRecyclerViewAdapter


class EsdevenimentsFragment : Fragment() {

    private lateinit var esdevenimentsViewModel: EsdevenimentsViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<EsdevenimentsRecyclerViewAdapter.ViewHolder>? = null

    private var _binding: FragmentEsdevenimentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEsdevenimentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewEsdeveniments.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = EsdevenimentsRecyclerViewAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}