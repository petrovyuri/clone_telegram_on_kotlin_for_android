package com.example.telegram.models

/* Общая модель для всех сущностей приложения*/

data class CommonModel(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var state: String = "",
    var phone: String = "",
    var photoUrl: String = "empty",

    var text: String = "",
    var type: String = "",
    var from: String = "",
    var timeStamp: Any = ""




) {
    override fun equals(other: Any?): Boolean {
        return (other as CommonModel).id == id
    }
}