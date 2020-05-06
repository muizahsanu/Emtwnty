package com.example.emtwnty.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emtwnty.Adapter.ClassAdapter
import com.example.emtwnty.Model.FriendsList
import com.example.emtwnty.Model.FriendsListSetData

import com.example.emtwnty.R
import kotlinx.android.synthetic.main.fragment_daily.*

/**
 * A simple [Fragment] subclass.
 */
class DailyFragment : Fragment() {

    private lateinit var classAdapter: ClassAdapter

    companion object{
        fun getInstance() : DailyFragment = DailyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setDataFriendsList()
    }

    fun setDataFriendsList(){
        val data = FriendsListSetData.createDataSet()
        classAdapter.friendListAdapter(data)
    }

    private fun initRecyclerView(){
        rv_friendlist_daily.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            classAdapter = ClassAdapter()
            rv_friendlist_daily.adapter = classAdapter
        }
    }

}
