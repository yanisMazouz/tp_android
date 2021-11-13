package fr.ccm.m1.android.tp_android.dog.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.ccm.m1.android.tp_android.dog.model.DogRoom

@Dao
interface DogDao {
    @Query("SELECT * FROM Dog_info")
    fun selectAll() : LiveData<List<DogRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dogRoom: DogRoom)


    @Query("DELETE FROM Dog_info")
    fun deleteAll()

}