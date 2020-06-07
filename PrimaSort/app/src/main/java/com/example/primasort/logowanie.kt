package com.example.primasort

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_logowanie.*

class logowanie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logowanie)

        Lzarejestrujsie.setOnClickListener {

            //nowa aktywność odpalająca logowanie
            var AktRejestracja: Intent = Intent(applicationContext, rejestracja::class.java)
            startActivity(AktRejestracja)
        }

    }
}
