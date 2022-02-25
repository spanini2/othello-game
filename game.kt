object game{

    var othelloBoard = Array(8) {CharArray(8)}

    fun setupBoard(board : Array<CharArray>){
        for (i in 0..7) {
            for (j in 0..7) {
                board[i][j] = '.'
                board[3][3] = 'X'
                board[3][4] = 'O'
                board[4][3] = 'O'
                board[4][4] = 'X'
            }
        }
    }

    fun showBoard(board: Array<CharArray>) {
        println("0 1 2 3 4 5 6 7")
        for(i in 0..7) {
            for(j in 0..7) {
                print("${board[i][j]} ")
            }
            println("$i  ")
        }
    }

    fun placePiece(board: Array<CharArray>, x : Int, y : Int, piece : Char) {

        board[x][y] = piece

        var opponent : Char = 'O'
        if(piece == 'O') {
            opponent = 'X'
        }

        if(flipSearch(board, x-1, y, -1, 0, piece, opponent)) {
            pieceFlip(board, x-1, y, -1, 0, piece, opponent)
        }
        if(flipSearch(board, x-1, y, 1, 0, piece, opponent)) {
            pieceFlip(board, x-1, y, 1, 0, piece, opponent)
        }
        if(flipSearch(board, x, y-1, 0, -1, piece, opponent)) {
            pieceFlip(board, x, y-1, 0, -1, piece, opponent)
        }
        if(flipSearch(board, x, y+1, 0, 1, piece, opponent)) {
            pieceFlip(board, x, y+1, 0, 1, piece, opponent)
        }
        if(flipSearch(board, x-1, y-1, -1, -1, piece, opponent)) {
            pieceFlip(board, x-1, y-1, -1, -1, piece, opponent)
        }
        if(flipSearch(board, x+1, y-1, -1, -1, piece, opponent)) {
            pieceFlip(board, x+1, y-1, -1, -1, piece, opponent)
        }
        if(flipSearch(board, x-1, y+1, -1, -1, piece, opponent)) {
            pieceFlip(board, x-1, y+1, -1, -1, piece, opponent)
        }
        if(flipSearch(board, x+1, y+1, 1, 1, piece, opponent)) {
            pieceFlip(board, x+1, y+1, 1, 1, piece, opponent)
        }
    }

    fun flipSearch(board : Array<CharArray>, x : Int, y : Int, xDelta: Int, yDelta: Int, playerPiece : Char, opponentPiece : Char) : Boolean {
        var pieceX = x
        var pieceY = y

        if (board[pieceX][pieceY] == opponentPiece) {
            while ((x >= 0) && (x < 8) && (y >= 0) && (y < 8)) {
                pieceX == pieceX + xDelta
                pieceY == pieceY + yDelta

                if(board[pieceX][pieceY] == '.') {
                    return false
                }
                if(board[pieceX][pieceY] == playerPiece) {
                    return true
                } else {

                }
            }
        }
        return false
    }

    fun pieceFlip(board : Array<CharArray>, x : Int, y : Int, xDelta: Int, yDelta: Int, playerPiece : Char, opponentPiece : Char) {

        var pieceX = x
        var pieceY = y

        while (board[pieceX][pieceY] == opponentPiece) {
            board[pieceX][pieceY] = playerPiece
            pieceX = pieceX + xDelta
            pieceY = pieceY + yDelta
        }
    }

    fun validateMove(board: Array<CharArray>, x: Int, y: Int, piece: Char): Boolean {

        if(board[x][y] != '.') {
            return false
        }

        var opponent = 'O'
        if(piece == 'O') {
            opponent = 'X'
        }

        if(flipSearch(board, x-1, y, -1, 0, piece, opponent)) {
            return true
        }
        if(flipSearch(board, x-1, y, 1, 0, piece, opponent)) {
            return true
        }
        if(flipSearch(board, x, y-1, 0, -1, piece, opponent)) {
            return true
        }
        if(flipSearch(board, x, y+1, 0, 1, piece, opponent)) {
            return true
        }
        if(flipSearch(board, x-1, y-1, -1, -1, piece, opponent)) {
            return true
        }
        if(flipSearch(board, x+1, y-1, -1, -1, piece, opponent)) {
            return true
        }
        if(flipSearch(board, x-1, y+1, -1, -1, piece, opponent)) {
            return true
        }
        if(flipSearch(board, x+1, y+1, 1, 1, piece, opponent)) {
            return true
        }

        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {

        var xInput = 0
        var yInput = 0

        var board = othelloBoard
        var cPlayer = 'X'

        setupBoard(board)

        while (true) {
            showBoard(board)
            println("It is player $cPlayer 's turn")
            println("Enter coords of move:")
            var xInput = readLine()!!.toInt()
            var yInput = readLine()!!.toInt()
            placePiece(board, xInput, yInput, cPlayer)

            if (cPlayer == 'X') {
                cPlayer = 'O'
            } else {
                cPlayer = 'X'
            }
        }
    }
}