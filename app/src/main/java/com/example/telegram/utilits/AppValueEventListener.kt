package com.example.telegram.utilits

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

/* Модификация класса ValueEventListener */

class AppValueEventListener (val onSuccess:(DataSnapshot) -> Unit) :ValueEventListener{
    override fun onCancelled(p0: DatabaseError) {

    }

    override fun onDataChange(p0: DataSnapshot) {
        onSuccess(p0)
    }

}