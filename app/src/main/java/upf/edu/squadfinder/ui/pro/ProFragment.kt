package upf.edu.squadfinder.ui.pro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import upf.edu.squadfinder.R

class ProFragment : Fragment() {

    private lateinit var proViewModel: ProViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        proViewModel =
                ViewModelProvider(this).get(ProViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pro, container, false)
        val textView: TextView = root.findViewById(R.id.text_pro)
        proViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}