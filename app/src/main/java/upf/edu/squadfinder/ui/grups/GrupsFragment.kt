package upf.edu.squadfinder.ui.grups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import upf.edu.squadfinder.R

class GrupsFragment : Fragment() {

    private lateinit var grupsViewModel: GrupsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        grupsViewModel =
                ViewModelProvider(this).get(GrupsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_grups, container, false)
        val textView: TextView = root.findViewById(R.id.text_pro)
        grupsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}