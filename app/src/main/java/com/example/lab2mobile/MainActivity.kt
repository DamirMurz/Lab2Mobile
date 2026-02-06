package com.example.lab2mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import Artwork
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.Int

class MainActivity : AppCompatActivity() {
    var currInd = 0
    val KEY = "curr_ind"
    val picList = listOf(
        Artwork(
            picId = R.drawable.conjurer,
            picNameId = R.string.pic1Name,
            picAuthorId = R.string.pic1_2Author,
            picDateId = R.string.pic1Date
        ),
        Artwork(
            picId = R.drawable.stone,
            picNameId = R.string.pic2Name,
            picAuthorId = R.string.pic1_2Author,
            picDateId = R.string.pic2Date
        ),
        Artwork(
            picId = R.drawable.proverbs,
            picNameId = R.string.pic3Name,
            picAuthorId = R.string.pic3_4Author,
            picDateId = R.string.pic3Date
        ),
        Artwork(
            picId = R.drawable.triumph_of_death,
            picNameId = R.string.pic4Name,
            picAuthorId = R.string.pic3_4Author,
            picDateId = R.string.pic4Date
        ),
        Artwork(
            picId = R.drawable.librarian,
            picNameId = R.string.pic5Name,
            picAuthorId = R.string.pic5_6_7Author,
            picDateId = R.string.pic5Date
        ),
        Artwork(
            picId = R.drawable.winter,
            picNameId = R.string.pic6Name,
            picAuthorId = R.string.pic5_6_7Author,
            picDateId = R.string.pic6Date
        ),
        Artwork(
            picId = R.drawable.summer,
            picNameId = R.string.pic7Name,
            picAuthorId = R.string.pic5_6_7Author,
            picDateId = R.string.pic7Date
        ),
        Artwork(
            picId = R.drawable.battle,
            picNameId = R.string.pic8Name,
            picAuthorId = R.string.pic8Author,
            picDateId = R.string.pic8Date
        )
    )
    fun update(){
        val currArt = picList[currInd]

        val pic = findViewById<ImageView>(R.id.picture)
        pic.setImageResource(currArt.picId)
        pic.contentDescription = getString(currArt.picNameId)

        findViewById<TextView>(R.id.picName).setText(currArt.picNameId)
        findViewById<TextView>(R.id.picAuthor).setText(currArt.picAuthorId)
        findViewById<TextView>(R.id.picDate).setText(currArt.picDateId)

        findViewById<Button>(R.id.buttonPrev).isEnabled = currInd > 0
        findViewById<Button>(R.id.buttonNext).isEnabled = currInd < picList.size - 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(savedInstanceState != null){
            currInd = savedInstanceState.getInt(KEY, 0)
        }


        val button_prev = findViewById<Button>(R.id.buttonPrev)
        val button_next = findViewById<Button>(R.id.buttonNext)

        button_next.setOnClickListener {
                currInd ++
                update()
        }

        button_prev.setOnClickListener {
                currInd--
                update()
        }
        update()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, currInd)
    }





}