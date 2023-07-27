package com.diksh.androidtv

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : FragmentActivity() {   //replaced AppcompatActivity with the FragmentActivity because action bar is not used

    lateinit var title : TextView   //used lateinit as it is non-null defined property
    lateinit var language : TextView
    lateinit var description : TextView

    lateinit var bannerImage : ImageView
    lateinit var listFragment : ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.title_tv)
        language = findViewById(R.id.language_tv)
        description = findViewById(R.id.description_tv)

        bannerImage = findViewById(R.id.image_banner)

        listFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, listFragment)
        transaction.commit()

        val gson = Gson()
        val i : InputStream = this.assets.open("movies.json")
        val br = BufferedReader(InputStreamReader(i))
        val dataList : DataModel = gson.fromJson(br, DataModel::class.java)

        listFragment.bindData(dataList)

    }
}