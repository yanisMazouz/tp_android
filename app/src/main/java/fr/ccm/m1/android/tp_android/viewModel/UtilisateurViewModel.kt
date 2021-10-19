package fr.ccm.m1.android.tp_android.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import fr.ccm.m1.android.tp_android.model.Utilisateur
import fr.ccm.m1.android.tp_android.model.UtilisateurForRecyclerView
import fr.ccm.m1.android.tp_android.model.UtilisateurHeader
import fr.ccm.m1.android.tp_android.repository.UtilisateurRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UtilisateurViewModel : ViewModel() {
    private val utilisateurRepository: UtilisateurRepository by lazy { UtilisateurRepository() }

    val utilisateurList: LiveData<List<UtilisateurForRecyclerView>> = utilisateurRepository.selectAllUtilisateur().map { list ->
        list.toUtilisateurForRecyclerView()
    }




    fun insertUtilisateur(nom: String, prenom: String, email: String, age: Int, iconColor: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            utilisateurRepository.insertUtilisateur(
                Utilisateur(nom, prenom, age, email, iconColor )
            )
        }
    }


    fun deleteAllUtilisateur() {
        viewModelScope.launch(Dispatchers.IO) {
            utilisateurRepository.deleteAllUtilisateur()
        }
    }

    private fun List<Utilisateur>.toUtilisateurForRecyclerView(): List<UtilisateurForRecyclerView> {
        val result = mutableListOf<UtilisateurForRecyclerView>()
        groupBy {
            // Split in 2 list, modulo and not
            it.age > 25
        }.forEach { (isGtThan25, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            if (isGtThan25) result.add(UtilisateurHeader("> 25" ))
            else result.add(UtilisateurHeader("<= 25" ))
            result.addAll(items)
        }
        return result
    }




}