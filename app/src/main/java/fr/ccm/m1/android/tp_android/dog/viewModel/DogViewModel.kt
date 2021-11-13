package fr.ccm.m1.android.tp_android.dog.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import fr.ccm.m1.android.tp_android.dog.model.DogRoom
import fr.ccm.m1.android.tp_android.dog.model.DogUi
import fr.ccm.m1.android.tp_android.dog.repository.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val dogRepository: DogRepository by lazy { DogRepository() }
    var dogLiveData: LiveData<List<DogUi>> =
        dogRepository.selectAllDog().map {
            it.toUi()
        }


    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            dogRepository.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            dogRepository.deleteAllDog()
        }
    }
}


private fun List<DogRoom>.toUi(): List<DogUi> {
    return asSequence().map {
        DogUi(
            phrase = it.phrase,
            iconUrl = it.iconUrl
        )
    }.toList()

}