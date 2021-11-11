package fr.ccm.m1.android.tp_android.chuckNorris.repository

import androidx.lifecycle.LiveData
import fr.ccm.m1.android.tp_android.architecture.CustomApplication
import fr.ccm.m1.android.tp_android.architecture.RetrofitBuilder
import fr.ccm.m1.android.tp_android.chuckNorris.model.ChuckNorrisRetrofit
import fr.ccm.m1.android.tp_android.chuckNorris.model.ChuckNorrisRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisQuoteRepository {
    private val mChuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()

    fun selectAllChuckNorrisQuote(): LiveData<List<ChuckNorrisRoom>> {
        return mChuckNorrisDao.selectAll()
    }


    private suspend fun insertChuckNorrisQuote(chuckNorrisQuote: ChuckNorrisRoom) =
        withContext(Dispatchers.IO) {
            mChuckNorrisDao.insert(chuckNorrisQuote)
        }


    suspend fun deleteAllChuckNorrisQuote() = withContext(Dispatchers.IO) {
        mChuckNorrisDao.deleteAll()
    }


    suspend fun fetchData() {
        insertChuckNorrisQuote(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }

}
private fun ChuckNorrisRetrofit.toRoom(): ChuckNorrisRoom {
    return ChuckNorrisRoom(
        quote = quote,
        iconUrl = iconUrl
    )
}
