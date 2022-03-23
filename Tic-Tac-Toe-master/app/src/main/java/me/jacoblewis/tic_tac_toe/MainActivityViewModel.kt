package me.jacoblewis.tic_tac_toe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.jacoblewis.tic_tac_toe.models.Board
import me.jacoblewis.tic_tac_toe.models.BoardState
import me.jacoblewis.tic_tac_toe.models.Cell
import me.jacoblewis.tic_tac_toe.models.CellState

class MainActivityViewModel : ViewModel() {
    val mainBoard = Board()
    val board = MutableLiveData(mainBoard)
    var flag = true

    private fun updateBoard() {
        board.value = mainBoard
    }

    fun boardClicked(cell: Cell) {

        if (flag == true) {
            if (mainBoard.setCell(cell, CellState.Star)) {
                updateBoard()
                flag = false
            }
        }else{
            mainBoard.setCell(cell, CellState.Circle)
            updateBoard()
            flag = true
        }
    }

    /*If you want to play as 1 player, uncomment the following method and coment "boardClicked" method(over this comment)
    fun boardClicked(cell: Cell) {
        if (mainBoard.setCell(cell, CellState.Star)) {
            updateBoard()
            if (mainBoard.boardState == BoardState.INCOMPLETE) {
                aiTurn()
            }
        }
    }

    Private fun aiTurn() {


        val circleWinningCell = mainBoard.findNextWinningMove(CellState.Circle)
        val startWinningCell = mainBoard.findNextWinningMove(CellState.Star)
        when {
            // If the AI can win, place a circle in that spot
            circleWinningCell != null -> mainBoard.setCell(circleWinningCell, CellState.Circle)
            // If the AI is about to lose, place a circle in a blocking spot
            startWinningCell != null -> mainBoard.setCell(startWinningCell, CellState.Circle)
            // Prioritize the middle
            mainBoard.setCell(Cell.CENTER_CENTER, CellState.Circle) -> Unit
            // Otherwise place a circle in a random spot
            else -> do {
                val nextCell = Cell.values().random()
                val placeSuccess = mainBoard.setCell(nextCell, CellState.Circle)
            } while (!placeSuccess)
        }

        updateBoard()
    }*/

    fun resetBoard() {
        mainBoard.clearBoard()
        flag = true
        updateBoard()
    }
}