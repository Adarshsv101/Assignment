package com.adarshsv.assignment

import android.renderscript.Sampler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var recyclerListData: MutableLiveData<UserList>
    init{
        recyclerListData=MutableLiveData()
    }
    fun getUserListObserverable():MutableLiveData<UserList>{
        return recyclerListData
    }
    fun getUsersList(){
        val retroInstance=RetroInstance.getRetroInstance().create(ApiInterface:: class.java)
        val call = retroInstance.getUsersList()
        call.enqueue(object: Callback<UserList> {
            //Retrofit will download and parse the API data on a background thread,
            // then deliver the results back to the UI thread via the onResponse or onFailure method.

            override fun onFailure(call: Call<UserList>, t:Throwable){
                recyclerListData.postValue(null)
            }
            override fun onResponse(call: Call<UserList>,response: Response<UserList>){
                if(response.isSuccessful){
                    recyclerListData.postValue(response.body())
                }
            }
        })
    }

}



