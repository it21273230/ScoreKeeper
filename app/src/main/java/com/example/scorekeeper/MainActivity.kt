package com.example.scorekeeper

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {

    var mScore1 = 0
    var mScore2 = 0
    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView

    val STATE_SCORE_1 = "Team 1 Score"
    val STATE_SCORE_2 = "Team 2 Score"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the TextViews by ID.
        mScoreText1 = findViewById<TextView>(R.id.score_1);
        mScoreText2 = findViewById<TextView>(R.id.score_2);
    }


    fun decreaseScore(view: View) {
        when(view.id){
            R.id.decreaseTeam1 -> {
                mScore1--;
                mScoreText1.text= mScore1.toString()
            }
            R.id.decreaseTeam2 ->{
                mScore2--;
                mScoreText2.text= mScore2.toString()
            }
        }

    }
    fun increaseScore(view: View) {
        when(view.id){
            R.id.increaseTeam1 ->{
                mScore1++;
                mScoreText1.text= mScore1.toString()
            }
            R.id.increaseTeam2 -> {
                mScore2++;
                mScoreText2.text= mScore2.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu);



        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{

        if(item.itemId == R.id.night_mode){
            var nightMode = AppCompatDelegate.getDefaultNightMode();

            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }

}