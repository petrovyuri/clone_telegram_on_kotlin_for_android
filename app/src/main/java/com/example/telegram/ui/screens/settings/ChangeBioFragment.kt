package com.example.telegram.ui.screens.settings

import com.example.telegram.R
import com.example.telegram.database.*
import com.example.telegram.ui.screens.base.BaseChangeFragment
import kotlinx.android.synthetic.main.fragment_cnage_bio.*

/* Фрагмент для изменения информации о пользователе */

class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_cnage_bio) {

    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        setBioToDatabase(newBio)
    }
}
