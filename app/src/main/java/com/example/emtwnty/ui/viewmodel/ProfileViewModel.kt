package com.example.emtwnty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.persistence.ProfileEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/** -Tanggal Pengerjaan:
 *  - 14 mei 2020
 *  - 15 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class ProfileViewModel: ViewModel() {
    private var db: EmDatabase? = null
    private var disposable = CompositeDisposable()

    var mProfileData = MutableLiveData<List<ProfileEntity>>()

    fun instanceDatabase(db: EmDatabase){
        this.db = db
    }

    fun setDataProfile(profile: List<ProfileEntity>){
        disposable.add(Observable.fromCallable { db?.profileDao()?.insertProfile(profile) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    fun getDataProfile(){
        disposable.add(Observable.fromCallable { db?.profileDao()?.getDataProfile() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                mProfileData.postValue(it)
            })
    }
}