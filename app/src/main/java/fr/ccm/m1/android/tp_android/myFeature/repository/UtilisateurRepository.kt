package fr.ccm.m1.android.tp_android.myFeature.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import fr.ccm.m1.android.tp_android.architecture.CustomApplication
import fr.ccm.m1.android.tp_android.myFeature.model.LocalUtilisateur
import fr.ccm.m1.android.tp_android.myFeature.model.Utilisateur


class UtilisateurRepository {

    private fun Utilisateur.toLocalUtilisateur(): LocalUtilisateur {
        return LocalUtilisateur(
            nom = nom,
            prenom = prenom,
            age = age,
            email = email,
            iconColor = iconColor
        )
    }


    private fun List<LocalUtilisateur>.toUtilisateur(): List<Utilisateur> {
        return map { eachItem ->
            Utilisateur(
                nom = eachItem.nom,
                prenom = eachItem.prenom,
                age = eachItem.age,
                email = eachItem.email,
                iconColor = eachItem.iconColor
            )
        }
    }


    private val utilisateurDao =
        CustomApplication.instance.mApplicationDatabase.utilisateurDao()


    fun selectAllUtilisateur(): LiveData<List<Utilisateur>> {
        return utilisateurDao.selectAll().map { list ->
            list.toUtilisateur()
        }
    }

    fun insertUtilisateur(utilisateur: Utilisateur){
        utilisateurDao.insert(utilisateur.toLocalUtilisateur())
    }



    fun deleteAllUtilisateur() {
        utilisateurDao.deleteAll()
    }


//    fun generateFakeData(): MutableList<UtilisateurForRecyclerView> {
//        val result = mutableListOf<UtilisateurForRecyclerView>()
//
//        mutableListOf(
//            Utilisateur("nom1", "prenom1",21,"email1@gmail.com", Color.rgb(255,0,0)),
//            Utilisateur("nom2", "prenom2",22,"email2@gmail.com", Color.rgb(255,255,0)),
//            Utilisateur("nom3", "prenom3",23,"email3@gmail.com", Color.rgb(255,0,255)),
//            Utilisateur("nom4", "prenom4",24,"email4@gmail.com", Color.rgb(0,255,255)),
//            Utilisateur("nom5", "prenom5",25,"email5@gmail.com", Color.rgb(0,255,0)),
//            Utilisateur("nom6", "prenom6",26,"email6@gmail.com", Color.rgb(0,0,255)),
//            Utilisateur("nom7", "prenom7",27,"email7@gmail.com", Color.rgb(120,15,200)),
//            Utilisateur("nom8", "prenom8",28,"email8@gmail.com", Color.rgb(210,175,56)),
//            Utilisateur("nom9", "prenom9",29,"email9@gmail.com", Color.rgb(13,250,120)),
//            Utilisateur("nom10", "prenom10",30,"email10@gmail.com", Color.rgb(152,152,152)),
//            Utilisateur("nom11", "prenom11",31,"email11@gmail.com", Color.rgb(238,241,14))
//        ).groupBy {
//                utilisateur -> utilisateur.age > 25
//        }.forEach{(plusVingtCinqAns, utilisateurs) ->
//            if(plusVingtCinqAns){
//                result.add(UtilisateurHeader(" > 25 ans"))
//                result.addAll(utilisateurs)
//            }else{
//                result.add(UtilisateurHeader(" <= 25 ans"))
//                result.addAll(utilisateurs)
//            }
//        }
//        return result
//    }
}