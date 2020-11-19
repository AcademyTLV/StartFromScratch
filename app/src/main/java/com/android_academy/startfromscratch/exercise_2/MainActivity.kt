package com.android_academy.startfromscratch.exercise_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_academy.startfromscratch.R
import com.android_academy.startfromscratch.exercise_2.ui.mainMovies.MoviesFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesFragment.newInstance())
                .commitNow()
        }
    }
}
