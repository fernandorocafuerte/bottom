package com.example.bottom


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replacerFragment(Home())

        binding.bottomNavigationView.setOnItemReselectedListener{

            when (it.itemId) {

                R.id.home -> replacerFragment(Home())
                R.id.profile -> replacerFragment(Profile())
                R.id.settings -> replacerFragment(Settings())

                else -> {


                }
            }

            true
        }


    }

    private fun replacerFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }

}