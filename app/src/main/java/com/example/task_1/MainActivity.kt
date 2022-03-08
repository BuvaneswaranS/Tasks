package com.example.task_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.task_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    var dat: Data = Data("Jeff",false)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.i("TestingApp","onCreate Called")
        bind = DataBindingUtil.setContentView(this,R.layout.activity_main)

        bind.butAct1.setOnClickListener{
            moveToActivity()
        }

    }

    val actvityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult>() {result ->
            Log.i("TestingApp","Entered Activity Launcher")
            if (result.resultCode == 78){
                val intent: Intent? = result.data
                Log.i("TestingApp","resultCode is correct")
                Log.i("TestingApp","resultCode is ${result.resultCode}")
                if (result.data != null){
                    val res: String? = intent?.getStringExtra("name")
                    if(res != null){
                        dat.name = res.toString()
                        Log.i("TestingApp","${res.toString()}")
                        Log.i("TestingApp","${dat.name}")
                        bind.textAct1.visibility = View.VISIBLE
                        bind.textAct1.text = dat.name
                    }else{
                        Log.i("TestingApp","${res}")
                    }
                }else{
                    Log.i("TestingApp","result.data is a null")
                }
            }

        }

    )


    private fun moveToActivity(){
        val intent = Intent(this , MainActivity2::class.java)
        actvityLauncher.launch(intent)
    }

}
