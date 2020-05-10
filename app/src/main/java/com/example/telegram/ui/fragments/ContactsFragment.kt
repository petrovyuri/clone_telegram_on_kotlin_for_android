package com.example.telegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.telegram.R
import com.example.telegram.utilits.APP_ACTIVITY


class ContactsFragment : BaseFragment(R.layout.fragment_contacts) {
    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Контакты"
    }
}
