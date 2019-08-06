package sg.edu.rp.c347.mycalculatorv2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var msg = ""
    var operator = ""
    var num = 0.0
    var total = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button20.setOnClickListener {
            var numb = textView.text.toString()
            if (numb.isNotEmpty()){
                var sum = numb.toDouble()/100
                textView.text = "$sum"
            }
        }

        button1.setOnClickListener {
            msg = ""
            operator = ""
            num = 0.0
            total = 0.0
            textView.text = "0"
        }
    }

    fun btnOperator(view: View){
        val btnSelected = view as Button
        when(btnSelected.id) {
            button2.id -> operator = "/"
            button6.id -> operator = "*"
            button10.id -> operator = "-"
            button14.id -> operator = "+"
        }
        msg = ""
        num = textView.text.toString().toDouble()
    }

    fun btnCalculate(view: View){
        var num1 = textView.text.toString().toDouble()
        if(num != 0.0) {
            if (operator.equals("+")) {
                total = num + num1
            } else if (operator.equals("-")) {
                total = num - num1
            } else if (operator.equals("*")) {
                total = num * num1
            } else if (operator.equals("/")) {
                total = num / num1
            }
            msg = "$total"
            num = total
            total = 0.0
            operator = ""
        }else{
            operator = ""
            total = 0.0
            num = num1
            msg = "$num1"
        }
        textView.text = msg
    }

    fun btnOnClick(view: View){
        val btnSelected = view as Button
        when(btnSelected.id) {
            button3.id -> msg += "7"
            button4.id -> msg += "8"
            button5.id -> msg += "9"
            button7.id -> msg += "4"
            button8.id -> msg += "5"
            button9.id -> msg += "6"
            button11.id -> msg += "1"
            button12.id -> msg += "2"
            button13.id -> msg += "3"
            button15.id -> msg += "0"
            button16.id -> msg += "."
        }
        textView.text = msg
    }
}
