package com.android.custombottomnavigationmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.android.custombottomnavigationmenu.fragment.AboutFragment
import com.android.custombottomnavigationmenu.fragment.HomeFragment
import com.android.custombottomnavigationmenu.fragment.SearchFragment
import com.android.custombottomnavigationmenu.fragment.SettingsFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var fragment_container: FrameLayout
    lateinit var bottomNavigation: LinearLayout
    lateinit var ivHome: ImageView
    lateinit var ivAbout: ImageView
    lateinit var ivPlus: ImageView
    lateinit var ivSearch: ImageView
    lateinit var ivSettings: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        fragment_container = findViewById(R.id.fragment_container)
        ivHome = findViewById(R.id.ivHome)
        ivAbout = findViewById(R.id.ivAbout)
        ivPlus = findViewById(R.id.ivPlus)
        ivSearch = findViewById(R.id.ivSearch)
        ivSettings = findViewById(R.id.ivSettings)
        ivHome.setOnClickListener(this)
        ivAbout.setOnClickListener(this)
        ivPlus.setOnClickListener(this)
        ivSearch.setOnClickListener(this)
        ivSettings.setOnClickListener(this)

        val homeFragment = HomeFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.fragment_container, homeFragment)
        transaction.commit()
    }

    override fun onClick(v: View?) {
        if (v!!.equals(ivHome)) {
            val homeFragment = HomeFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, homeFragment)
            transaction.commit()
        }
        else if (v!!.equals(ivAbout)) {
            val aboutFragment = AboutFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, aboutFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else if (v!!.equals(ivPlus)) {
            Toast.makeText(this, "Plus btn clicked", Toast.LENGTH_SHORT).show()
        }
        else if (v!!.equals(ivSearch)) {
            val searchFragment = SearchFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, searchFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else if (v!!.equals(ivSettings)) {
            val settingsFragment = SettingsFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, settingsFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else {
            Log.d("bottom navigation", "else part of bottom navigation")
        }
    }
}