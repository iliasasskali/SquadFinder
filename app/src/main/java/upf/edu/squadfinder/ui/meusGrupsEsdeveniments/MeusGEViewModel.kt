package upf.edu.squadfinder.ui.meusGrupsEsdeveniments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeusGEViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Meus Grups i Esdeveniments Fragment"
    }
    val text: LiveData<String> = _text
}