package com.globe.drawer

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import com.globe.drawer.TipCalculator.TipCalculatorActivity
import com.globe.drawer.movies.MoviesMainActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var tvEmail: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "My Portfolio"

        drawerLayout = findViewById(R.id.drawerLayout)
        // Declare the class for hANdling drawer toggle
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout,
            R.string.open, R.string.close
        )
        // Add ActionBarDrawerToggle as Listener
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        //Required by ActionBarDrawerToggle
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView = findViewById(R.id.navView)
        navigationView.setNavigationItemSelectedListener(this)

        tvEmail = navigationView.getHeaderView(0).findViewById(R.id.tvEmail)
        // getting values on session file
        val sharedPreferences =
            getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val email = sharedPreferences
            .getString(Constants.EMAIL, null)
        tvEmail.text = email

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            Log.d("MainActivity", "${item.title}")

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        when (item.itemId){
            R.id.action_calculator->{
                val calculatorIntent = Intent(this, TipCalculatorActivity::class.java)
                startActivity(calculatorIntent)
            }
            R.id.action_movies->{
                val moviesIntent = Intent(this, MoviesMainActivity::class.java)
                startActivity(moviesIntent)
            }
            R.id.action_logout -> {
                //displays confirmation dialog
                AlertDialog.Builder(this)
                    .setTitle("Logout?")
                    .setPositiveButton("Cancel", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                        }
                    })
                    .setNegativeButton("OK", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("MainActivity", "Logout confirmed")
                            val prefs = getSharedPreferences(
                                Constants.PREFERENCE_NAME,
                                Context.MODE_PRIVATE
                            )
                            prefs.edit()
                                .remove(Constants.EMAIL)
                                .apply()
                            val loginIntent = Intent(
                                this@MainActivity, LoginActivity::class.java)
                            startActivity(loginIntent)
                            finish()
                        }
                    }).show()
                Log.d("MainActivity", "You logged out")
            }
        }
        return false
    }
}