package com.example.task_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.task_1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var bind: ActivityMain2Binding
    private var dat: Data = Data("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this,R.layout.activity_main2)

        bind.butAct2.setOnClickListener{
            Log.i("TestingApp","Activity 2 Button Clicked")
            moveBack()
        }
    }

    private fun moveBack(){
        if(bind.editData.text.equals("")){

        }else {
            dat.name = bind.editData.text.toString()
            dat.seen = true
            Log.i("TestingApp", "${dat.name} ++ ${dat.seen}")
        }

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Name","${dat.name}")
        intent.putExtra("Seen","${dat.seen}")
        startActivity(intent)

    }


}