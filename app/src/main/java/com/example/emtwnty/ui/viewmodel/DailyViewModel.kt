package com.example.emtwnty.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.persistence.FriendsList
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DailyViewModel:ViewModel() {
    protected val disposable = CompositeDisposable()
    private var db: EmDatabase? = null

    var friendsList = MutableLiveData<List<FriendsList>>()

    fun setInstanceOfDb(db: EmDatabase){
        this.db = db
    }

    fun setDataFriendsList(friendsList: List<FriendsList>){
        Observable.fromCallable {db?.friendsListDao()?.setDataFriendsList(friendsList)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{

            }).let {
                disposable.add(it)
            }
    }

    fun getAllDataFriendsList(){
        Observable.fromCallable{ db?.friendsListDao()?.getAllDataFriendsList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                friendsList.postValue(it)
            },{

            }).let {
                disposable.add(it)
            }
    }
}