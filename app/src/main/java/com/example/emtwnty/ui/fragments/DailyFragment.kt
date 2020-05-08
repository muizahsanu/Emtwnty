package com.example.emtwnty.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emtwnty.Adapter.ClassAdapter

import com.example.emtwnty.R
import com.example.emtwnty.persistence.DataDummy.FriendsListSetData
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.ui.viewmodel.DailyViewModel
import kotlinx.android.synthetic.main.fragment_daily.*

/** -Tanggal Pengerjaan:
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class DailyFragment : Fragment() {

    private var viewModel: DailyViewModel? = null
    private lateinit var classAdapter: ClassAdapter
    private lateinit var db: EmDatabase

    companion object{
        fun getInstance() : DailyFragment =
            DailyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel = ViewModelProviders.of(this).get(DailyViewModel::class.java)
        db = EmDatabase.getInstance(context)
        viewModel?.setInstanceOfDb(db)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataFriendsList()
        getDataDaily()
    }

    /** FUNGSI **/
    private fun getDataFriendsList(){
        viewModel?.getAllDataFriendsList()
        viewModel?.friendsList?.observe(this, Observer {
            rv_friendlist_daily.apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                classAdapter = ClassAdapter()
                classAdapter.friendListAdapter(it)
                this.adapter = classAdapter
            }
        })
    }
    private fun getDataDaily() {
        viewModel?.getAllDataDaily()
        viewModel?.daily?.observe(this, Observer {
            rv_daily_daily.apply {
                layoutManager = LinearLayoutManager(context)
                classAdapter = ClassAdapter()
                classAdapter.dailyAdapter(it)
                this.adapter = classAdapter
            }
        })
    }

    private fun setDataToDatabase(){
        val dataDummyFriends = FriendsListSetData.createDataSet()
        viewModel?.setDataFriendsList(dataDummyFriends)

        val dataDummyDaily = FriendsListSetData.dailyDataSet()
        viewModel?.setDataDaily(dataDummyDaily)
    }

}
