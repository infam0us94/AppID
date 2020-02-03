package com.example.myapplicationid.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationid.MainActivity
import com.example.myapplicationid.R
import com.example.myapplicationid.repository.entity.ResultItem
import com.example.myapplicationid.repository.entity.UserListResponse
import kotlinx.android.synthetic.main.fragment_fist.*

class UserListFragment : Fragment(), ResultItemAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = UserListFragment()
    }
    lateinit var mViewModel: UserListViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        mViewModel.getUserList()
        mViewModel.userListLiveData.observe(viewLifecycleOwner, userListObserver)

    }

    private fun showData(list: List<ResultItem>?) {
        //показать в RecyclerView
        if (list != null) {
            val adapter = ResultItemAdapter(this)
            adapter.list = list
            recyclerView.adapter = adapter
            recyclerView.layoutManager =
                LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        }
    }

    private val userListObserver = Observer<UserListResponse> { result ->
        showData(result.result)
    }

    override fun onItemClick(item: ResultItem) {
        (activity as MainActivity).showProfile(item.id!!)
    }
}



