package com.example.telegram.utilits

import com.example.telegram.database.*

enum class AppStates(val state:String) {
   /* Класс перечисление состояний приложения*/

    ONLINE("в сети"),
    OFFLINE("был недавно"),
    TYPING("печатает");

    companion object{
        fun updateState(appStates: AppStates){
            /*Функция принимает состояние и записывает в базу данных*/
            if (AUTH.currentUser!=null){
                REF_DATABASE_ROOT.child(
                    NODE_USERS
                ).child(CURRENT_UID).child(
                    CHILD_STATE
                )
                    .setValue(appStates.state)
                    .addOnSuccessListener { USER.state = appStates.state }
                    .addOnFailureListener { showToast(it.message.toString()) }
            }
        }
    }
}