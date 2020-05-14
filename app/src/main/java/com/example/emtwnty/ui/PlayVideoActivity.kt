package com.example.emtwnty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.emtwnty.R
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment

/** -Tanggal Pengerjaan:
 *  - 14 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class PlayVideoActivity : AppCompatActivity() {

    private var API_KEY = "AIzaSyDzRZ6dX901wwD8rs1ezFvdmKa4K0WQork"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)

        val mVideoId = getExtraString()

        val mYtPlayerFragment = fragmentManager.findFragmentById(R.id.ytPlayerFragment) as YouTubePlayerFragment
        mYtPlayerFragment.initialize(API_KEY,ytOnInitListener(mVideoId))

    }
    private fun getExtraString(): String{
        val mGetExtra = intent.extras
        val idYtFromExtra: String
        if(mGetExtra == null){
            idYtFromExtra = null.toString()
        }else idYtFromExtra = mGetExtra.getString("ID_YT").toString()
        return idYtFromExtra
    }
    private fun ytOnInitListener(mVideoId:String):YouTubePlayer.OnInitializedListener{
        val mOnInitListener = object: YouTubePlayer.OnInitializedListener{
            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {

            }

            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.cueVideo(mVideoId)
            }
        }
        return mOnInitListener
    }
}
