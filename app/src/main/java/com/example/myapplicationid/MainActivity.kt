package com.example.myapplicationid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationid.user_list.UserListFragment
import com.example.myapplicationid.user_profile.UserProfileFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, UserListFragment.newInstance())
            .commit()
    }

    fun showProfile(id: Int) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, UserProfileFragment.newInstance(id))
            .addToBackStack(" ")
            .commit()
    }
}
