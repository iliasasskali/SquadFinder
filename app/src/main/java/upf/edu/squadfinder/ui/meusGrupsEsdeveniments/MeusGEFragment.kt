package upf.edu.squadfinder.ui.meusGrupsEsdeveniments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import upf.edu.squadfinder.R

class MeusGEFragment : Fragment() {

    private lateinit var meusGEViewModel: MeusGEViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        meusGEViewModel =
                ViewModelProvider(this).get(MeusGEViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_meus_grups_esdeveniments, container, false)
        val textView: TextView = root.findViewById(R.id.text_meusGE)
        meusGEViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}