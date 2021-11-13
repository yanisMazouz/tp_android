package fr.ccm.m1.android.tp_android.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.ccm.m1.android.tp_android.chuckNorris.dao.ChuckNorrisDao
import fr.ccm.m1.android.tp_android.chuckNorris.model.ChuckNorrisRoom
import fr.ccm.m1.android.tp_android.dog.dao.DogDao
import fr.ccm.m1.android.tp_android.dog.model.DogRoom
import fr.ccm.m1.android.tp_android.myFeature.dao.UtilisateurDao
import fr.ccm.m1.android.tp_android.myFeature.model.LocalUtilisateur

@Database(
    entities = [
        LocalUtilisateur::class,
        ChuckNorrisRoom::class,
        DogRoom::class

    ],
    version = 3,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun utilisateurDao() : UtilisateurDao
    abstract fun chuckNorrisDao() : ChuckNorrisDao
    abstract fun dogDao() : DogDao
}
