package fr.ccm.m1.android.tp_android.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.ccm.m1.android.tp_android.model.LocalUtilisateur
import fr.ccm.m1.android.tp_android.model.Utilisateur

@Dao
interface UtilisateurDao {


    @Query("SELECT * FROM utilisateur ORDER BY nom ASC")
    fun selectAll(): LiveData<List<LocalUtilisateur>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(localUtilisateur: LocalUtilisateur)


    @Query("DELETE FROM utilisateur")
    fun deleteAll()
}
