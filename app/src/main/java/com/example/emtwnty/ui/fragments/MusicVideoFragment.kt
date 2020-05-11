package com.example.emtwnty.ui.fragments

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emtwnty.Adapter.MusicVideoAdapter
import com.example.emtwnty.R
import com.example.emtwnty.persistence.DataDummy.SetDataDummy
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.persistence.onMusicVideoFragmet.MusicVideoEntity
import com.example.emtwnty.ui.viewmodel.MusicVideoViewModel
import kotlinx.android.synthetic.main.fragment_music_video.*


/** -Tanggal Pengerjaan:
 *  - 11 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class MusicVideoFragment : Fragment(), MusicVideoAdapter.onClickItemListener{

    private var viewModel: MusicVideoViewModel? = null
    private lateinit var db: EmDatabase
    private lateinit var mMusicAdapter: MusicVideoAdapter
    private var size: Point= Point()
    private lateinit var display: Display

    companion object{
        fun getInstance(): MusicVideoFragment = MusicVideoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_music_video, container, false)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this).get(MusicVideoViewModel::class.java)
        db = EmDatabase.getInstance(context)
        viewModel?.setInstanceDatabase(db)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wv_showVideo_musicVideo.apply {
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.javaScriptEnabled = true
            settings.pluginState = WebSettings.PluginState.ON
            settings.defaultFontSize = 18
        }

        setData()
        getData()
    }

    fun muatVideo(videoUri: String){
        val mWidth = Resources.getSystem().displayMetrics.widthPixels / 3
        val mHeight = mWidth / 1.5
        val kodeHtml = "<iframe width=\""+mWidth+"\" height=\""+mHeight+"\" src=\"https://www.youtube.com/embed/" + videoUri +
                "\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"
        wv_showVideo_musicVideo.loadData(kodeHtml,"text/html; charset=utf-8",null)
    }

    fun setData(){
        val data = SetDataDummy.musicVideoDataSet()
        viewModel?.setDataToDatabase(data)
    }
    fun getData(){
        viewModel?.getDataFromDatabase()
        viewModel?.mMusicVideo?.observe(this, Observer {
            mMusicAdapter = MusicVideoAdapter()
            mMusicAdapter.MusicVideoAdapter(it!!,this)
            rv_musicFav_musicVideo.apply{
                layoutManager = LinearLayoutManager(context)
                this.adapter = mMusicAdapter
            }
        })
    }

    override fun onItemClick(musicVideo: MusicVideoEntity, position: Int) {
        val videoId = "EgBJmlPo8Xw"
        muatVideo(videoId)
    }

    override fun onItemClickTengah(musicVideo: MusicVideoEntity, position: Int) {

    }

}
