class ConnectFour() {

    private val player1 = 'o'
    private val player2 = '*'

    private val rows = 6
    private val cols = 7

    private var board = makeTheBoard(rows, cols)


    fun start() {
        println("Connect Four")
        println("First player's name:")
        val playerOne = readln()
        println("Second player's name:")
        val playerTwo = readln()

        val regCheck = "\\d+\\s*[Xx]\\s*\\d+".toRegex()


        while (true) {
            println("Set the board dimensions (Rows x Columns)")
            println("Press Enter for default (6 x 7)")
            val newRowsColsVal = readLine()!!.replace("\\s+".toRegex(), " ").trim()
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

        println("$playerOne VS $playerTwo")
        println("$rows X $cols board")
        display(board)
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