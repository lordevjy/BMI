package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image.setImageResource(R.drawable.empty)
        txtWeight.requestFocus()

        btnCalculate.setOnClickListener(){
            try {
                //if (txtHeight.text.isEmpty() && txtWeight.text.isEmpty()){
                //txtBMI.setText("Enter Weight and Height!")
            //}else {
                calBMI()
            }
            catch (e:Exception){
                val toast: Toast = Toast.makeText(this, Html.fromHtml("<font color='#FF0000'>Invalid Input.</font>"), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }

        btnReset.setOnClickListener(){
            image.setImageResource(R.drawable.empty)
            txtBMI.text = ""
            txtHeight.setText("")
            txtWeight.setText("")
        }
    }

    private fun calBMI(){
        val weight:Double = txtWeight.text.toString().toDouble()
        val height:Double = txtHeight.text.toString().toDouble()

        val BMI:Double = (weight) / (height * height)

        if (BMI < 18.5) {
            txtBMI.text = "BMI: %.2f (UNDERWEIGHT)".format(BMI)
            image.setImageResource(R.drawable.under)
        }else if (BMI >= 18.5 && BMI <= 24.9){
            txtBMI.text = "BMI: %.2f (NORMAL)".format(BMI)
            image.setImageResource(R.drawable.normal)
        }else{
            txtBMI.text = "BMI: %.2f (OVERWEIGHT)".format(BMI)
            image.setImageResource(R.drawable.over)
        }
    }
}
