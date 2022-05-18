import java.util.Random;
import java.util.Scanner;
//Add in comments throughout the code to help you understand
//what each method is used for (TODO: S.1.1)

public class TTT_Runner {
    public static void main(String[] args) {
        TTT_board board = new TTT_board();
        Player p1;
        AIplayer ai;
        int player1 = 0; // AI goes first
        String player1Type = "O";
        String aiType = "X";

        System.out.println("Welcome to Tic-Tac-Toe");


        //QUESTION: Randomize who is 'X' and 'O' (TODO: S.1.2)
        Random r = new Random();
        int random1 = r.nextInt(2);

        // establishes who is who
        if (random1 == 0) {
            player1 = 1;  // player goes first
            player1Type = "X";
            aiType = "O";
            System.out.println("You are Player 1: 'X'");
            System.out.println("And the AI is 'O'\n");
        } else {
            System.out.println("You are Player 2: 'O'");
            System.out.println("And the AI is 'X'\n");
        }

        p1 = new Player(player1Type, "Player 1");
        //Player p2 = new Player("O", "Player 2");
        ai = new AIplayer(aiType, "Allen Iverson");


        //QUESTION: Randomize player order, who goes first and who goes second. ( TODO: S.1.3)
        System.out.println("Player 1 places first.");


        boolean gameOn = true;
        int count = 0;
        while(gameOn) {
            //Player decides their move
            if (player1 == 1) {
                String[] p1_move = p1.turn(board);

                //Board is updated with their move
                board.placeMove(p1, p1_move);

                if (board.isThereWinner().equals("X") || board.isThereWinner().equals("O") || count == 4) {
                    gameOn = false;
                } else {
                    System.out.println(board.printBoard());
                    //Player decides their move
                    //String[] ai_move = ai.randoTurn(board);
                    String[] ai_move = ai.turn(board);
                    //Board is updated with their move
                    board.aiPlaceMove(ai, ai_move);
                }

                if (board.isThereWinner().equals("X") || board.isThereWinner().equals("O")) {
                    gameOn = false;
                }

            } else {
                //Player decides their move
                String[] ai_move = ai.turn(board);
                //String[] ai_move = ai.randoTurn(board);
                //Board is updated with their move
                board.aiPlaceMove(ai, ai_move);

                if (board.isThereWinner().equals("X") || board.isThereWinner().equals("O") || count == 4) {
                    gameOn = false;
                } else {
                    System.out.println(board.printBoard());

                    String[] p1_move = p1.turn(board);

                    //Board is updated with their move
                    board.placeMove(p1, p1_move);
                }

                if (board.isThereWinner().equals("X") || board.isThereWinner().equals("O")) {
                    gameOn = false;
                }
            }
            System.out.println(board.printBoard());
            count++;
        }

        //QUESTION: Output who won the game. (TODO: S.1.5)
        if (board.isThereWinner().equals("X")) {
            if (aiType.equals("X")) {
                System.out.println("The AI won!");
            } else {
                System.out.println("You won!");
            }
        } else if (board.isThereWinner().equals("O")){
            if (aiType.equals("O")) {
                System.out.println("The AI won!");
            } else {
                System.out.println("You won!");
            }
        } else {
            System.out.println("Tie Game!");
        }

        System.out.println("Thanks for playing!");
    }
}

class TTT_board {

    String[][] board = new String[3][3];


    TTT_board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    String printBoard() {
        String b_string = "\n";

        for(int i=0; i<board.length;i++) {
            b_string += " ";
            for(int j=0; j<board[0].length;j++) {
                b_string += board[i][j];
                if (j != 2){
                    b_string += " | ";
                }
            }
            if (i!=2) {
                b_string += "\n------------\n";
            }
        }

        return b_string + "\n";
    }

