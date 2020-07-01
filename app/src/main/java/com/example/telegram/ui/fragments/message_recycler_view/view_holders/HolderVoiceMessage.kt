package com.example.telegram.ui.fragments.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram.database.CURRENT_UID
import com.example.telegram.ui.fragments.message_recycler_view.views.MessageView
import com.example.telegram.utilits.asTime
import kotlinx.android.synthetic.main.message_item_image.view.*
import kotlinx.android.synthetic.main.message_item_voice.view.*

class HolderVoiceMessage(view: View):RecyclerView.ViewHolder(view) {
    val blocReceivedVoiceMessage: ConstraintLayout = view.bloc_received_voice_message
    val blocUserVoiceMessage: ConstraintLayout = view.bloc_user_voice_message
    val chatUserVoiceMessageTime: TextView = view.chat_user_voice_message_time
    val chatReceivedVoiceMessageTime: TextView = view.chat_received_voice_message_time


    val chatReceivedBtnPlay:ImageView = view.chat_received_btn_play
    val chatReceivedBtnStop:ImageView = view.chat_received_btn_stop

    val chatUserBtnPlay:ImageView = view.chat_user_btn_play
    val chatUserBtnStop:ImageView = view.chat_user_btn_stop


    fun drawMessageVoice(holder: HolderVoiceMessage, view:MessageView) {
        if (view.from == CURRENT_UID) {
            holder.blocReceivedVoiceMessage.visibility = View.GONE
            holder.blocUserVoiceMessage.visibility = View.VISIBLE
            holder.chatUserVoiceMessageTime.text =
                view.timeStamp.asTime()
        } else {
            holder.blocReceivedVoiceMessage.visibility = View.VISIBLE
            holder.blocUserVoiceMessage.visibility = View.GONE
            holder.chatReceivedVoiceMessageTime.text =
                view.timeStamp.asTime()
        }
    }

}