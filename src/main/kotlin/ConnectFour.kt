class ConnectFour {

    private val player1 = 'o'
    private val player2 = '*'

    private lateinit var playerOneName: String
    private lateinit var playerTwoName: String

    private var playerOneMove = true
    private var playerTwoMove = false

    private val rows = 6
    private val columns = 7

    private var board = makeTheBoard(rows, columns)
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
        println("$rows X $columns board")
    }

    private fun startGame() {
        while (true) {

            while (playerOneMove) {
                println("$playerOneName's turn:")
                val playerOneMove = playerMove()
                if (playerOneMove == "end") {
                    println("Game Over!").also { return }
                } else {
                    moveCheck(playerOneMove, player1)
                }
            }

            if (drawCheck()) return
            if (winCheck()) return

            while (playerTwoMove) {
                println("$playerTwoName's turn:")
                val playerTowMove = playerMove()
                if (playerTowMove == "end") {
                    println("Game Over!").also { return }
                } else {
                    moveCheck(playerTowMove, player2)
                }
            }

            if (drawCheck()) return
            if (winCheck()) return
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
        } catch (e: NumberFormatException) {
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

    private fun winCheck(): Boolean {

        for (row in board) {
            val checked = row.joinToString("")
            if (checker(checked)) return true
        }
        // Check columns for win
        for (column in 0 until board[0].size) {
            var checked = ""
            for (i in 0 until board.size) {
                checked += board[i][column]
            }
            if (checker(checked)) return true
        }
        // Check diagonal win
        for (column in 3 until board[0].size) {
            for (i in board.size - 4 downTo 0) {
                var checked = ""
                for (k in 0..3) {
                    checked += board[i + k][column - k]
                }
                if (checker(checked)) return true
            }
        }
        for (column in board[0].size - 4 downTo 0) {
            for (i in board.size - 4 downTo 0) {
                var checked = ""
                for (k in 0..3) {
                    checked += board[i + k][column + k]
                }
                if (checker(checked)) return true
            }
        }
        return false
    }

    private fun checker(str: String): Boolean {
        val playerO = "oooo"
        val playerX = "****"

        if (str.contains(playerO)) {
            println("Player $playerOneName won")
            println("Game Over!").also { return true }
        }

        if (str.contains(playerX)) {
            println("Player $playerTwoName won")
            println("Game Over!").also { return true }
        }

        return false
    }

    private fun drawCheck(): Boolean {
        if (!board[0].contains(' ')) {
            println("It is a draw")
            println("Game Over!").also { return true }
        }
        return false
    }
}