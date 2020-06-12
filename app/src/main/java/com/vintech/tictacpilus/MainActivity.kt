package com.vintech.tictacpilus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val firstPlayerPositions = arrayListOf<Int>()
    private val secondPlayerPositions = arrayListOf<Int>()

    private var isFirstPlayerTurn: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Tic Tac Pilus Bukan Garuda"
        setContentView(R.layout.activity_main)
        setOnButtonClickListener()
    }

    private fun setOnButtonClickListener() {
        // first row
        onePointOneButton.setOnClickListener {
            onPlayerClickedTheButton(1, it)
        }
        onePointTwoButton.setOnClickListener {
            onPlayerClickedTheButton(2, it)
        }
        onePointThreeButton.setOnClickListener {
            onPlayerClickedTheButton(3, it)
        }
        // second row
        twoPointOneButton.setOnClickListener {
            onPlayerClickedTheButton(4, it)
        }
        twoPointTwoButton.setOnClickListener {
            onPlayerClickedTheButton(5, it)
        }
        twoPointThreeButton.setOnClickListener {
            onPlayerClickedTheButton(6, it)
        }
        // third row
        threePointOneButton.setOnClickListener {
            onPlayerClickedTheButton(7, it)
        }
        threePointTwoButton.setOnClickListener {
            onPlayerClickedTheButton(8, it)
        }
        threePointThreeButton.setOnClickListener {
            onPlayerClickedTheButton(9, it)
        }
    }

    private fun onPlayerClickedTheButton(position: Int, view: View) {
        // convert view as button.
        val button = view as Button

        if (button.text.isEmpty()) {
            addPosition(position, button)
            checkTheWinner()
        }
    }

    private fun addPosition(position: Int, button: Button) {
        if (isFirstPlayerTurn) {
            button.text = "X"
            firstPlayerPositions.add(position)
            isFirstPlayerTurn = false
        } else {
            button.text = "O"
            secondPlayerPositions.add(position)
            isFirstPlayerTurn = true
        }
    }

    private fun checkTheWinner() {
        if (
            firstPlayerPositions.contains(1) &&
            firstPlayerPositions.contains(2) &&
            firstPlayerPositions.contains(3)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        } else if (
            firstPlayerPositions.contains(1) &&
            firstPlayerPositions.contains(5) &&
            firstPlayerPositions.contains(9)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        } else if (
            firstPlayerPositions.contains(3) &&
            firstPlayerPositions.contains(5) &&
            firstPlayerPositions.contains(7)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        } else if (
            firstPlayerPositions.contains(4) &&
            firstPlayerPositions.contains(5) &&
            firstPlayerPositions.contains(6)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        } else if (
            firstPlayerPositions.contains(7) &&
            firstPlayerPositions.contains(8) &&
            firstPlayerPositions.contains(9)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        } else if (
            firstPlayerPositions.contains(1) &&
            firstPlayerPositions.contains(4) &&
            firstPlayerPositions.contains(7)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        }  else if (
            firstPlayerPositions.contains(3) &&
            firstPlayerPositions.contains(6) &&
            firstPlayerPositions.contains(9)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        } else if (
            firstPlayerPositions.contains(2) &&
            firstPlayerPositions.contains(5) &&
            firstPlayerPositions.contains(8)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = true)
        } else if (
            secondPlayerPositions.contains(1) &&
            secondPlayerPositions.contains(2) &&
            secondPlayerPositions.contains(3)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        } else if (
            secondPlayerPositions.contains(1) &&
            secondPlayerPositions.contains(5) &&
            secondPlayerPositions.contains(9)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        } else if (
            secondPlayerPositions.contains(3) &&
            secondPlayerPositions.contains(5) &&
            secondPlayerPositions.contains(7)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        } else if (
            secondPlayerPositions.contains(4) &&
            secondPlayerPositions.contains(5) &&
            secondPlayerPositions.contains(6)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        } else if (
            secondPlayerPositions.contains(7) &&
            secondPlayerPositions.contains(8) &&
            secondPlayerPositions.contains(9)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        }  else if (
            secondPlayerPositions.contains(1) &&
            secondPlayerPositions.contains(4) &&
            secondPlayerPositions.contains(7)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        }  else if (
            secondPlayerPositions.contains(3) &&
            secondPlayerPositions.contains(6) &&
            secondPlayerPositions.contains(9)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        }  else if (
            secondPlayerPositions.contains(2) &&
            secondPlayerPositions.contains(5) &&
            secondPlayerPositions.contains(8)
        ) {
            showTheWinner(isFirstPlayerWinTheGame = false)
        } else {
            if (firstPlayerPositions.size == 4 && secondPlayerPositions.size == 5) {
                drawResult()
            } else if (firstPlayerPositions.size == 5 && secondPlayerPositions.size == 4) {
                drawResult()
            }
        }
    }

    private fun showTheWinner(isFirstPlayerWinTheGame: Boolean) {
        val message = if (isFirstPlayerWinTheGame) "X player win"
        else "O player win"
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        resetTheGame()
    }

    private fun drawResult() {
        Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show()
        resetTheGame()
    }

    private fun resetTheGame() {
        firstPlayerPositions.clear()
        secondPlayerPositions.clear()
        // first row
        onePointOneButton.text = ""
        onePointTwoButton.text = ""
        onePointThreeButton.text = ""
        // second row
        twoPointOneButton.text = ""
        twoPointTwoButton.text = ""
        twoPointThreeButton.text = ""
        // third row
        threePointOneButton.text = ""
        threePointTwoButton.text = ""
        threePointThreeButton.text = ""
        isFirstPlayerTurn = true
    }
}