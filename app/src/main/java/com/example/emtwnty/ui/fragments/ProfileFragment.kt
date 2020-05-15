package com.example.emtwnty.ui.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.emtwnty.R
import com.example.emtwnty.persistence.DataDummy.SetDataDummy
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.ui.CustomDialogFragment
import com.example.emtwnty.ui.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

/** -Tanggal Pengerjaan:
 *  - 15 Mei 2020
 *  - 16 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */
class ProfileFragment : Fragment(){

    companion object{
        fun getInstance(): ProfileFragment = ProfileFragment()
    }

    private var profileViewModel: ProfileViewModel? = null
    private lateinit var db: EmDatabase
    private lateinit var instagram: String
    private lateinit var notel: String
    private lateinit var email: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        db = EmDatabase.getInstance(context)
        profileViewModel?.instanceDatabase(db)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        getData()

        btn_instagram_profile.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/"+instagram)
            val linking = Intent(Intent.ACTION_VIEW, uri)

            Toast.makeText(context,"Harap tunggu..",Toast.LENGTH_SHORT).show()

            linking.setPackage("com.instagram.android")
            startActivity(linking)
        }
        btn_maps_profile.setOnClickListener{
            val uri = Uri.parse("https://goo.gl/maps/RnBHbiWSmVSw26A98")
            val linking = Intent(Intent.ACTION_VIEW, uri)

            Toast.makeText(context,"Harap tunggu..",Toast.LENGTH_SHORT).show()

            linking.setPackage("com.google.android.apps.maps")
            startActivity(linking)
        }
        ib_email_profile.setOnClickListener {
            val linking = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",email,null))
            startActivity(linking)
        }
        ib_call_profile.setOnClickListener {
            val linking = Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",notel,null))
            startActivity(linking)
        }
    }

    fun setData(){
        val data = SetDataDummy.profileDataSet()
        profileViewModel?.setDataProfile(data)
    }
    fun getData(){
        profileViewModel?.getDataProfile()
        profileViewModel?.mProfileData?.observe(this, Observer {
            it!!.forEach {
                tv_nama_profile.text = it.nama
                tv_phone_profile.text = it.phoneNumber
                tv_desc_profile.text = it.descDiri
                tv_email_profile.text = it.email
                tv_instagram_profile.text = it.instagram
                instagram = it.instagram
                notel = it.phoneNumber
                email = it.email
            }
        })
    }
}
