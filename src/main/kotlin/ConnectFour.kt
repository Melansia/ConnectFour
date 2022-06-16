class ConnectFour() {

    private val player1 = 'o'
    private val player2 = '*'

    private lateinit var playerOneName: String
    private lateinit var playerTwoName: String

    private var playerOneMove = true
    private var playerTwoMove = false

    private val defaultRows = 6
    private val defaultColumns = 7

    private var board = makeTheBoard(defaultRows, defaultColumns)
    private val regCheck = "\\d+\\s*[Xx]\\s*\\d+".toRegex()

    fun start() {

        prepareGame()
        display(board)
        startGame()
    }

    private fun prepareGame() {
        println("Connect Four")
        println("First player's name:")
        playerOneName = readln()
        println("Second player's name:")
        playerTwoName = readln()

        while (true) {
            println("Set the board dimensions (Rows x Columns)")
            println("Press Enter for default (6 x 7)")
            val newRowsColsVal = readLine()!!.replace("\\s+".toRegex(), "").trim()
            when {
                newRowsColsVal.isEmpty() -> break
                newRowsColsVal.matches(regCheck) -> {
                    if (newRowsColsVal.first().digitToInt() !in 5..9) {
                        println("Board rows should be from 5 to 9")
                    } else if (newRowsColsVal.last().digitToInt() !in 5..9) {
                        println("Board columns should be from 5 to 9")
                    } else {
                        val newRows = newRowsColsVal.first().digitToInt()
                        val newColumns = newRowsColsVal.last().digitToInt()
                        board = makeTheBoard(newRows, newColumns)
                        break
                    }
                }
                else -> {
                    println("Invalid input")
                }
            }
        }

        println("$playerOneName VS $playerTwoName")
        println("$defaultRows X $defaultColumns board")
    }

    private fun startGame() {
        while (true) {

            while (playerOneMove) {
                println("$playerOneName's turn:")
                val playerOneMove = playerMove()
                if (playerOneMove != "end") {
                    moveCheck(playerOneMove, player1)
                } else println("Game Over!").also { return }
            }

            while (playerTwoMove) {
                println("$playerTwoName's turn:")
                val playerTowMove = playerMove()
                if (playerTowMove != "end") {
                    moveCheck(playerTowMove, player2)
                } else println("Game Over!").also { return }
            }
        }
    }

    private fun moveCheck(playerMove: String, player: Char) {
        val column = playerMove.toInt()
        var lastRow = board.lastIndex
        try {
            while (board[lastRow][column - 1] != ' ') {
                if (lastRow == 0) {
                    println("Column $column is full")
                    return
                } else lastRow--
            }
            if (player == 'o') {
                board[lastRow][column - 1] = player1
                playerTwoMove = true
                playerOneMove = false
                display(board)
            }
            if (player == '*') {
                board[lastRow][column - 1] = player2
                playerOneMove = true
                playerTwoMove = false
                display(board)
            }
        }catch (e: NumberFormatException) {
            println("Incorrect column number")
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("The column number is out of range (1 - ${board[0].size})")
        }
    }

    private fun playerMove(): String {
        return readln()
    }

    private fun makeTheBoard(rows: Int, columns: Int): Array<Array<Char>> {
        return Array(rows) { Array(columns) { ' ' } }
    }

    private fun display(l: Array<Array<Char>>) {
        for (i in 1..l[0].size) print(if (i == l[0].size) " $i\n" else " $i")
        for (i in 1..l.size) println("|${l[i - 1].joinToString("|")}|")
        for (i in 0..l[0].size * 2) print("=")
        println()
    }
}