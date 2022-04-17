import java.util.Scanner;

public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args)
    {
        // Clear the board and set the player to X (since X always moves first)

        // Get the coordinates for the move which should be 1 – 3 for the row and col

        // Convert the player move coordinates to the array indices which are 0 – 2 by subtracting 1

        // Loop until the converted player coordinates are a valid move

        // If appropriate check for a win or a tie (i.e. if it is possible for a win or a tie at this point in the game, check for it.)

        // If there is a win or tie announce it and then prompt the players to play again.

        // Toggle the player (i.e. X becomes O, O becomes X)


        boolean finished = false;
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String player = "X";
        int turnCnt = 0;
        int row = -1;
        int col = -1;
        final int WIN_MOVES = 5;
        final int TIE_MOVES = 7;

        do
        {
            player = "X";
            playing = true;
            turnCnt = 0;
            clearBoard();

            do
            {
                do
                {
                    display();
                    System.out.println("Enter move for " + player);
                    row = SafeInput.getRangedInt(in,"Enter row: ", 1,3);
                    col = SafeInput.getRangedInt(in, "Enter col: ", 1, 3);
                    row--;
                    col--;
                }while(!isValidMove(row, col));
                board[row][col] = player;
                turnCnt++;

                if (turnCnt >= WIN_MOVES)
                {
                    if (isWin(player))
                    {
                        display();
                        System.out.println("Player " + player + " wins! ");
                        playing = false;
                    }
                }

                if (turnCnt >= TIE_MOVES)
                {
                    if (isTie())
                    {
                        display();
                        System.out.println("It's a tie!");
                        playing = false;
                    }
                }

                if (player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }

            }while(playing);

            finished = SafeInput.getYNConfirm(in,"Are you done finished playing? ");

        }while (!finished);
    }

    private static void clearBoard()
    // sets all the board elements to a space
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                board[row][col] = " "; // makes this cell a space
            }
        }
    }

    private static void display()
    // shows the Tic Tac Toe game used as part of the prompt for the users move choice…
    {
        for(int row = 0;row < ROWS; row++)
        {
            System.out.print("| ");
            for (int col = 0; col < COLS; col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

	private static boolean isValidMove(int row, int col)
    // returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    {
        boolean retVal = false;
        if(board[row][col].equals(" "))
        {
            retVal = true;
        }
            return retVal;
    }
    private static boolean isWin(String player)
    // checks to see if there is a win state on the current board for the specified player (X or O) This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        return false;
    }

    private static boolean isColWin(String player)
    // checks for a col win for specified player
    {
        for(int col = 0; col < COLS; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }
	private static boolean isRowWin(String player)
    // checks for a row win for the specified player
    {
        for(int row = 0; row < ROWS; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }
	private static boolean isDiagnalWin(String player)
    // checks for a diagonal win for the specified player
    {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) )
        {
            return true;
        }
        if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player) )
        {
            return true;
        }
        return false;
    }
	private static boolean isTie()
    // checks for a tie condition: all spaces on the board are filled OR there is an X and an O in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)
    {
        boolean xFlag = false;
        boolean oFlag = false;
        // check all 8 vectors for an X and O so
        // no wins possible


        //check for row ties
        for(int row = 0; row < ROWS; row++)
        {
            if(board[row][0].equals("X") || board[row][1].equals("X") || board[row][2].equals("X"))
            {
                xFlag = true; // There is an X in the row
            }
            if(board[row][0].equals("O") || board[row][1].equals("O") || board[row][2].equals("O"))
            {
                oFlag = true; // There is an O in the row
            }

            if(!xFlag && oFlag)
            {
                return false; // no tie, there can still be a row win
            }

            xFlag = oFlag = false;
        }

        // check columns
        for(int col = 0; col < COLS; col++)
        {
            if (board[0][col].equals("X") || board[1][col].equals("X") || board[2][col].equals("X"))
            {
                xFlag = true; // There is an X in the col
            }
            if (board[0][col].equals("O") || board[1][col].equals("O") || board[2][col].equals("O"))
            {
                oFlag = true; // There is an O in the col
            }
            if (! (xFlag && oFlag))
            {
                return false; // no tie, there can still be a col win
            }
        }
            // check diagonals

            xFlag = oFlag = false;
            if (board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X"))
            {
                xFlag = true;
            }
            if (board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O"))
            {
                oFlag = true;
            }
            if (! (xFlag && oFlag))
            {
                return false; // no tie, Can still have a diagonal win
            }

            xFlag = oFlag = false;

            if (board[0][2].equals("X") || board[1][1].equals("X") || board[2][0].equals("X"))
            {
                xFlag = true;
            }
            if (board[0][2].equals("O") || board[1][1].equals("O") || board[2][0].equals("O"))
            {
                oFlag = true;
            }
            if (! (xFlag && oFlag))
            {
                return false;
            }

            return true;
    }

}
