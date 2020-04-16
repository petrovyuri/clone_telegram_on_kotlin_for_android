package com.example.telegram.utilits

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.telegram.R

fun showToast(message:String){
    Toast.makeText(APP_ACTIVITY,message,Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, addStack:Boolean = true){
    if (addStack){
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.dataContainer,
                fragment
            ).commit()
    } else {
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,
                fragment
            ).commit()
    }

}

fun Fragment.replaceFragment(fragment: Fragment){
    this.fragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(R.id.dataContainer,
            fragment
        )?.commit()
}