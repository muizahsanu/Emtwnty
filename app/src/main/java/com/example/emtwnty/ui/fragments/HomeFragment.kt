package com.example.emtwnty.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.emtwnty.R

/** -Tanggal Pengerjaan:
*   - 7 Mei 2020
 *   - 8 mei 2020
*   Nama : Muiz Ahsanu Haqi
*   Kelas: IF-5
*   NIM  : 10117199
* */

class HomeFragment : Fragment() {

    companion object{
        fun getInstance() : HomeFragment =
            HomeFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
