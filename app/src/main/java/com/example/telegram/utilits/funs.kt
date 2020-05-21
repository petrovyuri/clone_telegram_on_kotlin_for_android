package com.example.telegram.utilits

import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.telegram.R
import com.squareup.picasso.Picasso

/* Файл для хранения утилитарных функции, доступных во всем приложении */

fun showToast(message:String){
    /* Функция показывает сообщение */
    Toast.makeText(APP_ACTIVITY,message,Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){
    /* Функция расширения для AppCompatActivity, позволяет запускать активити */
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, addStack:Boolean = true){
    /* Функция расширения для AppCompatActivity, позволяет устанавливать фрагменты */
    if (addStack){
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.data_container,
                fragment
            ).commit()
    } else {
        supportFragmentManager.beginTransaction()
            .replace(R.id.data_container,
                fragment
            ).commit()
    }

}

fun Fragment.replaceFragment(fragment: Fragment){
    /* Функция расширения для Fragment, позволяет устанавливать фрагменты */
    this.fragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(R.id.data_container,
            fragment
        )?.commit()
}

fun hideKeyboard() {
    /* Функция скрывает клавиатуру */
    val imm: InputMethodManager = APP_ACTIVITY.getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    imm.hideSoftInputFromWindow(APP_ACTIVITY.window.decorView.windowToken, 0)
}

fun ImageView.downloadAndSetImage(url:String){
    /* Функция раширения ImageView, скачивает и устанавливает картинку*/
    Picasso.get()
        .load(url)
        .fit()
        .placeholder(R.drawable.default_photo)
        .into(this)
}