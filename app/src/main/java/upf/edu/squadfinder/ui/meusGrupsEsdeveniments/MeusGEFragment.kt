package upf.edu.squadfinder.ui.meusGrupsEsdeveniments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.R
import upf.edu.squadfinder.databinding.FragmentEsdevenimentsBinding
import upf.edu.squadfinder.databinding.FragmentMeusGrupsEsdevenimentsBinding
import upf.edu.squadfinder.ui.esdeveniments.EsdevenimentsRecyclerViewAdapter

class MeusGEFragment : Fragment() {

    private lateinit var meusGEViewModel: MeusGEViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<EsdevenimentsRecyclerViewAdapter.ViewHolder>? = null

    private var _binding: FragmentMeusGrupsEsdevenimentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMeusGrupsEsdevenimentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewMeusEsdeveniments.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MeusGERecyclerViewAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}