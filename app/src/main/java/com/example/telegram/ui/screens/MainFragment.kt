package com.example.telegram.ui.screens

import androidx.fragment.app.Fragment
import com.example.telegram.R
import com.example.telegram.utilits.APP_ACTIVITY
import com.example.telegram.utilits.hideKeyboard

/* Главный фрагмент, содержит все чаты, группы и каналы с которыми взаимодействует пользователь*/

class MainFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Telegram"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
    }
}
