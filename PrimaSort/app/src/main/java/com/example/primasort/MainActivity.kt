package com.example.primasort

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glogbutt.setOnClickListener{

            //nowa aktywność odpalająca logowanie
            var Aktlogowanie: Intent = Intent(applicationContext, logowanie::class.java)
            startActivity(Aktlogowanie)



        }

        Grejbutt.setOnClickListener {
            //nowa aktywność odpalająca rejestracje
            var Aktrejestracja: Intent = Intent(applicationContext, rejestracja::class.java)
            startActivity(Aktrejestracja)
        }
    }
}
