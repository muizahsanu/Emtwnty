package com.example.emtwnty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emtwnty.persistence.Daily
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.persistence.FriendsList
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/** -Tanggal Pengerjaan:
 *  - 14 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class DailyViewModel:ViewModel() {
    protected val disposable = CompositeDisposable()
    private var db: EmDatabase? = null

    var friendsList = MutableLiveData<List<FriendsList>>()
    var daily = MutableLiveData<List<Daily>>()

    fun setInstanceOfDb(db: EmDatabase){
        this.db = db
    }

    /** BAGIAN FRIENDS LIST **/
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

    /** BAGIAN DAILY ACTIVTY **/
    fun setDataDaily(daily: List<Daily>){
        disposable.add(Observable.fromCallable { db?.dailyDaon()?.setDaily(daily) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    fun getAllDataDaily(){
        disposable.add(Observable.fromCallable { db?.dailyDaon()?.getAllDaily() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                daily.postValue(it!!)
            })
    }
}