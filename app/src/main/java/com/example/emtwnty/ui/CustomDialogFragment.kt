package com.example.emtwnty.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

import com.example.emtwnty.R
import com.example.emtwnty.ui.fragments.ProfileFragment

/** -Tanggal Pengerjaan:
 *  - 16 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */
class CustomDialogFragment : DialogFragment() {

    companion object{
        const val HaloBangsat = "CostumDialog"
    }

    private lateinit var mInput: EditText
    private lateinit var mActionCencel: TextView
    private lateinit var mActionOk: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_custom_dialog, container, false)

        mActionCencel.setOnClickListener {
            dialog?.dismiss()
        }

        mActionOk.setOnClickListener {
            val input = mInput.text.toString()
        }

        return view


    }

}
