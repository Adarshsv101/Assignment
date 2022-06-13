package com.adarshsv.assignment


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
 lateinit var recyclerView: RecyclerView
 lateinit var recyclerViewAdapter: MyAdapter
 lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.ItemRecyclerView)



        initRecyclerView()
        initViewModel()

    }
    private fun initRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = MyAdapter()
            adapter = recyclerViewAdapter



        }
    }
    fun initViewModel(){
        viewModel= ViewModelProvider(this).get(MainActivityViewModel :: class.java)
        viewModel.getUserListObserverable().observe(this, Observer<UserList>{
            if(it == null){
                Toast.makeText(this@MainActivity,"no result found ...",Toast.LENGTH_LONG).show()
            }else{
                recyclerViewAdapter.userList =it.data.toMutableList()
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getUsersList()
}   }