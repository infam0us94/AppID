package com.example.myapplicationid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationid.repository.entity.ResultItem
import com.example.myapplicationid.user_list.UserListFragment
import java.util.*

class MainActivity : AppCompatActivity(){

//    private val myAdapter = ResultItemAdapter()
private var mExampleList: ArrayList<ResultItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,UserListFragment())
            .commit()

    }

//    override fun onItemClick(position: Int) {
//        val detailIntent = Intent(this, UserProfileFragment::class.java)
//        val clickedItem = mExampleList!![position]
//        detailIntent.putExtra(WEBSITE,clickedItem.website)
//        detailIntent.putExtra(ADDRESS,clickedItem.address)
//        detailIntent.putExtra(GENDER,clickedItem.gender)
//        detailIntent.putExtra(PHONE,clickedItem.phone)
//        detailIntent.putExtra(DOB,clickedItem.dob)
//        detailIntent.putExtra(LAST_NAME,clickedItem.lastName)
//        detailIntent.putExtra(ID,clickedItem.id)
//        detailIntent.putExtra(FIRST_NAME,clickedItem.firstName)
//        detailIntent.putExtra(EMAIL,clickedItem.email)
//        detailIntent.putExtra(STATUS,clickedItem.status)
//    }
//        companion object {
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
//    }

}
