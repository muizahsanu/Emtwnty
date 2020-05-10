package com.example.emtwnty.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.emtwnty.Adapter.GalleryAdapter

import com.example.emtwnty.R
import com.example.emtwnty.persistence.DataDummy.SetDataDummy
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.ui.viewmodel.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*

/** -Tanggal Pengerjaan:
 *  - 9 mei 2020
 *  - 10 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */
class GalleryFragment : Fragment() {

    companion object{
        fun getInstance(): GalleryFragment = GalleryFragment()
    }

    private var viewModel: GalleryViewModel? = null
    private lateinit var galleryAdapter: GalleryAdapter
    private lateinit var db: EmDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel = ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        db = EmDatabase.getInstance(context)
        viewModel?.getInstanceDatabase(db)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        getData()
    }

    /** FUNCTION **/
    fun setData(){
        val dataDummy = SetDataDummy.galleryDataSet()
        viewModel?.setDataGalleryToDb(dataDummy)
    }
    fun getData(){
        viewModel?.getDataGalleryToDb()
        viewModel?.galleryModel?.observe(this, Observer {
            rv_image_gallery.apply{
                layoutManager = GridLayoutManager(context,2)
                galleryAdapter = GalleryAdapter()
                galleryAdapter.galleryAdapter(it)
                this.adapter = galleryAdapter
            }
        })
    }

}
