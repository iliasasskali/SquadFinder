package upf.edu.squadfinder.ui.esdeveniments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import upf.edu.squadfinder.R

class EsdevenimentsFragment : Fragment() {

    private lateinit var esdevenimentsViewModel: EsdevenimentsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        esdevenimentsViewModel =
                ViewModelProvider(this).get(EsdevenimentsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_esdeveniments, container, false)
        val textView: TextView = root.findViewById(R.id.text_esdeveniments)
        esdevenimentsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}