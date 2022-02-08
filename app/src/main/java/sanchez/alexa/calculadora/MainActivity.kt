package sanchez.alexa.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operacion: Int =0
    var num1:Double=0.0
    lateinit var tvnum1: TextView
    lateinit var tvnum2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvnum1= findViewById(R.id.tvNum1)
        tvnum2=findViewById(R.id.tvNum2)
    }
    fun precionarDigito(view: View){

        var num2: String=tvnum2.text.toString()

        when(view.id){
            R.id.btn0 -> tvnum2.setText(num2+"0")
            R.id.btn1 -> tvnum2.setText(num2+"1")
            R.id.btn2 -> tvnum2.setText(num2+"2")
            R.id.btn3 -> tvnum2.setText(num2+"3")
            R.id.btn4 -> tvnum2.setText(num2+"4")
            R.id.btn5 -> tvnum2.setText(num2+"5")
            R.id.btn6 -> tvnum2.setText(num2+"6")
            R.id.btn7 -> tvnum2.setText(num2+"7")
            R.id.btn8 -> tvnum2.setText(num2+"8")
            R.id.btn9 -> tvnum2.setText(num2+"9")
            R.id.btnpunto -> {
                if (tvnum2.text.contains(".")){
                tvnum2.setText(num2+"")
                }
                else
                    tvnum2.setText(num2+".")
            }
        }



    }
    fun clicOperacion(view: View){
        num1 = tvnum2.text.toString().toDouble()
        var txtnum2:String=tvnum2.text.toString()
        tvnum2.setText("")
        when(view.id){
            R.id.btnSuma ->{
                tvnum1.setText(txtnum2 + "+")
                   operacion=1
            }
            R.id.btnResta->{
                tvnum1.setText(txtnum2 + "-")
                operacion=2
            }
            R.id.btnMulti->{
                tvnum1.setText(txtnum2 + "x")
                operacion=3
            }
            R.id.btnDiv->{
                tvnum1.setText(txtnum2 + "/")
                operacion=4
            }
        }



    }
    fun resultado(view: View){
        var num2: Double= tvnum2.text.toString().toDouble()
        var resp: Double=0.0
        when(operacion){
            1-> resp=num1+num2
            2-> resp=num1-num2
            3-> resp=num1*num2
            4-> resp=num1/num2
        }
        tvnum2.setText(resp.toString())
        tvnum1.setText("")
    }

    fun borrar(view: View){
        tvnum2.setText("")
        tvnum1.setText("")
    }
}