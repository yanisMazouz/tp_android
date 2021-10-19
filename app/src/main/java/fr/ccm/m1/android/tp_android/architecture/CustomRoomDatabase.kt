package fr.ccm.m1.android.tp_android.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.ccm.m1.android.tp_android.dao.UtilisateurDao
import fr.ccm.m1.android.tp_android.model.LocalUtilisateur

@Database(
    entities = [
        LocalUtilisateur::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun utilisateurDao() : UtilisateurDao
}
