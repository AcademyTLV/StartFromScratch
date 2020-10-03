package com.android_academy.startfromscratch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_academy.startfromscratch.solution_1.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        solution_button1.setOnClickListener {
            startSolution1()
        }

        solution_button2.setOnClickListener {
            startSolution2()
        }

        solution_button3.setOnClickListener {
            startSolution3()
        }

        solution_button4.setOnClickListener {
            startSolution4()
        }

        solution_button5.setOnClickListener {
            startSolution5()
        }

        exercise_button_1.setOnClickListener {
            startExercise1()
        }

        exercise_button_2.setOnClickListener {
            startExercise2()
        }


        exercise_button_3.setOnClickListener {
            startExercise3()
        }


        exercise_button_4.setOnClickListener {
            startExercise4()
        }


        exercise_button_5.setOnClickListener {
            startExercise5()
        }

    }

    private fun startExercise5() {
        TODO("Not yet implemented")
    }

    private fun startExercise4() {
        TODO("Not yet implemented")
    }

    private fun startExercise3() {
        TODO("Not yet implemented")
    }

    private fun startExercise2() {
        TODO("Not yet implemented")
    }

    private fun startExercise1() {
        TODO("Not yet implemented")
    }

    private fun startSolution5() {
        TODO("Not yet implemented")
    }

    private fun startSolution4() {
        TODO("Not yet implemented")
    }

    private fun startSolution3() {
        TODO("Not yet implemented")
    }

    private fun startSolution2() {
        TODO("Not yet implemented")
    }

    private fun startSolution1() {
        startActivity(Intent(this, MovieActivity::class.java))
    }
}