package fr.ccm.m1.android.tp_android.dog.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.ccm.m1.android.tp_android.databinding.ActivityDogBinding
import fr.ccm.m1.android.tp_android.dog.model.DogUi
import fr.ccm.m1.android.tp_android.dog.viewModel.DogViewModel

class DogActivty : AppCompatActivity() {

    private lateinit var viewModel: DogViewModel
    private lateinit var binding : ActivityDogBinding
    private val adapter : DogAdapter = DogAdapter()
    private val observer = Observer<List<DogUi>> {
        adapter.submitList(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[DogViewModel::class.java]


        binding.dogActivityRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.dogActivityRecyclerView.adapter = adapter


        binding.dogAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }


        binding.dogActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }
    override fun onStart() {
        super.onStart()
        viewModel.dogLiveData.observe(this, observer)
    }


    override fun onStop() {
        viewModel.dogLiveData.removeObserver(observer)
        super.onStop()
    }

}