package com.melihakkose.kotlinsayac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number=0
    var runnable: Runnable= Runnable {  }
    var handler:Handler= Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Abstract - Inheritance

        SAYAC OLUSTURMA
        object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                //ISLEM BITINCE
                textView.text="Left: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                //HER SANIYEDE NE OLACAK
                textView.text="Left: 0"
            }

        }.start()

        Layout kısmına textView eklenerek yapılabilir.
         */


    }

    fun start (view: View){

        /*
        Kullanicinin arayuzunu kitlememek ve programi cokertmemek icin runnable ve handler kullanmamiz gerek
        while(number<100){
            number=number+1
            textView.text="Time: $number"
            Thread.sleep(1000)
        }

         */

        number=0
        //Runnable Object olarak olusturulup kod parantezleri arasina gerekli kodlari yaziyoruz
        runnable = object :Runnable{
            override fun run() {

                number=number+1
                textView.text="Time: $number"

                //GECIKMELI OLARAK BASLAT
                handler.postDelayed(this,1000)
            }

        }
        handler.post(runnable)



    }
    fun stop (view:View){

        handler.removeCallbacks(runnable)
        number=0
        textView.text="Time: $number"

    }
}