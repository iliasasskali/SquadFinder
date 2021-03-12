package upf.edu.squadfinder.ui.meusGrupsEsdeveniments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.databinding.FragmentMeusGrupsEsdevenimentsBinding
import upf.edu.squadfinder.ui.esdeveniments.EsdevenimentsRecyclerViewAdapter
import upf.edu.squadfinder.ui.grups.GrupsRecyclerViewAdapter

class MeusGEFragment : Fragment() {

    private lateinit var meusGEViewModel: MeusGEViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null

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
            binding.recyclerViewMeusEsdeveniments.adapter = MeusEsdevenimentsRecyclerViewAdapter()
        }
        binding.recyclerViewMeusGrups.apply {
            layoutManager = LinearLayoutManager(activity)
            binding.recyclerViewMeusGrups.adapter = MeusGrupsRecyclerViewAdapter()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}