package fr.ccm.m1.android.tp_android.dog.repository

import androidx.lifecycle.LiveData
import fr.ccm.m1.android.tp_android.architecture.CustomApplication
import fr.ccm.m1.android.tp_android.architecture.RetrofitBuilder
import fr.ccm.m1.android.tp_android.dog.model.DogRetrofit
import fr.ccm.m1.android.tp_android.dog.model.DogRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    private val dogDao = CustomApplication.instance.mApplicationDatabase.dogDao()

    fun selectAllDog(): LiveData<List<DogRoom>> {
        return dogDao.selectAll()
    }


    private suspend fun insertDog(dogRoom: DogRoom) =
        withContext(Dispatchers.IO) {
            dogDao.insert(dogRoom)
        }


    suspend fun deleteAllDog() = withContext(Dispatchers.IO) {
        dogDao.deleteAll()
    }


    suspend fun fetchData() {
        insertDog(RetrofitBuilder.getDogPhrase().getRandomPhrase().toRoom())
    }
    private fun DogRetrofit.toRoom(): DogRoom {
        return DogRoom(
            phrase = phrase,
            iconUrl = iconUrl
        )
    }

}
