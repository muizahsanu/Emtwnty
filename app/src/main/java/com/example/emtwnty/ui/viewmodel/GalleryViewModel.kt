package com.example.emtwnty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.persistence.GalleryEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/** -Tanggal Pengerjaan:
 *  - 10 mei 2020
 *  - 14 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class GalleryViewModel:ViewModel() {
    protected val disposable = CompositeDisposable()
    private var db: EmDatabase? = null

    val galleryModel = MutableLiveData<List<GalleryEntity>>()

    fun getInstanceDatabase(db: EmDatabase){
        this.db = db
    }

    fun setDataGalleryToDb(galleryEntity: List<GalleryEntity>){
        disposable.add(Observable.fromCallable { db?.galleryDao()?.insertGallery(galleryEntity) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    fun getDataGalleryToDb(){
        disposable.add(Observable.fromCallable { db?.galleryDao()?.getAllGallery()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                galleryModel.postValue(it)
            })
    }

}