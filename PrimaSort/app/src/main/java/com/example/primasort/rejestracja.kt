package com.example.primasort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.internal.FallbackServiceBroker
import kotlinx.android.synthetic.main.activity_rejestracja.*


class rejestracja : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rejestracja)
        Reditlogin(Rlogin, Rwarnlogin)
        Reditpassword(Rhaslo,Rwarnpassword)
        Rrepeatpassword(Rpowthaslo, Rwarn2pass, Rhaslo)
        ReditEmail(Remail, Rwarnemail)

    }

    fun sumbitData(view: View) {
        if (!Rakceptujer.isChecked)
            Toast.makeText(applicationContext, "prosze potwierdzic regulamin", Toast.LENGTH_LONG)
                .show()
    }
}

fun Reditlogin(Rlogin: EditText, Rwarnlogin: TextView)
{

    Rlogin.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(Rlogin.length() == 0)
            {Rwarnlogin.visibility = TextView.INVISIBLE}
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Rwarnlogin.visibility = TextView.INVISIBLE
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(Rlogin.length() < 6)
            {Rwarnlogin.setText("login jest za krótki")
            Rwarnlogin.visibility = TextView.VISIBLE}

            else if(Rlogin.length() > 15)
            {Rwarnlogin.setText("Login za długi")
            Rwarnlogin.visibility = TextView.VISIBLE}

            else{Rwarnlogin.visibility = TextView.INVISIBLE }


        }
    })
}

fun Reditpassword(Rhaslo: EditText, Rwarnpassword: TextView)
{
    Rhaslo.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(Rhaslo.length() == 0)
            {Rwarnpassword.visibility = TextView.INVISIBLE}
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Rwarnpassword.visibility = TextView.INVISIBLE
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(Rhaslo.length() < 8)
            {Rwarnpassword.setText("Hasło jest za krótkie")
                Rwarnpassword.visibility = TextView.VISIBLE}

            else if(Rhaslo.length() > 20)
            {Rwarnpassword.setText("Hasło jest za długie")
                Rwarnpassword.visibility = TextView.VISIBLE}

            else{Rwarnpassword.visibility = TextView.INVISIBLE}

        }
    })
}
fun Rrepeatpassword(Rpowthaslo: EditText, Rwarn2pass: TextView, Rhaslo: TextView)
{
    Rpowthaslo.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(Rpowthaslo.length() == 0)
            {Rwarn2pass.visibility = TextView.INVISIBLE}
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Rwarn2pass.visibility = TextView.INVISIBLE
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            Rwarn2pass.setText("Hasła nie są takie same")
            Rwarn2pass.visibility = TextView.VISIBLE
            if (Rpowthaslo.text.toString().equals(Rhaslo.text.toString()))
            {Rwarn2pass.setText("Hasła są takie same")}
        }
    })
}

fun ReditEmail(Remail: TextView, Rwarnemail: TextView){
    Remail.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            Rwarnemail.setText("Wpisz poprawny e-mail")
            Rwarnemail.visibility = TextView.VISIBLE
            if(Remail.length() == 0)
            {Rwarnemail.visibility = TextView.INVISIBLE}
            for (i in Remail.text){
                if( i.toString() == "@"){
                    for (e in Remail.text){
                        if (e.toString() == "."){
                            Rwarnemail.setText("e-mail ok")
                            Rwarnemail.visibility = TextView.VISIBLE

                        }
                    }

                } else if ( i.toString() == "."){
                    for (e in Remail.text){
                        if (e.toString() == "@"){
                            Rwarnemail.setText("e-mail ok")
                            Rwarnemail.visibility = TextView.VISIBLE
                        }
                    }
                }


            }
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Rwarnemail.visibility = TextView.INVISIBLE
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}