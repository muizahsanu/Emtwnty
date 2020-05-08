package com.example.emtwnty.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emtwnty.Adapter.ClassAdapter
import com.example.emtwnty.persistence.DataDummy.FriendsListSetData

import com.example.emtwnty.R
import com.example.emtwnty.persistence.EmDatabase
import com.example.emtwnty.persistence.FriendsList
import com.example.emtwnty.ui.viewmodel.DailyViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_daily.*
import kotlinx.android.synthetic.main.fragment_daily.view.*

/** -Tanggal Pengerjaan:
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class DailyFragment : Fragment() {

    private var viewModel: DailyViewModel? = null
    private lateinit var classAdapter: ClassAdapter
    private lateinit var db: EmDatabase
    private var friendsList: List<FriendsList> = ArrayList()

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

    override fun onStart() {
        super.onStart()
        viewModel?.getAllDataFriendsList()
        initRecyclerView()
        observeViewModel()
    }

    private fun initRecyclerView(){
        rv_friendlist_daily.apply {
            layoutManager = LinearLayoutManager(context)
            classAdapter = ClassAdapter()
        }
    }
    private fun observeViewModel(){
        viewModel?.friendsList?.observe(this, Observer {
            handleData(it)
        })
    }
    private fun handleData(data: List<FriendsList>){
        classAdapter.friendListAdapter(data)
        rv_friendlist_daily.adapter = classAdapter
    }

}
