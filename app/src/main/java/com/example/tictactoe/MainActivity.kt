package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var putX = true;

    var play_one_numbers = mutableListOf<Int>()
    var play_two_numbers = mutableListOf<Int>()


    var someoneWon = false
    var checkedButtons = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClicked(view: View) {
        val clickedTextView: TextView = view as TextView

        clickedTextView.isEnabled = false
        if (putX) {
            clickedTextView.text = "X"
            clickedTextView.background =
                ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_selected_first)

            play_one_numbers.add(getSelectedNumber(clickedTextView))

            if (checkIfHasWon(play_one_numbers)) {

                toggleAllButtons(false)
                someoneWon = true
                Toast.makeText(this, "Player 1 has won", Toast.LENGTH_LONG).show()
            }

        } else {
            clickedTextView.text = "0"
            clickedTextView.background =
                ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_selected_second)

            play_two_numbers.add(getSelectedNumber(clickedTextView))

            if (checkIfHasWon(play_two_numbers)) {

                toggleAllButtons(false)
                someoneWon = true
                Toast.makeText(this, "Player 2 has won", Toast.LENGTH_LONG).show()
            }
        }
        putX = !putX

        checkedButtons++

        if (checkedButtons == 9 && !someoneWon){
            toggleAllButtons(false)
            Toast.makeText(this, "No winner. You both drew", Toast.LENGTH_LONG).show()
        }
    }


    private fun getSelectedNumber(textView: TextView): Int {

        var selectedNumber = 0;
        when (textView) {

            number_1 -> {
                selectedNumber = 1
            }

            number_2 -> {
                selectedNumber = 2
            }

            number_3 -> {
                selectedNumber = 3
            }

            number_4 -> {
                selectedNumber = 4
            }

            number_5 -> {
                selectedNumber = 5
            }

            number_6 -> {
                selectedNumber = 6
            }

            number_7 -> {
                selectedNumber = 7
            }

            number_8 -> {
                selectedNumber = 8
            }

            number_9 -> {
                selectedNumber = 9
            }

        }

        return selectedNumber

    }


    private fun checkIfHasWon(playerNumbers: MutableList<Int>): Boolean {

        val win1 = listOf(1, 2, 3)
        val win2 = listOf(4, 5, 6)
        val win3 = listOf(7, 8, 9)
        val win4 = listOf(1, 4, 7)
        val win5 = listOf(2, 5, 8)
        val win6 = listOf(3, 6, 9)
        val win7 = listOf(1, 5, 9)
        val win8 = listOf(3, 5, 7)
        if (playerNumbers.containsAll(win1) || playerNumbers.containsAll(win2) || playerNumbers.containsAll(
                win3
            ) || playerNumbers.containsAll(win4) || playerNumbers.containsAll(win5) || playerNumbers.containsAll(
                win6
            ) || playerNumbers.containsAll(win7) || playerNumbers.containsAll(win8)
        ) {
            return true
        }

        return false
    }

    private fun toggleAllButtons(status: Boolean) {
        number_1.isEnabled = status
        number_2.isEnabled = status
        number_3.isEnabled = status
        number_4.isEnabled = status
        number_5.isEnabled = status
        number_6.isEnabled = status
        number_7.isEnabled = status
        number_8.isEnabled = status
        number_9.isEnabled = status

        if (status == false) {

            Handler().postDelayed({
                setBoard()
            }, 2000)
        }

    }

    private fun setBoard() {

        toggleAllButtons(true)
        number_1.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_2.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_3.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_4.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_5.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_6.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_7.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_8.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)
        number_9.background = ContextCompat.getDrawable(this, R.drawable.tic_tac_textview_default)


        play_one_numbers.clear()
        play_two_numbers.clear()
        someoneWon = false
        checkedButtons = 0
        putX = true
    }

}