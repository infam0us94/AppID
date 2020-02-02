package com.example.myapplicationid.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationid.R
import com.example.myapplicationid.repository.entity.ResultItem
import com.example.myapplicationid.repository.entity.UserListResponse
import kotlinx.android.synthetic.main.fragment_fist.*

class UserListFragment : Fragment(),ResultItemAdapter.OnItemClickListener{

    lateinit var mViewModel: UserListViewModel
    private var mExampleList: ArrayList<ResultItem>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)

        mViewModel.userListLiveData.observe(viewLifecycleOwner, userListObserver)
        mViewModel.getUserList()
    }

    private fun showData(list: ArrayList<ResultItem?>?) {
        //показать в RecyclerView
        if (list != null) {
            val adapter = ResultItemAdapter(ArrayList())
            adapter.list = list as ArrayList<ResultItem>
//            adapter.list = list as List<ResultItem>
            recyclerView.adapter = adapter
            recyclerView.layoutManager =
                LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        }


    }

    private val userListObserver = Observer<UserListResponse> { result ->
        showData(result.result)
    }

    override fun onItemClick(position: Int) {

//
//        var mFragment: Fragment? = null
//        var bundle: Bundle? = null
//        var clickedItem = mExampleList!![position]
//
//        bundle?.putInt(ID,clickedItem.id )



    }

//    companion object {
//        const val WEBSITE = "website"
//        const val ADDRESS = "address"
//        const val GENDER = "gender"
//        const val PHONE = "phone"
//        const val DOB = "dob"
//        const val LAST_NAME = "lastName"
//        const val ID = "id"
//        const val FIRST_NAME = "firstName"
//        const val EMAIL = "email"
//        const val STATUS= "status"
//
//    }


}



