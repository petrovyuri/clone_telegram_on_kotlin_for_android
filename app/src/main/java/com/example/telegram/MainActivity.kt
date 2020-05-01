package com.example.telegram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegram.activities.RegisterActivity
import com.example.telegram.databinding.ActivityMainBinding
import com.example.telegram.ui.fragments.ChatsFragment
import com.example.telegram.ui.objects.AppDrawer
import com.example.telegram.utilits.*


/*
* Курс по созданию мессенджера для Android
* Автор Петров Юрий
*/
/* Главная активность*/

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar
    private var test = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        /* Функция запускается один раз, при создании активити */
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initFirebase()
        initUser {
            initFields()
            initFunc()
        }

    }

    private fun initFunc() {
        /* Функция инициализирует функциональность приложения */
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields() {
        /* Функция инициализирует переменные */
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
    }

    override fun onStart() {
        super.onStart()
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun onStop() {
        super.onStop()
        AppStates.updateState(AppStates.OFFLINE)
    }
}
