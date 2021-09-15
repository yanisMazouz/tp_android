package fr.ccm.m1.android.tp_android.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.ccm.m1.android.tp_android.adapter.UtilisateurAdapter
import fr.ccm.m1.android.tp_android.databinding.ActivityRecyclerViewBinding
import fr.ccm.m1.android.tp_android.model.Utilisateur
import fr.ccm.m1.android.tp_android.model.UtilisateurForRecyclerView
import fr.ccm.m1.android.tp_android.model.UtilisateurHeader

class ActivityRecyclerView : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: UtilisateurAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the instance of adapter
        adapter = UtilisateurAdapter { item, view ->
            onItemClick(item, view)
        }

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter


        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())
    }


    private fun generateFakeData(): MutableList<UtilisateurForRecyclerView> {
        val result = mutableListOf<UtilisateurForRecyclerView>()

       mutableListOf(
            Utilisateur("nom1", "prenom1",21,"email1@gmail.com",Color.rgb(255,0,0)),
            Utilisateur("nom2", "prenom2",22,"email2@gmail.com",Color.rgb(255,255,0)),
            Utilisateur("nom3", "prenom3",23,"email3@gmail.com",Color.rgb(255,0,255)),
            Utilisateur("nom4", "prenom4",24,"email4@gmail.com",Color.rgb(0,255,255)),
            Utilisateur("nom5", "prenom5",25,"email5@gmail.com",Color.rgb(0,255,0)),
            Utilisateur("nom6", "prenom6",26,"email6@gmail.com",Color.rgb(0,0,255)),
            Utilisateur("nom7", "prenom7",27,"email7@gmail.com",Color.rgb(120,15,200)),
            Utilisateur("nom8", "prenom8",28,"email8@gmail.com",Color.rgb(210,175,56)),
            Utilisateur("nom9", "prenom9",29,"email9@gmail.com",Color.rgb(13,250,120)),
            Utilisateur("nom10", "prenom10",30,"email10@gmail.com",Color.rgb(152,152,152)),
            Utilisateur("nom11", "prenom11",31,"email11@gmail.com",Color.rgb(238,241,14))
        ).groupBy {
            utilisateur -> utilisateur.age > 25
       }.forEach{(plusVingtCinqAns, utilisateurs) ->
           if(plusVingtCinqAns){
               result.add(UtilisateurHeader(" > 25 ans"))
               result.addAll(utilisateurs)
           }else{
               result.add(UtilisateurHeader(" <= 25 ans"))
               result.addAll(utilisateurs)
           }
       }
        return result
    }
    private fun onItemClick(utilisateur: Utilisateur, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this,"Bonjour " + utilisateur.prenom, Toast.LENGTH_LONG).show()
    }


}