package upf.edu.squadfinder.ui.esdeveniments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.R
import upf.edu.squadfinder.databinding.ActivityMainBinding
import upf.edu.squadfinder.databinding.FragmentEsdevenimentsBinding
import upf.edu.squadfinder.ui.meusGrupsEsdeveniments.RecyclerViewAdapter
//import kotlinx.android.synthetic.main.fragment_esdeveniments.*

class EsdevenimentsFragment : Fragment() {

    private lateinit var esdevenimentsViewModel: EsdevenimentsViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    private var _binding: FragmentEsdevenimentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEsdevenimentsBinding.inflate(inflater, container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_esdeveniments, container, false)

        /*esdevenimentsViewModel =
                ViewModelProvider(this).get(EsdevenimentsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_esdeveniments, container, false)
        val textView: TextView = root.findViewById(R.id.card_view_esdeveniment)
        esdevenimentsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewEsdeveniments.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerViewAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}