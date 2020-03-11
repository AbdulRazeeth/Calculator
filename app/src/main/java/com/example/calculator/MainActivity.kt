package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var txtCal:TextView;

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         txtCal=findViewById<TextView>(R.id.textView2)
        findViewById<Button>(R.id.button0).setOnClickListener {
            txtCal.setText(txtCal.text.toString()+"0")
            reduceTextSize()
        }
        findViewById<Button>(R.id.button1).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"1"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"2"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button3).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"3"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button4).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"4"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button5).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"5"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button6).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"6"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button7).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"7"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button8).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"8"
            reduceTextSize()
        }
        findViewById<Button>(R.id.button9).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"9"
            reduceTextSize()
        }
        findViewById<Button>(R.id.buttonDiv).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"/"
            reduceTextSize()
        }
        findViewById<Button>(R.id.buttonMul).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"*"
            reduceTextSize()
        }
        findViewById<Button>(R.id.buttonPlus).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"+"
            reduceTextSize()
        }
        findViewById<Button>(R.id.buttonSub).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"-"
            reduceTextSize()
        }
        findViewById<Button>(R.id.buttonDot).setOnClickListener{
            txtCal.text=txtCal.text.toString()+"."
            reduceTextSize()

       }

    }
    fun reduceTextSize()
    {
        if(txtCal.text.length>7)
        {
            //how to give arugument
            txtCal.setTextSize();
        }

    }
}
