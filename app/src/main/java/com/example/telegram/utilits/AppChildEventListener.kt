package com.example.telegram.utilits

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

/* Модификация класса ValueEventListener */

class AppChildEventListener (val onSuccess:(DataSnapshot) -> Unit) :ChildEventListener{
    override fun onCancelled(p0: DatabaseError) {
        //TODO("Not yet implemented")
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {
        //TODO("Not yet implemented")
    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {
        //TODO("Not yet implemented")
    }

    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        onSuccess(p0)
    }

    override fun onChildRemoved(p0: DataSnapshot) {
        //TODO("Not yet implemented")
    }


}