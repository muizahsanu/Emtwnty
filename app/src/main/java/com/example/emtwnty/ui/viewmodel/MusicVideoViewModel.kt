package com.example.emtwnty.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.persistence.onMusicVideoFragmet.MusicVideoEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/** -Tanggal Pengerjaan:
 *  - 11 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class MusicVideoViewModel: ViewModel() {

    protected val disposable = CompositeDisposable()
    private var db: EmDatabase? = null
    val mMusicVideo = MutableLiveData<List<MusicVideoEntity>>()

    fun setInstanceDatabase(db: EmDatabase){
        this.db = db
    }

    fun setDataToDatabase(musicVideoEntity: List<MusicVideoEntity>){
        disposable.add(Observable.fromCallable { db?.musicVideoDao()?.insertMusivFav(musicVideoEntity)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    fun getDataFromDatabase(){
        disposable.add(Observable.fromCallable { db?.musicVideoDao()?.getAllDataMusicVideo()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                mMusicVideo.postValue(it!!)
                it.forEach{
                    Log.e("Title=",it.judulMusic)
                }
            })
    }
}