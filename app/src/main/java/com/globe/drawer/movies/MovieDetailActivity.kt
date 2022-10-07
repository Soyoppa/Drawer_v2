package com.globe.drawer.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.globe.drawer.R


class MovieDetailActivity : AppCompatActivity(){
    private lateinit var tvShowTitle: TextView
    private lateinit var rbShowRating: RatingBar
    private lateinit var ivShowPoster: ImageView
    private lateinit var tvShowPlot: TextView
    private lateinit var tvPlotButton: TextView
    private lateinit var tvCastButton: TextView
    private lateinit var tvYear: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moviedetail)
        tvShowTitle = findViewById(R.id.tvShowTitle)
        rbShowRating = findViewById(R.id.rbShowRating)
        ivShowPoster = findViewById(R.id.ivShowPoster)
        tvPlotButton = findViewById(R.id.tvPlotbutton)
        tvCastButton = findViewById(R.id.tvCastButton)
        tvShowPlot = findViewById(R.id.tvShowPlot)
        tvYear = findViewById(R.id.tvYear)

        val title = intent.getStringExtra("title")
        val plot = intent.getStringExtra("plot")
        val rating = intent.getDoubleExtra("rating", 0.0)
        val poster = intent.getIntExtra("poster", 0)
        val cast = intent.getStringExtra("cast")
        val year = intent.getStringExtra("year")

        //val movie : Movie = intent.getSerializableExtra()
        tvShowTitle.text = title
        tvShowPlot.setMovementMethod(ScrollingMovementMethod())
        tvShowPlot.text = plot
        tvYear.text =year
        rbShowRating.rating = rating.toFloat()
        ivShowPoster.setImageResource(poster)

        tvPlotButton.setOnClickListener {
            Log.d("MovieDetailActivity", "plot text clicked")
            tvShowPlot.text = plot
        }
        tvCastButton.setOnClickListener {
            Log.d("MovieDetailActivity", "cast text clicked")
            tvShowPlot.text = cast
        }

    }
}

