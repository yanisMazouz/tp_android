package fr.ccm.m1.android.tp_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.ccm.m1.android.tp_android.databinding.ItemCustomRecyclerBinding
import fr.ccm.m1.android.tp_android.databinding.ItemCustomRecyclerHeaderBinding
import fr.ccm.m1.android.tp_android.model.Utilisateur
import fr.ccm.m1.android.tp_android.model.UtilisateurForRecyclerView
import fr.ccm.m1.android.tp_android.model.UtilisateurHeader


class UtilisateurAdapter(
    private val onItemClick: (quoteUi: Utilisateur, view: View) -> Unit,
) : ListAdapter<UtilisateurForRecyclerView, RecyclerView.ViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                UtilisateurViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onItemClick
                )
            }

            MyItemType.HEADER.type -> {
                UtilisateurHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Wrong view type received $viewType")
        }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as UtilisateurViewHolder).bind(getItem(position) as Utilisateur)


            MyItemType.HEADER.type -> (holder as UtilisateurHeaderViewHolder).bind(getItem(position) as UtilisateurHeader)


            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }




    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Utilisateur -> MyItemType.ROW.type
            is UtilisateurHeader -> MyItemType.HEADER.type
        }

    }


}


private val diffItemUtils = object : DiffUtil.ItemCallback<UtilisateurForRecyclerView>() {


    override fun areItemsTheSame(oldItem: UtilisateurForRecyclerView, newItem: UtilisateurForRecyclerView): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: UtilisateurForRecyclerView, newItem: UtilisateurForRecyclerView): Boolean {
        return oldItem == newItem
    }
}

class UtilisateurViewHolder(
    private val binding: ItemCustomRecyclerBinding,
    onItemClick: (utilisateur : Utilisateur, view: View) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: Utilisateur


    init {
        binding.root.setOnClickListener {
            onItemClick(ui, itemView)
        }
    }

    fun bind(utilisateur: Utilisateur) {
        ui = utilisateur
        binding.nom.text = utilisateur.nom + " " + utilisateur.prenom
        binding.age.text = "${utilisateur.age} ans"
        binding.email.text = utilisateur.email
        binding.imageView.setBackgroundColor(utilisateur.iconColor)
    }
}

class UtilisateurHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(utilisateurHeader: UtilisateurHeader) {
        binding.itemRecyclerViewHeader.text = utilisateurHeader.header
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1)
}





