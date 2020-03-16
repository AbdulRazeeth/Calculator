package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import java.lang.Character.isDigit
import java.lang.Double.parseDouble
import java.lang.Exception
import java.lang.Integer.parseInt
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var txtCal: TextView;

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
            txtCal = findViewById<TextView>(R.id.textView2)
            findViewById<Button>(R.id.button0).setOnClickListener {
                txtCal.setText(txtCal.text.toString() + "0")
                reduceTextSize()
            }
            findViewById<Button>(R.id.button1).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "1"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button2).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "2"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button3).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "3"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button4).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "4"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button5).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "5"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button6).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "6"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button7).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "7"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button8).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "8"
                reduceTextSize()
            }
            findViewById<Button>(R.id.button9).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "9"
                reduceTextSize()
            }
            findViewById<Button>(R.id.buttonDiv).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "/"
                reduceTextSize()
            }
            findViewById<Button>(R.id.buttonMul).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "x"
                reduceTextSize()
            }
            findViewById<Button>(R.id.buttonAdd).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "+"
                reduceTextSize()
            }
            findViewById<Button>(R.id.buttonSub).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "-"
                reduceTextSize()
            }
            findViewById<Button>(R.id.buttonClr).setOnClickListener {
                if (txtCal.text.length > 0) {
                    txtCal.text = txtCal.text.subSequence(0, txtCal.text.length - 1)
                }
            }
            findViewById<Button>(R.id.buttonClr).setOnLongClickListener() {
                txtCal.text = ""
                true
            }
            findViewById<Button>(R.id.buttonEqual).setOnClickListener {
                infixToPostfix(txtCal.text.toString())
                reduceTextSize()
                //  evaluate(txtCal.text.toString());
            }
            findViewById<Button>(R.id.buttonOpenpar).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "("
                reduceTextSize()
            }
            findViewById<Button>(R.id.buttonClosepar).setOnClickListener {
                txtCal.text = txtCal.text.toString() + ")"
                reduceTextSize()
            }
            findViewById<Button>(R.id.buttonDot).setOnClickListener {
                txtCal.text = txtCal.text.toString() + "."
                reduceTextSize()
            }
        }
        catch (e:Exception)
        {
            txtCal.text="syntax error";
        }
    }
    // this fun is use to convert in infix to postfix expression
    fun infixToPostfix(exp:String)
    {
        var hashOp=hashMapOf<String,Int>()
        hashOp.put("/",2)
        hashOp.put("x",2)
        hashOp.put("+",1)
        hashOp.put("-",1)
        var stackOperator=Stack<String>()
        var outputArr=ArrayList<String>()
        var numConcat="";
        for(i in 0 until exp.length)
        {
            if(isDigit(exp.get(i))||exp.get(i)=='.')
            {
                numConcat+=exp.get(i).toString()
                continue;
            }
            else{
                if(numConcat!="") { //used when ")+" comes next
                    outputArr.add(numConcat)
                }
                numConcat=""
                if(stackOperator.isEmpty())
                {
                    stackOperator.push(exp.get(i).toString())
                }
                else{
                    if(exp.get(i).toString()=="(")
                    {
                        stackOperator.push(exp.get(i).toString())
                    }
                    else if(exp.get(i).toString()==")")
                    {
                        for(j in 0 until stackOperator.size) {
                            val recentopr=stackOperator.pop()
                            if(recentopr!="(") {
                                outputArr.add(recentopr)
                            }
                            else
                            {
                                break
                            }
                        }
                    }
                    else {
                        for(j in 0 until stackOperator.size) {
                            val recentOpr = stackOperator.pop()
                            if (recentOpr=="("||hashOp.getValue(recentOpr) < hashOp.getValue(exp.get(i).toString())) {
                                stackOperator.push(recentOpr)
                                stackOperator.push(exp.get(i).toString())
                                break
                            }
                            else {
                                outputArr.add(recentOpr)
                                // stackOperator.push(exp.get(i).toString())
                            }
                            if(stackOperator.isEmpty())
                            {
                                stackOperator.push(exp.get(i).toString())
                            }
                        }
                    }
                }
            }
        }
        if(numConcat!="") {
            outputArr.add(numConcat);
        }
        if(!stackOperator.isEmpty())
        {
             for(k in 0 until stackOperator.size) {
                 outputArr.add(stackOperator.pop())
             }
        }
       // txtCal.text=outputArr.toString()
        evaluate(outputArr);
    }

    //Evaluate postfix expression
    //argument expression as string type
    fun evaluate(outputArr:ArrayList<String>) {
        var stack = Stack<Double>();
        for (i in 0 until outputArr.size) {
            val currEle = outputArr.get(i)
            //   val flag1= isDigit("622323") flag1) {
            if (currEle=="+"||currEle=="-"||currEle=="x"||currEle=="/") {
                val op2 = stack.pop()
                val op1 = stack.pop()
                when (currEle) {
                    "+" ->
                        stack.push(op1 + op2)
                    "-" ->
                        stack.push(op1 - op2)
                    "/" ->
                        stack.push(op1 / op2)
                    "x" ->
                        stack.push(op1 * op2)
                }
            }
            else {
                stack.push(parseDouble(currEle))
            }
        }
        txtCal.text=stack.pop().toString()
    }
    // to reduce and increse the size of the txtCal: TextView
    fun reduceTextSize() {
        if (txtCal.text.length > 8){
            txtCal.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45f);
        }
        else{
            txtCal.setTextSize(TypedValue.COMPLEX_UNIT_SP, 90f);
        }

    }
}





