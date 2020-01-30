package com.android.custombottomnavigationmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.android.custombottomnavigationmenu.fragment.AboutFragment
import com.android.custombottomnavigationmenu.fragment.HomeFragment
import com.android.custombottomnavigationmenu.fragment.SearchFragment
import com.android.custombottomnavigationmenu.fragment.SettingsFragment

class MainActivity : AppCompatActivity() {
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

        val homeFragment = HomeFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.fragment_container, homeFragment)
        transaction.commit()

        ivHome.setOnClickListener {
            val homeFragment = HomeFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, homeFragment)
            transaction.commit()
        }
        ivAbout.setOnClickListener {
            val aboutFragment = AboutFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, aboutFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        ivPlus.setOnClickListener {
            Toast.makeText(this, "Plus btn clicked", Toast.LENGTH_SHORT).show()
        }

        ivSearch.setOnClickListener {
            val searchFragment = SearchFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, searchFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        ivSettings.setOnClickListener {
            val settingsFragment = SettingsFragment()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, settingsFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}