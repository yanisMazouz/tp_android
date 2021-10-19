package fr.ccm.m1.android.tp_android.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.ccm.m1.android.tp_android.adapter.UtilisateurAdapter
import fr.ccm.m1.android.tp_android.databinding.ActivityRecyclerViewBinding
import fr.ccm.m1.android.tp_android.model.Utilisateur
import fr.ccm.m1.android.tp_android.model.UtilisateurForRecyclerView
import fr.ccm.m1.android.tp_android.viewModel.UtilisateurViewModel
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class ActivityRecyclerView : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: UtilisateurAdapter
    private lateinit var viewModel: UtilisateurViewModel
    private val utilisateurListObserver = Observer<List<UtilisateurForRecyclerView>> {
        adapter.submitList(it)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[UtilisateurViewModel::class.java]


        // Create the instance of adapter
        adapter = UtilisateurAdapter { item, view ->
            onItemClick(item, view)
        }

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.buttonAddItem.setOnClickListener { addUtilisateur() }
        binding.buttonDeleteAllItem?.setOnClickListener { deleteUtilisateurs() }
        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter


    }


    private fun onItemClick(utilisateur: Utilisateur, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this,"Bonjour " + utilisateur.prenom, Toast.LENGTH_LONG).show()
    }

    private fun addUtilisateur() {
        val random = Random.nextInt(0, 255)
        viewModel.insertUtilisateur("Nom$random" , "Prenom$random", "email$random@gmail.com", random % 40 + 10, Color.rgb(Random.nextInt(0, 255),Random.nextInt(0, 255),Random.nextInt(0, 255)))
    }


    private fun deleteUtilisateurs() {
        viewModel.deleteAllUtilisateur()
    }


    override fun onStart() {
        super.onStart()
        viewModel.utilisateurList.observe(this, utilisateurListObserver)
    }


    override fun onStop() {
        super.onStop()
        viewModel.utilisateurList.observe(this, utilisateurListObserver)
    }



}