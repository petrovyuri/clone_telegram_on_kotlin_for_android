package com.example.telegram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.telegram.activities.RegisterActivity
import com.example.telegram.databinding.ActivityMainBinding
import com.example.telegram.ui.fragments.ChatsFragment
import com.example.telegram.ui.objects.AppDrawer
import com.example.telegram.utilits.AUTH
import com.example.telegram.utilits.initFirebase
import com.example.telegram.utilits.replaceActivity
import com.example.telegram.utilits.replaceFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        initFirebase()
    }
}
