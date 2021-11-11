package fr.ccm.m1.android.tp_android.myFeature.model

import androidx.room.Entity
import androidx.room.PrimaryKey


sealed class UtilisateurForRecyclerView()


data class UtilisateurHeader(
    val header: String
) : UtilisateurForRecyclerView()

data class Utilisateur (
    val nom : String,
    val prenom : String,
    val age : Int,
    val email : String,
    val iconColor : Int
    ) : UtilisateurForRecyclerView()

@Entity(tableName = "Utilisateur")
data class LocalUtilisateur (
    val nom : String,
    val prenom : String,
    val age : Int,
    val email : String,
    val iconColor : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
