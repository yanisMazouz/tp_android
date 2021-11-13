package fr.ccm.m1.android.tp_android.dog.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for room */
@Entity(tableName = "Dog_info")
data class DogRoom(
    @ColumnInfo(name = "phrase")
    val phrase: String,


    @ColumnInfo(name = "icon_url")
    val iconUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

data class DogUi(
    val phrase: String,
    val iconUrl: String
)

/** Object use for retrofit */
data class DogRetrofit(
    @Expose
    @SerializedName("fact")
    val phrase: String,


    @Expose
    @SerializedName("image")
    val iconUrl: String
)