    String isThereWinner() {
        /*
        QUESTION: This method will determine if someone has won the game. (TODO: S.1.4)
         */

        int[][] boardConverted = new int[3][3];
        for(int i=0; i<board.length;i++) {
            for(int j=0; j<board[0].length;j++) {
                if (board[i][j].equals("X")) {
                    boardConverted[i][j] = 1;
                }
                if (board[i][j].equals("O")) {
                    boardConverted[i][j] = -1;
                }
            }
        }
        int count1 = boardConverted[0][0] + boardConverted[0][1] + boardConverted[0][2];
        int count2 = boardConverted[1][0] + boardConverted[1][1] + boardConverted[1][2];
        int count3 = boardConverted[2][0] + boardConverted[2][1] + boardConverted[2][2];
        int count4 = boardConverted[0][2] + boardConverted[1][2] + boardConverted[2][2];
        int count5 = boardConverted[0][1] + boardConverted[1][1] + boardConverted[2][1];
        int count6 = boardConverted[0][0] + boardConverted[1][0] + boardConverted[2][0];
        int count7 = boardConverted[0][0] + boardConverted[1][1] + boardConverted[2][2];
        int count8 = boardConverted[2][0] + boardConverted[1][1] + boardConverted[0][2];
        if (count1 == 3 || count2 == 3 || count3 == 3 || count4 == 3 || count5 == 3 || count6 == 3|| count7 == 3 || count8 == 3) {
            return "X";
        } else if (count1 == -3 || count2 == -3 || count3 == -3 || count4 == -3 || count5 == -3 || count6 == -3 || count7 == -3|| count8 == -3){
            return "O";
        } else {
            return "";
        }
    }

    void placeMove(Player p, String[] pMove) {
        String value = p.getPiece();
        int row = Integer.parseInt(pMove[0]);
        int col = Integer.parseInt(pMove[1]);
        board[row][col] = value;
    }

    void aiPlaceMove(AIplayer p, String[] pMove) {
        String value = p.getPiece();
        int row = Integer.parseInt(pMove[0]);
        int col = Integer.parseInt(pMove[1]);
        board[row][col] = value;
    }

    //Helper function  - checks to make sure row and column is in grid
    Boolean isValidMove(int r, int c) {
        if (r > 2 || c > 2 || r < 0 || c < 0) {
            return false;
        }
        return board[r][c].equals(" "); // checks if space is empty
    }


    //Helper function
    String getValue(int r, int c) {
        return board[r][c];
    }
}

class Player {
    String piece;
    String name;
    Scanner playerMove = new Scanner(System.in);

    Player(String s, String n) {
        piece = s;
        name = n;
    }

    String getPiece() {
        return piece;
    }

    String[] turn(TTT_board b) {
        System.out.println("Where would you like to go? (" + name + ")");
        System.out.println("(Type a row and a column, separated by a space, and hit enter.)");
        String userInput = playerMove.nextLine();

        // "2 2" ====> ["2", "2"]
        String[] thisMove = userInput.split(" ");

        while(!b.isValidMove(Integer.parseInt(thisMove[0]), Integer.parseInt(thisMove[1]))) {
            System.out.println("NOT A VALID MOVE, TRY AGAIN");
            userInput = playerMove.nextLine();
            thisMove = userInput.split(" ");
        }

        return thisMove;
    }
}

class AIplayer {
    String piece;
    String name;

    AIplayer(String s, String n) {
        piece = s;
        name = n;
    }

    String getPiece() {
        return piece;
    }

