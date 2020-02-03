package com.example.myapplicationid.user_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplicationid.R
import com.example.myapplicationid.repository.entity.ResultItem
import com.example.myapplicationid.repository.entity.UserResponse
import kotlinx.android.synthetic.main.fragment_second.*

class UserProfileFragment: Fragment() {

lateinit var  mViewModel: UserProfileViewModel

    companion object {

        const val KEY = "KEY"

        fun newInstance(id: Int): UserProfileFragment{
            val fragment = UserProfileFragment()
            val bundle = Bundle ()
            bundle.putInt(KEY,id)
            fragment.arguments = bundle

            return fragment
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second,container,false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(KEY)

        mViewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        mViewModel.userLiveData.observe(viewLifecycleOwner, userProfileObserver)
        mViewModel.getUser(id)


}

    fun showProfile(data: ResultItem?) {
        if (data != null) {
            user_first_name.text = data.firstName.toString()
            user_last_name.text = data.lastName.toString()
          user_item_id.text = data.id.toString()
            user_address.text = data.address.toString()
           user_gender.text = data.gender.toString()
            user_phone_number.text = data.phone.toString()
            user_dob.text = data.dob.toString()
            user_email.text = data.email.toString()
            user_status.text = data.status.toString()

        }
    }

    private val userProfileObserver = Observer <UserResponse> {
        it.result.let {
            result ->
            if (result != null) {
                showProfile(result)
            }
        }
    }
}