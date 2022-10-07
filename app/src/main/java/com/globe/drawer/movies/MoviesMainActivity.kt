package com.globe.drawer.movies

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.globe.drawer.R




class MoviesMainActivity : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
    private val movieAdapter = MovieAdapter()
    private val movies: ArrayList<Movie> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity_main)

        supportActionBar?.title = "MOVIES"
        rvMovies = findViewById(R.id.rvMovies)
        initializedMovies()

        movieAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClicked(position: Int) {
                val selectedMovie = movieAdapter.movies.get(position)
                movieDetail(position)
                Log.d("MovieMainActivity", "Movie Clicked $selectedMovie")
            }
        }

    }

    private fun initializedMovies(){
        movies.add(Movie("Gagamboy",R.drawable.gagamboy,5.0,"2004","An accident at a pharmaceutical lab turns the mild-mannered and unassuming Junie, an ice cream vendor, into a superhero. Junie finds out that being strong and admired can also have its downside.","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("Enteng Kabisote",R.drawable.enteng_kabisote,3.0,"2010","Agimat is amazed of the other world and hopes that things in his world turn out better. His dream is to have a happy family like Enteng's. The story unfolds: Satana is the one ordering the monsters to snatch children so that she can use their blood to revive Ragat, the powerful lord of darkness","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("My Neighbor Totoro",R.drawable.totoro,5.0,"2006","This acclaimed animated tale by director Hayao Miyazaki follows schoolgirl Satsuke and her younger sister, Mei, as they settle into an old country house with their father and wait for their mother to recover from an illness in an area hospital. As the sisters explore their new home, they encounter and befriend playful spirits in their house and the nearby forest, most notably the massive cuddly creature known as Totoro.","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("Spirited Home",0,3.0,"2000","---","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("Spirited Far From Home",0,5.0,"2000","---","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("How I met your Mother",R.drawable.himym,5.0,"2000","A father recounts to his children - through a series of flashbacks - the journey he and his four best friends took leading up to him meeting their mother. Ted Mosby sits down with his kids, to tell them the story of how he met their mother.","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("Spirited homecoming",0,5.0,"2000"," Lorem Ipsum has been the ind","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("Spirited Away",R.drawable.spirited_away,5.0,"2000","sng industry. Lorem Ipsum has been the ind","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))
        movies.add(Movie("Spirited Fafa Away",0,5.0,"2000","typesetting industry. Lorem","Vhong Navarro\t...\tJunie Gagamboy\n" +
                "Jay Manalo\tJay Manalo\t...\tDodoy / Ipisman\n" +
                "Aubrey Miles\tAubrey Miles\t...\tLiana\n" +
                "Long Mejia\tLong Mejia\t...\tKapitan Gimo\n" +
                "Bearwin Meily\tBearwin Meily\t...\tAbner\n" +
                "Renee Hampshire\tRenee Hampshire\t...\tAte Gloring (as Rene 'Ate Glow' Facunla)\n" +
                "Benjamin Abelarde\tBenjamin Abelarde\t...\tSimeon\n" +
                "Chris Cruz\tChris Cruz\t...\tBronson\n" +
                "Nikko Manalo\tNikko Manalo\t...\tBoogie\n" +
                "Ernie Zarate\tErnie Zarate\t...\tBoss"))

        movieAdapter.movies = movies
        rvMovies.adapter =movieAdapter
        Log.d("MainActivity",movies.toString())

    }

    fun movieDetail(moviePosition: Int){
        val selectedMovie: Movie = movieAdapter.movies.get(moviePosition)
        val movieDetailIntent = Intent(this, MovieDetailActivity::class.java)
        movieDetailIntent.putExtra("title",selectedMovie.title)
        movieDetailIntent.putExtra("poster",selectedMovie.poster)
        movieDetailIntent.putExtra("rating",selectedMovie.rating)
        movieDetailIntent.putExtra("plot",selectedMovie.plot)
        movieDetailIntent.putExtra("cast",selectedMovie.cast)
        movieDetailIntent.putExtra("year",selectedMovie.year)
        startActivity(movieDetailIntent)
    }
}