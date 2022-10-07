package com.globe.drawer


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.globe.drawer.Constants.PREFERENCE_NAME
import com.globe.drawer.Constants.EMAIL

class LoginActivity:AppCompatActivity() {

    private lateinit var tvAppName: TextView
    private lateinit var imgAppLogo: ImageView
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    //val user_email = "renz@gmail.com"
    //val user_password = "renzjohn"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.title = "LOGIN"

        tvAppName = findViewById(R.id.tvAppName)
        imgAppLogo = findViewById(R.id.imgAppLogo)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        if(isLoggedIn()){
            launchMainActivity()
            finish()
        }

        btnLogin.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("LoginActivity","login button clicked")
                if (isCredentialsValid()){
                    saveCredential()
                    launchMainActivity()
                    finish()
                }
                else{
                    Toast.makeText(this@LoginActivity,"invalid creds",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun launchMainActivity(){
        val mainIntent = Intent(this,MainActivity::class.java)
        startActivity(mainIntent)
    }

    private fun isCredentialsValid():Boolean{
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        return email =="renz@gmail.com" && password =="renz1234"
    }

    private fun validatePassword(): Boolean {
        val password = etPassword.text.toString()
        return password.length > 6
    }
    private fun getMyPref():SharedPreferences{
        return getSharedPreferences(Constants.PREFERENCE_NAME, MODE_PRIVATE)
    }

    private fun saveCredential(){
        val sharedPreferences = getMyPref()
        val email = etEmail.text.toString()

        sharedPreferences
            .edit()
            .putString(Constants.EMAIL,email)
            .apply()
    }

    private fun isLoggedIn():Boolean{
        val sharedPreferences = getMyPref()
        val email = sharedPreferences.getString(Constants.EMAIL,null)
        return  email != null
    }
}