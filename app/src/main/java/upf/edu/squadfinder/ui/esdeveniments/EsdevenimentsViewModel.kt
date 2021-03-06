package upf.edu.squadfinder.ui.esdeveniments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EsdevenimentsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Esdeveniments Fragment"
    }
    val text: LiveData<String> = _text
}