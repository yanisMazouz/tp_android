package fr.ccm.m1.android.tp_android.model


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