package com.example.emtwnty.ui.fragments

import android.content.Context
import android.content.Intent
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
import com.example.emtwnty.ui.MainActivity
import com.example.emtwnty.ui.PlayVideoActivity
import com.example.emtwnty.ui.viewmodel.MusicVideoViewModel
import kotlinx.android.synthetic.main.fragment_music_video.*


/** -Tanggal Pengerjaan:
 *  - 11 Mei 2020
 *  - 14 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class MusicVideoFragment : Fragment(), MusicVideoAdapter.onClickItemListener{

    private var viewModel: MusicVideoViewModel? = null
    private lateinit var db: EmDatabase
    private lateinit var mMusicAdapter: MusicVideoAdapter

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

        setData()
        getData()
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
        val videoId = musicVideo.videoUri
        val intent = Intent(context,PlayVideoActivity::class.java)
        intent.putExtra("ID_YT",videoId)
        startActivity(intent)
    }

}
