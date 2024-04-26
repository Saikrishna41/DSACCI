package com.dev.ojamee.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dev.ojamee.LoginRegisterActivity
import com.dev.ojamee.R
import com.dev.ojamee.ui.navigations.HomeFragment
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_list_email.*

class MainActivity : AppCompatActivity() {
    private val mOnNavigationBottomItem = BottomNavigationView.OnNavigationItemSelectedListener {

            item ->
        when (item.itemId) {

            R.id.home -> {
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.notifications -> {
                return@OnNavigationItemSelectedListener true

            }
            R.id.settings -> {
                return@OnNavigationItemSelectedListener true

            }

        }
        false
    }

    val TAG = "ListEmailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_email)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationBottomItem)


    }

    override fun onBackPressed() {
        super.onBackPressed()
        logout()
    }

    fun logout() {

        AuthUI.getInstance().signOut(this)
            .addOnCompleteListener(OnCompleteListener {

                if (it.isSuccessful) {

                    startLoginActivity()
                } else {

                    Log.w(TAG, it.exception)
                }
            })
    }

    fun startLoginActivity() {

        val intent = Intent(this, LoginRegisterActivity::class.java)

        startActivity(intent)

        finish()
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentTranscation = supportFragmentManager.beginTransaction()
        fragmentTranscation.replace(R.id.container,fragment)
        fragmentTranscation.commit()


    }
}
