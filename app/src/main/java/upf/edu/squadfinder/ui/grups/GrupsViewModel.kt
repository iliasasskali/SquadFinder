package upf.edu.squadfinder.ui.grups

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GrupsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Grups Fragment"
    }
    val text: LiveData<String> = _text
}