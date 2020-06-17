package com.example.primasort

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Gskanbutt.setOnClickListener{
            //odpanienie kodu kreskowego
            val scanner = IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
            scanner.setBeepEnabled(false)

            scanner.initiateScan()
        }

        Glogbutt.setOnClickListener{

                //nowa aktywność odpalająca logowanie
                var Aktlogowanie: Intent = Intent(applicationContext, logowanie::class.java)
                startActivity(Aktlogowanie)
        }

        Gzasadysegregacji.setOnClickListener{
            val Aktzasadysegregacji = Intent(applicationContext, ZasadySegregacji::class.java)
            startActivity(Aktzasadysegregacji)
        }

        Grejbutt.setOnClickListener {
            //nowa aktywność odpalająca rejestracje
            var Aktrejestracja: Intent = Intent(applicationContext, rejestracja::class.java)
            startActivity(Aktrejestracja)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode ==Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if(result != null) {
                if(result.contents == null){
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                } else{
                    //nowa aktywność odpalająca okono w którym jest info do jakiego pojemnika wrzucic odpad
                    var Aktzeskanowanykod: Intent = Intent(applicationContext, Odcztraniekodu::class.java)
                    startActivity(Aktzeskanowanykod)




//                    Toast.makeText(this, "Scanned" + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}
