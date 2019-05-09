package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isPlayingNowLoaded = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Playing =findViewById<Button>(R.id.Btn_play)
        val TopRate =findViewById<Button>(R.id.Btn_rate)
        openPlayingNow()
        Playing.setOnClickListener {
            if(isPlayingNowLoaded==false)
                openPlayingNow()
        }
        TopRate.setOnClickListener {
            if(isPlayingNowLoaded)
                openTopRate() }
    }
     fun openPlayingNow(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        //fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.replace(R.id.fragment_holder, Now_playing())
        fragmentTransaction.addToBackStack("1")
        fragmentTransaction.commit()
         isPlayingNowLoaded=true
    }
    fun openTopRate(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        //fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.replace(R.id.fragment_holder, Top_rate())
        fragmentTransaction.addToBackStack("1")
        fragmentTransaction.commit()
        isPlayingNowLoaded=false
    }
}
