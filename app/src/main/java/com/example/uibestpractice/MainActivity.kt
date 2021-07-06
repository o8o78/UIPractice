package com.example.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val msgList = ArrayList<Msg>()

    private var adapter : MsgAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerview.adapter = adapter
        button_send.setOnClickListener{
            val content = inputText.text.toString()
            if(content.isNotEmpty()){
                val msg = Msg(content,Msg.TYPE_SENT)
                msgList.add(msg)
                adapter?.notifyItemInserted(msgList.size-1)
                recyclerview.scrollToPosition(msgList.size-1)
                inputText.setText("")
            }
        }
    }

    private fun init(){
        val msg1 = Msg("hi there", Msg.TYPE_RECEIVED)
        val msg2 = Msg("greetings", Msg.TYPE_SENT)
        val msg3 = Msg("rising uppercut", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        msgList.add(msg2)
        msgList.add(msg3)
    }

}