    String[] turn(TTT_board b) {
        /*
        QUESTION: This method should place a piece for the AI. (TODO: S.1.6)
         */
        String[] thisMove = new String[2];
        String myPiece = piece;
        String enemyPiece;
        if (piece.equals("X")) {
            enemyPiece = "O";
        } else {
            enemyPiece = "X";
        }

        if (isFirstTurn(b)) { // first move
            if (b.getValue(0, 0).equals(enemyPiece) || b.getValue(0, 2).equals(enemyPiece) ||
                    b.getValue(2, 2).equals(enemyPiece) || b.getValue(2, 0).equals(enemyPiece)) { // if enemy places in corner
                thisMove[0] = "1";
                thisMove[1] = "1";
            } else { // first move to see where to place if user doesn't go corner
                if (b.getValue(1, 0).equals(enemyPiece)) {
                    thisMove[0] = "1";
                    thisMove[1] = "2";
                } else if (b.getValue(1, 2).equals(enemyPiece)) {
                    thisMove[0] = "1";
                    thisMove[1] = "0";
                } else if (b.getValue(2, 1).equals(enemyPiece)) {
                    thisMove[0] = "0";
                    thisMove[1] = "1";
                } else if (b.getValue(0, 1).equals(enemyPiece)) {
                    thisMove[0] = "2";
                    thisMove[1] = "1";
                } else if (b.getValue(1, 1).equals(enemyPiece))  {
                    thisMove[0] = "0";
                    thisMove[1] = "2";
                } else { // if AI goes first
                    thisMove[0] = "0";
                    thisMove[1] = "0";
                }
            }
        } else { // all other moves (each if/else takes precedence over the other)
            if (isNextMoveWin(b)[0].equals("0") || isNextMoveWin(b)[0].equals("1") || isNextMoveWin(b)[0].equals("2")) { // checks if a win can happen now
                thisMove[0] = isNextMoveWin(b)[0];
                thisMove[1] = isNextMoveWin(b)[1];
            } else if (isNextMoveLose(b)[0].equals("0") || isNextMoveLose(b)[0].equals("1") || isNextMoveLose(b)[0].equals("2")) { // checks if a loss can be blocked
                thisMove[0] = isNextMoveLose(b)[0];
                thisMove[1] = isNextMoveLose(b)[1];
            } else if (b.getValue(0, 0).equals(myPiece) && b.getValue(2, 2).equals(myPiece) && !b.getValue(0, 2).equals(myPiece) && !b.getValue(0, 2).equals(enemyPiece)) { // if a forced win exists
                thisMove[0] = "0";
                thisMove[1] = "2";
            } else if (b.getValue(0, 0).equals(myPiece) && b.getValue(2, 2).equals(myPiece) && !b.getValue(2, 0).equals(myPiece) && !b.getValue(2, 0).equals(enemyPiece)) { // if a forced win exists
                thisMove[0] = "2";
                thisMove[1] = "0";
            } else if (b.getValue(0, 2).equals(myPiece) && b.getValue(2, 0).equals(myPiece) && !b.getValue(0, 0).equals(myPiece) && !b.getValue(0, 0).equals(enemyPiece)) { // if a forced win exists
                thisMove[0] = "0";
                thisMove[1] = "0";
            } else if (b.getValue(0, 2).equals(myPiece) && b.getValue(2, 0).equals(myPiece) && !b.getValue(2, 2).equals(myPiece) && !b.getValue(2, 2).equals(enemyPiece)) { // if a forced win exists
                thisMove[0] = "2";
                thisMove[1] = "2";
            } else {
                if (myPiece.equals("X")) {
                    return randoTurn(b);
                } else {
                    if (b.getValue(0, 0).equals(enemyPiece) && b.getValue(2, 2).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(1, 0).equals(enemyPiece) && !b.getValue(1, 0).equals(myPiece)) {
                        thisMove[0] = "1";
                        thisMove[1] = "0";

                    } else if (b.getValue(0, 2).equals(enemyPiece) && b.getValue(2, 0).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(1, 2).equals(enemyPiece) && !b.getValue(1, 2).equals(myPiece)) {
                        thisMove[0] = "1";
                        thisMove[1] = "2";

                    } else if (b.getValue(0, 0).equals(enemyPiece) && b.getValue(2, 1).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(1, 0).equals(enemyPiece) && !b.getValue(1, 0).equals(myPiece)) {
                        thisMove[0] = "1";
                        thisMove[1] = "0";

                    } else if (b.getValue(0, 0).equals(enemyPiece) && b.getValue(1, 2).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(0, 2).equals(enemyPiece) && !b.getValue(0, 2).equals(myPiece)) {
                        thisMove[0] = "0";
                        thisMove[1] = "2";

                    } else if (b.getValue(0, 2).equals(enemyPiece) && b.getValue(2, 1).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(2, 2).equals(enemyPiece) && !b.getValue(2, 2).equals(myPiece)) {
                        thisMove[0] = "2";
                        thisMove[1] = "2";

                    } else if (b.getValue(1, 0).equals(enemyPiece) && b.getValue(0, 2).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(0, 0).equals(enemyPiece) && !b.getValue(0, 0).equals(myPiece)) {
                        thisMove[0] = "0";
                        thisMove[1] = "0";

                    } else if (b.getValue(1, 0).equals(enemyPiece) && b.getValue(2, 2).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(2, 0).equals(enemyPiece) && !b.getValue(2, 0).equals(myPiece)) {
                        thisMove[0] = "2";
                        thisMove[1] = "0";

                    } else if (b.getValue(0, 1).equals(enemyPiece) && b.getValue(2, 2).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(0, 2).equals(enemyPiece) && !b.getValue(0, 2).equals(myPiece)) {
                        thisMove[0] = "0";
                        thisMove[1] = "2";

                    } else if (b.getValue(1, 2).equals(enemyPiece) && b.getValue(2, 0).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(2, 2).equals(enemyPiece) && !b.getValue(2, 2).equals(myPiece)) {
                        thisMove[0] = "2";
                        thisMove[1] = "2";

                    } else if (b.getValue(2, 0).equals(enemyPiece) && b.getValue(0, 1).equals(enemyPiece) && b.getValue(1, 1).equals(myPiece) && !b.getValue(0, 0).equals(enemyPiece) && !b.getValue(0, 0).equals(myPiece)) {
                        thisMove[0] = "0";
                        thisMove[1] = "0";

                    } else if (b.getValue(1, 1).equals(enemyPiece) && b.getValue(2, 0).equals(enemyPiece) && b.getValue(0, 2).equals(myPiece) && !b.getValue(2, 2).equals(enemyPiece) && !b.getValue(2, 2).equals(myPiece)) {
                        thisMove[0] = "2";
                        thisMove[1] = "2";
                    } else if (b.getValue(1, 1).equals(enemyPiece) && b.getValue(2, 1).equals(enemyPiece) && b.getValue(0, 1).equals(myPiece) && !b.getValue(0, 2).equals(enemyPiece) && !b.getValue(0, 2).equals(myPiece)) {
                        thisMove[0] = "0";
                        thisMove[1] = "2";
                    } else if (b.getValue(1, 0).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece) && b.getValue(1, 2).equals(myPiece) && !b.getValue(2, 2).equals(enemyPiece) && !b.getValue(2, 2).equals(myPiece)) {
                        thisMove[0] = "2";
                        thisMove[1] = "2";
                    } else if (b.getValue(0, 1).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece) && b.getValue(2, 1).equals(myPiece) && !b.getValue(2, 2).equals(enemyPiece) && !b.getValue(2, 2).equals(myPiece)) {
                        thisMove[0] = "2";
                        thisMove[1] = "2";
                    }  else if (b.getValue(1, 1).equals(enemyPiece) && b.getValue(1, 2).equals(enemyPiece) && b.getValue(1, 0).equals(myPiece) && !b.getValue(2, 0).equals(enemyPiece) && !b.getValue(2, 0).equals(myPiece)) {
                        thisMove[0] = "2";
                        thisMove[1] = "0";
                    } else {
                        return randoTurn(b);
                    }
                }
            }
        }
        return thisMove;
    }

    String[] randoTurn(TTT_board b) {
        System.out.println(name + "'s turn.");
        System.out.println("RANDO TURN");
        int row = (int) (Math.random() * 3);
        int col = (int) (Math.random() * 3);
        String[] thisMove = {Integer.toString(row),
                Integer.toString(col)};
        if (!randoTurnHelper(b)[0].equals("3")) {
            thisMove[0] = randoTurnHelper(b)[0];
            thisMove[1] = randoTurnHelper(b)[1];
        } else {
            while(!b.isValidMove(Integer.parseInt(thisMove[0]), Integer.parseInt(thisMove[1]))) {
//            System.out.println("A.I. CHOSE INVALID SPOT");
                row = (int) (Math.random() * 3);
                col = (int) (Math.random() * 3);
                thisMove[0] = Integer.toString(row);
                thisMove[1] = Integer.toString(col);

            }
        }

        return thisMove;
    }

    // blocks a move if it would cause a loss
    String[] isNextMoveLose (TTT_board b) { // checks to see if enemy has two pieces next to each other
        String[] thisMove2 = {"3", "3"};
        String enemyPiece;

        if (piece.equals("X")) {
            enemyPiece = "O";
        } else {
            enemyPiece = "X";
        }

        int count = -1; // if a position is taken this count allows for code to loop again to check to see if there is another spot
        boolean checking = true;

        while (checking) {
            if (count < 0 && ((b.getValue(0, 0).equals(enemyPiece) && b.getValue(0, 1).equals(enemyPiece)) ||
                    (b.getValue(2, 0).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece)) ||
                    (b.getValue(1, 2).equals(enemyPiece) && b.getValue(2, 2).equals(enemyPiece)))) {
                thisMove2[0] = "0";
                thisMove2[1] = "2";
                count = 0;
            } else if (count < 1 && ((b.getValue(0, 0).equals(enemyPiece) && b.getValue(1, 0).equals(enemyPiece)) ||
                    (b.getValue(2, 1).equals(enemyPiece) && b.getValue(2, 2).equals(enemyPiece)) ||
                    (b.getValue(0, 2).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece))))  {
                thisMove2[0] = "2";
                thisMove2[1] = "0";
                count = 1;
            } else if (count < 2 && ((b.getValue(0, 0).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece)) ||
                    (b.getValue(2, 0).equals(enemyPiece) && b.getValue(2, 1).equals(enemyPiece)) ||
                    (b.getValue(0, 2).equals(enemyPiece) && b.getValue(1, 2).equals(enemyPiece))))  {
                thisMove2[0] = "2";
                thisMove2[1] = "2";
                count = 2;
            } else if (count < 3 && ((b.getValue(1, 0).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece)) ||
                    (b.getValue(2, 2).equals(enemyPiece) && b.getValue(0, 2).equals(enemyPiece))))  {
                thisMove2[0] = "1";
                thisMove2[1] = "2";
                count = 3;
            } else if (count < 4 && ((b.getValue(1, 0).equals(enemyPiece) && b.getValue(2, 0).equals(enemyPiece)) ||
                    (b.getValue(0, 1).equals(enemyPiece) && b.getValue(0, 2).equals(enemyPiece)) ||
                    (b.getValue(2, 2).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece))))  {
                thisMove2[0] = "0";
                thisMove2[1] = "0";
                count = 4;
            } else if (count < 5 && ((b.getValue(0, 1).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece)) ||
                    (b.getValue(2, 0).equals(enemyPiece) && b.getValue(2, 2).equals(enemyPiece))))  {
                thisMove2[0] = "2";
                thisMove2[1] = "1";
                count = 5;
            } else if (count < 6 && ((b.getValue(2, 1).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece)) ||
                    (b.getValue(0, 0).equals(enemyPiece) && b.getValue(0, 2).equals(enemyPiece))))  {
                thisMove2[0] = "0";
                thisMove2[1] = "1";
                count = 6;
            } else if (count < 7 && ((b.getValue(0, 0).equals(enemyPiece) && b.getValue(2, 0).equals(enemyPiece)) ||
                    (b.getValue(1, 2).equals(enemyPiece) && b.getValue(1, 1).equals(enemyPiece))))  {
                thisMove2[0] = "1";
                thisMove2[1] = "0";
                count = 7;
            } else if (count < 8 && ((b.getValue(0, 0).equals(enemyPiece) && b.getValue(2, 2).equals(enemyPiece)) ||
                    (b.getValue(2, 0).equals(enemyPiece) && b.getValue(0, 2).equals(enemyPiece)) ||
                    (b.getValue(0, 1).equals(enemyPiece) && b.getValue(2, 1).equals(enemyPiece)) ||
                    (b.getValue(1, 0).equals(enemyPiece) && b.getValue(1, 2).equals(enemyPiece))))  {
                thisMove2[0] = "1";
                thisMove2[1] = "1";
                count = 8;
            } else {
                count = 8;
            }

            if (!thisMove2[0].equals("3")) {
                int move1 = Integer.parseInt(thisMove2[0]);
                int move2 = Integer.parseInt(thisMove2[1]);

                if (!b.getValue(move1, move2).equals("X") && !b.getValue(move1, move2).equals("O")) { // checks if spot is taken
                    checking = false;
                } else if (count < 0 || count == 8){
                    thisMove2[0] = "3";
                    thisMove2[1] = "3";
                    checking = false;
                }
            } else {
                checking = false;
            }
        }
        return thisMove2;
    }

    // places if next move is a win
    String[] isNextMoveWin (TTT_board b) { // checks to see if enemy has two pieces next to each other
        String[] thisMove2 = {"3", "3"};
        String myPiece = piece;
        int count = -1; // if a position is taken this count allows for code to loop again to check to see if there is another spot
        boolean checking = true;
        while (checking) {
            if (count < 0 && ((b.getValue(0, 0).equals(myPiece) && b.getValue(0, 1).equals(myPiece)) ||
                    (b.getValue(2, 0).equals(myPiece) && b.getValue(1, 1).equals(myPiece)) ||
                    (b.getValue(1, 2).equals(myPiece) && b.getValue(2, 2).equals(myPiece)))) {
                thisMove2[0] = "0";
                thisMove2[1] = "2";
                count = 0;
            } else if (count < 1 && ((b.getValue(0, 0).equals(myPiece) && b.getValue(1, 0).equals(myPiece)) ||
                    (b.getValue(2, 1).equals(myPiece) && b.getValue(2, 2).equals(myPiece)) ||
                    (b.getValue(0, 2).equals(myPiece) && b.getValue(1, 1).equals(myPiece))))  {
                thisMove2[0] = "2";
                thisMove2[1] = "0";
                count = 1;
            } else if (count < 2 && ((b.getValue(0, 0).equals(myPiece) && b.getValue(1, 1).equals(myPiece)) ||
                    (b.getValue(2, 0).equals(myPiece) && b.getValue(2, 1).equals(myPiece)) ||
                    (b.getValue(0, 2).equals(myPiece) && b.getValue(1, 2).equals(myPiece))))  {
                thisMove2[0] = "2";
                thisMove2[1] = "2";
                count = 2;
            } else if (count < 3 && ((b.getValue(1, 0).equals(myPiece) && b.getValue(1, 1).equals(myPiece)) ||
                    (b.getValue(2, 2).equals(myPiece) && b.getValue(0, 2).equals(myPiece))))  {
                thisMove2[0] = "1";
                thisMove2[1] = "2";
                count = 3;
            } else if (count < 4 && ((b.getValue(1, 0).equals(myPiece) && b.getValue(2, 0).equals(myPiece)) ||
                    (b.getValue(0, 1).equals(myPiece) && b.getValue(0, 2).equals(myPiece)) ||
                    (b.getValue(2, 2).equals(myPiece) && b.getValue(1, 1).equals(myPiece))))  {
                thisMove2[0] = "0";
                thisMove2[1] = "0";
                count = 4;
            } else if (count < 5 && ((b.getValue(0, 1).equals(myPiece) && b.getValue(1, 1).equals(myPiece)) ||
                    (b.getValue(2, 0).equals(myPiece) && b.getValue(2, 2).equals(myPiece))))  {
                thisMove2[0] = "2";
                thisMove2[1] = "1";
                count = 5;
            } else if (count < 6 && ((b.getValue(2, 1).equals(myPiece) && b.getValue(1, 1).equals(myPiece)) ||
                    (b.getValue(0, 0).equals(myPiece) && b.getValue(0, 2).equals(myPiece))))  {
                thisMove2[0] = "0";
                thisMove2[1] = "1";
                count = 6;
            } else if (count < 7 && ((b.getValue(0, 0).equals(myPiece) && b.getValue(2, 0).equals(myPiece)) ||
                    (b.getValue(1, 2).equals(myPiece) && b.getValue(1, 1).equals(myPiece))))  {
                thisMove2[0] = "1";
                thisMove2[1] = "0";
                count = 7;
            } else if (count < 8 && ((b.getValue(0, 0).equals(myPiece) && b.getValue(2, 2).equals(myPiece)) ||
                    (b.getValue(2, 0).equals(myPiece) && b.getValue(0, 2).equals(myPiece)) ||
                    (b.getValue(0, 1).equals(myPiece) && b.getValue(2, 1).equals(myPiece)) ||
                    (b.getValue(1, 0).equals(myPiece) && b.getValue(1, 2).equals(myPiece))))  {
                thisMove2[0] = "1";
                thisMove2[1] = "1";
                count = 8;
            } else {
                count = 8;
            }
            if (!thisMove2[0].equals("3")) {
                int move1 = Integer.parseInt(thisMove2[0]);
                int move2 = Integer.parseInt(thisMove2[1]);

                if (!b.getValue(move1, move2).equals("X") && !b.getValue(move1, move2).equals("O")) { // checks if spot is taken
                    checking = false;
                } else if (count < 0 || count == 8){
                    thisMove2[0] = "3";
                    thisMove2[1] = "3";
                    checking = false;
                }
            } else {
                checking = false;
            }
        }
        return thisMove2;
    }

    // stupid smart AI that attempts to make a win in 1 scenario
    String[] randoTurnHelper(TTT_board b) {
        String myPiece = piece;
        String[] position = {"3", "3"};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b.getValue(i,j).equals(myPiece)) {
                    if (i == 0) { // row 0
                        if (j == 0) { // col 0
                            if (b.getValue(0,1).equals(" ") && b.getValue(0,2).equals(" ")) {
                                position[0] = "0";
                                position[1] = "2";
                                i = 10; j = 10;
                            } else if (b.getValue(1,1).equals(" ") && b.getValue(2,2).equals(" ")) {
                                position[0] = "2";
                                position[1] = "2";
                                i = 10; j = 10;
                            } else if (b.getValue(1,0).equals(" ") && b.getValue(2,0).equals(" ")) {
                                position[0] = "2";
                                position[1] = "0";
                                i = 10; j = 10;
                            }
                        } else if (j == 1) { // col 1
                            if (b.getValue(1,1).equals(" ") && b.getValue(2,1).equals(" ")) {
                                position[0] = "1";
                                position[1] = "1";
                                i = 10; j = 10;
                            } else if (b.getValue(0,0).equals(" ") && b.getValue(0,2).equals(" ")) {
                                position[0] = "0";
                                position[1] = "2";
                                i = 10; j = 10;
                            }
                        } else if (j == 2) { // col 2
                            if (b.getValue(0,1).equals(" ") && b.getValue(0,0).equals(" ")) {
                                position[0] = "0";
                                position[1] = "0";
                                i = 10; j = 10;
                            } else if (b.getValue(1,1).equals(" ") && b.getValue(2,0).equals(" ")) {
                                position[0] = "2";
                                position[1] = "0";
                                i = 10; j = 10;
                            } else if (b.getValue(2,2).equals(" ") && b.getValue(1,2).equals(" ")) {
                                position[0] = "2";
                                position[1] = "2";
                                i = 10; j = 10;
                            }
                        }
                    } else if (i == 1) { // row 1
                        if (j == 0) { // col 0
                            if (b.getValue(0,0).equals(" ") && b.getValue(2,0).equals(" ")) {
                                position[0] = "2";
                                position[1] = "0";
                                i = 10;
                                j = 10;
                            } else if (b.getValue(1,1).equals(" ") && b.getValue(1,2).equals(" ")) {
                                position[0] = "1";
                                position[1] = "1";
                                i = 10;
                                j = 10;
                            }
                        } else if (j == 1) { // col 1
                            if (b.getValue(1,0).equals(" ") && b.getValue(1,2).equals(" ")) {
                                position[0] = "1";
                                position[1] = "0";
                                i = 10;
                                j = 10;
                            } else if (b.getValue(2,0).equals(" ") && b.getValue(0,2).equals(" ")) {
                                position[0] = "2";
                                position[1] = "0";
                                i = 10;
                                j = 10;
                            } else if (b.getValue(0,0).equals(" ") && b.getValue(2,2).equals(" ")) {
                                position[0] = "2";
                                position[1] = "2";
                                i = 10;
                                j = 10;
                            } else if (b.getValue(0,1).equals(" ") && b.getValue(2,1).equals(" ")) {
                                position[0] = "0";
                                position[1] = "1";
                                i = 10;
                                j = 10;
                            }
                        } else if (j == 2) { // col 2
                            if (b.getValue(0, 2).equals(" ") && b.getValue(2, 2).equals(" ")) {
                                position[0] = "0";
                                position[1] = "2";
                                i = 10;
                                j = 10;
                            } else if (b.getValue(1, 1).equals(" ") && b.getValue(1, 0).equals(" ")) {
                                position[0] = "1";
                                position[1] = "1";
                                i = 10;
                                j = 10;
                            }
                        }
                    } else if (i == 2) { // row 2
                        if (j == 0) { // col 0
                            if (b.getValue(1,1).equals(" ") && b.getValue(0,2).equals(" ")) {
                                position[0] = "0";
                                position[1] = "2";
                                i = 10; j = 10;
                            } else if (b.getValue(1,0).equals(" ") && b.getValue(0,0).equals(" ")) {
                                position[0] = "0";
                                position[1] = "0";
                                i = 10; j = 10;
                            } else if (b.getValue(2,1).equals(" ") && b.getValue(2,2).equals(" ")) {
                                position[0] = "2";
                                position[1] = "2";
                                i = 10; j = 10;
                            }
                        } else if (j == 1) { // col 1
                            if (b.getValue(1,1).equals(" ") && b.getValue(0,1).equals(" ")) {
                                position[0] = "1";
                                position[1] = "1";
                                i = 10; j = 10;
                            } else if (b.getValue(2,0).equals(" ") && b.getValue(2,2).equals(" ")) {
                                position[0] = "2";
                                position[1] = "0";
                                i = 10; j = 10;
                            }
                        } else if (j == 2) { // col 2
                            if (b.getValue(0,2).equals(" ") && b.getValue(1,2).equals(" ")) {
                                position[0] = "0";
                                position[1] = "2";
                                i = 10; j = 10;
                            } else if (b.getValue(1,1).equals(" ") && b.getValue(0,0).equals(" ")) {
                                position[0] = "0";
                                position[1] = "0";
                                i = 10; j = 10;
                            } else if (b.getValue(2,0).equals(" ") && b.getValue(2,1).equals(" ")) {
                                position[0] = "2";
                                position[1] = "0";
                                i = 10; j = 10;
                            }
                        }
                    }
                }
            }
        }
        return position;
    }

    // Helper function - allows for a specific lines of code to only be executed on the AI's first turn
    Boolean isFirstTurn (TTT_board b) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b.getValue(i,j).equals("X") || b.getValue(i,j).equals("O")) {
                    count++;
                }
            }
        }
        if (count < 2) {
            return true;
        } else {
            return false;
        }
    }
}
