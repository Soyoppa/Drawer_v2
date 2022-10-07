package com.globe.drawer.TipCalculator

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import com.globe.drawer.R
import android.view.Menu

const val TAG = "MainActivity"

class TipCalculatorActivity : AppCompatActivity() {

    private lateinit var ptAmount: EditText
    private lateinit var seekBar: SeekBar
    private lateinit var tvTip: TextView
    private lateinit var tvTotal: TextView
    private lateinit var tvTipPercent: TextView
    private lateinit var tvDescriber: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tip_calculator_activity_main)
        supportActionBar?.title = "TIP CALCULATOR"

        ptAmount = findViewById(R.id.ptAmount)
        seekBar = findViewById(R.id.sbTipPercent)
        tvTip = findViewById(R.id.tvTipAmount)
        tvTotal = findViewById(R.id.tvTotalAmount)
        tvTipPercent = findViewById(R.id.tvTipPercent)
        tvDescriber = findViewById(R.id.tvDescriber)
        addEditTextListener()
        addseekbarlistener()
    }
    @SuppressLint("ResourceType")

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                Log.d("Second Activity", "home pressed")
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun addEditTextListener(){
        ptAmount.setText("")

        ptAmount.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("MainActivity", s?.toString() ?:"")
                computeTip()
            }
        })
    }

    fun addseekbarlistener(){
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("MainActivity","$progress")

                tvTipPercent.text ="$progress%"

                computeTip()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    fun computeTip(){

        val amount = ptAmount.text.toString().toDoubleOrNull() ?: 0.0
        val percentage = seekBar.progress
        val tip = amount*(percentage/100.0)
        val total= amount + tip
        var word = ""

        Log.d("MainActivity","$tip")
        tvTip.text ="%.2f".format(tip)
        tvTotal.text="%.2f".format(total)

        word = when (percentage!!.toInt()){
            in 0..9 -> "Poor"
            in 10..15 -> "Good"
            else -> "Generous"

        }
        when (word){
            in "Poor" -> tvDescriber.setTextColor(Color.parseColor("#FF6B4C")).toString()
            in "Good" -> tvDescriber.setTextColor(Color.parseColor("#F4F540")).toString()
            else -> tvDescriber.setTextColor(Color.parseColor("#3DEF65")).toString()
        }
        tvDescriber.text= word
        Log.d("MainActivity","$word")
    }
}