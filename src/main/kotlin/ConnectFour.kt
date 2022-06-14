class ConnectFour() {
    fun start() {
        println("Connect Four")
        println("First player's name:")
        val playerOne = readln()
        println("Second player's name:")
        val playerTwo = readln()

        var rows = 6
        var cols = 7

        val board = Array(rows) { IntArray(cols) }
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
                        rows = newRowsColsVal.first().digitToInt()
                        cols = newRowsColsVal.last().digitToInt()
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
    }
}