package com.example.emtwnty.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.emtwnty.R
import com.example.emtwnty.persistence.DataDummy.SetDataDummy
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.ui.viewmodel.ProfileViewModel

/** -Tanggal Pengerjaan:
 *  - 15 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */
class ProfileFragment : Fragment() {

    companion object{
        fun getInstance(): ProfileFragment = ProfileFragment()
    }

    private var profileViewModel: ProfileViewModel? = null
    private lateinit var db: EmDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        db = EmDatabase.getInstance(context)
        profileViewModel?.instanceDatabase(db)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun setData(){
        val data = SetDataDummy.profileDataSet()
        profileViewModel?.setDataProfile(data)
    }
    fun getData(){
        profileViewModel?.getDataProfile()
        profileViewModel?.mProfileData?.observe(this, Observer {

        })
    }

}
