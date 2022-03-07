package com.example.task_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.task_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private var data: Data = Data()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val intent = getIntent()
        var name = intent.getStringExtra("Name")
        var seen = intent.getStringExtra("Seen")

        data.name = name.toString()
        bind.textAct1.text = data.name


        if(seen == "true"){
            data.seen = true
        }

        if(data.seen == true){
            bind.textAct1.visibility = View.VISIBLE
        }


        bind.butAct1.setOnClickListener{
            moveToActivity()
        }

    }

    private fun moveToActivity(){
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }

}
