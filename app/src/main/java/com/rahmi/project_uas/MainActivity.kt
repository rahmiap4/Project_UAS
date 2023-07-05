package com.rahmi.project_uas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val movieFragment = MovieFragment()
        val tvFragment = TVFragment()


        makeCurrentFragment (movieFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_movie -> makeCurrentFragment(movieFragment)
                R.id.menu_tv -> makeCurrentFragment(tvFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }

    }
}