package fr.ccm.m1.android.tp_android.dog.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.ccm.m1.android.tp_android.chuckNorris.model.ChuckNorrisUi
import fr.ccm.m1.android.tp_android.databinding.ItemDogBinding
import fr.ccm.m1.android.tp_android.dog.model.DogUi

val diffUtils = object : DiffUtil.ItemCallback<DogUi>() {
    override fun areItemsTheSame(oldItem: DogUi, newItem: DogUi): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: DogUi, newItem: DogUi): Boolean {
        return oldItem == newItem
    }


}

class DogViewHolder(
    val binding: ItemDogBinding
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var ui: DogUi


    fun bind(dogUi: DogUi) {
        ui = dogUi
        Glide.with(itemView.context)
            .load(dogUi.iconUrl)
            .into(binding.itemDogIcon)


        binding.itemDogPhrase.text = dogUi.phrase
    }
}

class DogAdapter : ListAdapter<DogUi, DogViewHolder>(diffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(
            ItemDogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


