package opponents;
import game.GameController;
import game.TicTacToePlayer;

import java.sql.SQLOutput;

//suchir and akash
//fatherless and DEFINITELY more fatherless than our roller coaster
public class YogeshSlayer extends TicTacToePlayer {

    boolean centerFirstO = false;
    boolean winPossibilityO = false;

    public YogeshSlayer(String name, int piece) {
        super(name, piece);
    }

    public String getBoardLayout() {
        String bl = "";
        int[][] board = GameController.game.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                bl += board[i][j] + "";
            }
        }

        return bl;
    }

    //practically hard coding everything to make an unbeatable bot
    public int[] playTurn() {
        int[] move = new int[]{-1, -1};
        int[][] board = GameController.game.getBoard();

        //if our bot is X (first player)
        if (getPiece() == 1) {

            //turn #1 place X on bottom right corner
            if (GameController.getTurnCount() == 0) {
                move[0] = 2;
                move[1] = 2;
            } else if (GameController.getTurnCount() == 2) {
                //if in the center move to upper right corner
                if (board[1][1] == 2) {
                    move[0] = 0;
                    move[1] = 2;
                }
                //if in the upper or lower left corner move to the upper right corner
                else if (board[0][0] == 2 || board[2][0] == 2) {
                    move[0] = 0;
                    move[1] = 2;
                }
                //if in the upper right corner move to the lower left corner
                else if (board[0][2] == 2) {
                    move[0] = 2;
                    move[1] = 0;
                }
                //if on any edge move to upper right corner
                else if (board[1][0] == 2 || board[0][1] == 2 || board[2][1] == 2 || board[1][2] == 2) {
                    move[0] = 0;
                    move[1] = 2;
                }
            } else if (GameController.getTurnCount() == 4) {
                //if placed on center for second move
                if (board[1][1] == 2 && board[0][2] == 1) {
                    //if placed on any edge except [1][2]
                    if (board[1][0] == 2 || board[0][1] == 2 || board[2][1] == 2) {
                        move[0] = 1;
                        move[1] = 2;
                    }
                    //if placed on [1][2]
                    else if (board[1][2] == 2) {
                        move[0] = 1;
                        move[1] = 0;
                    }
                    //if placed on upper or lower left corner
                    else if (board[0][0] == 2 || board[2][0] == 2) {
                        move[0] = 1;
                        move[1] = 2;
                    }
                }
                //if in the upper or lower left corner for second move
                else if (board[0][0] == 2 || board[2][0] == 2 && board[0][2] == 1) {
                    //if it moves on any edge except [1][2]
                    if (board[1][0] == 2 || board[0][1] == 2 || board[2][1] == 2) {
                        move[0] = 1;
                        move[1] = 2;
                    }
                    //if placed on [1][2]
                    else if (board[1][2] == 2) {
                        if (board[2][0] == 0) {
                            move[0] = 2;
                            move[1] = 0;
                        } else {
                            move[0] = 0;
                            move[1] = 0;
                        }
                    } else {
                        move[0] = 1;
                        move[1] = 2;
                    }
                }
                //if the second move was to the upper right corner
                else if (board[0][2] == 2) {
                    //if [2][1] is empty then move there to win
                    if (board[2][1] == 0) {
                        move[0] = 2;
                        move[1] = 1;
                    } else {
                        move[0] = 0;
                        move[1] = 0;
                    }
                }
            } else if (GameController.getTurnCount() == 6) {
                //if placed on center for second move
                if (board[1][1] == 2 && board[0][2] == 1) {
                    //if placed on [1][2] for 4th move
                    if (board[1][2] == 2) {
                        //if placed on upper left corner
                        if (board[0][0] == 2) {

                            move[0] = 0;
                            move[1] = 1;
                        }
                        //if placed on lower left corner
                        else if (board[2][0] == 2) {
                            move[0] = 2;
                            move[1] = 1;
                        }
                        //if placed on upper middle edge
                        else if (board[0][1] == 2) {
                            move[0] = 2;
                            move[1] = 1;
                        }
                        //if placed on lower middle edge
                        else if (board[2][1] == 2) {
                            move[0] = 0;
                            move[1] = 1;
                        }
                    }
                }
                //if in the upper or lower left corner for second move
                else if (board[0][0] == 2 || board[2][0] == 2) {
                    //if placed on [1][2] for 4th move
                    if (board[1][2] == 2) {
                        //if there is an X at [2][0]
                        if (board[2][0] == 1) {
                            //if there's an O at [2][1]
                            if (board[2][1] == 2) {
                                move[0] = 1;
                                move[1] = 1;
                            } else {
                                move[0] = 2;
                                move[1] = 1;
                            }
                        }
                        //if there is an X at [0][0]
                        else if (board[0][0] == 1) {
                            //if there's an O at [0][1]
                            if (board[0][1] == 2) {
                                move[0] = 1;
                                move[1] = 1;
                            } else {
                                move[0] = 0;
                                move[1] = 1;
                            }
                        }
                    }
                }
            } else if (GameController.getTurnCount() == 8) {
                //if placed on center for second move
                if (board[1][1] == 2 && board[0][2] == 1) {
                    //if placed on [1][2] for 4th move
                    if (board[1][2] == 2) {
                        //if placed on upper left corner
                        if (board[0][0] == 2) {
                            if (board[2][0] == 2) {
                                move[0] = 2;
                                move[1] = 1;
                            } else {
                                move[0] = 2;
                                move[1] = 0;
                            }
                        }
                        //if placed on lower left corner
                        else if (board[2][0] == 2) {

                            move[0] = 0;
                            move[1] = 0;
                        }
                        //if placed on upper middle edge
                        else if (board[0][1] == 2) {
                            move[0] = 2;
                            move[1] = 1;
                        }
                        //if placed on lower middle edge
                        else if (board[2][1] == 2) {
                            move[0] = 0;
                            move[1] = 1;
                        }
                    }
                }
            }
        } else if (getPiece() == 2) {
            //Turn 1
            if (GameController.getTurnCount() == 1) {
                //If player 1 places X in the center, O goes in the bottom right corner
                if (board[1][1] == 1) {
                    move[0] = 2;
                    move[1] = 2;
                    centerFirstO = true;
                }
                //If player 1 places X anywhere but the center, O goes in the center
                else {
                    move[0] = 1;
                    move[1] = 1;
                }
            }
            //Turn 2
            else if (GameController.getTurnCount() == 3) {
                //Two edges
                if ((board[1][0] == 1 && board[1][2] == 1) || (board[2][1] == 1 && board[0][1] == 1)) {
                    move[0] = 2;
                    move[1] = 2;
                    winPossibilityO = true;
                }
                //Center + edge or corner
                else if (centerFirstO) {
                    if (board[0][1] == 1) {
                        move[0] = 2;
                        move[1] = 1;
                    } else if (board[0][2] == 1) {
                        move[0] = 2;
                        move[1] = 0;
                    } else if (board[1][0] == 1) {
                        move[0] = 1;
                        move[1] = 2;
                    } else if (board[1][2] == 1) {
                        move[0] = 1;
                        move[1] = 0;
                    } else if (board[2][0] == 1 || board[0][0] == 1) {
                        move[0] = 0;
                        move[1] = 2;
                    } else if (board[2][1] == 1) {
                        move[0] = 0;
                        move[1] = 1;
                    }
                } else {
                    //Two corners
                    if (getBoardLayout().equals("001020001")) {
                        move[0] = 1;
                        move[1] = 2;
                    } else if (getBoardLayout().equals("100020100")) {
                        move[0] = 1;
                        move[1] = 0;

                    } else if (getBoardLayout().equals("101020000")) {
                        move[0] = 0;
                        move[1] = 1;
                    } else if (getBoardLayout().equals("000020101")) {
                        move[0] = 2;
                        move[1] = 1;
                    } else if (getBoardLayout().equals("100020001")) {
                        move[0] = 1;
                        move[1] = 0;
                    }
                    //Corner + edge
                    else if (getBoardLayout().equals("110020000") || getBoardLayout().equals("000021001")) {
                        move[0] = 0;
                        move[1] = 2;
                    } else if (getBoardLayout().equals("000120100") || getBoardLayout().equals("011020000")) {
                        move[0] = 0;
                        move[1] = 0;
                    } else if (getBoardLayout().equals("000020110") || getBoardLayout().equals("001021000")) {
                        move[0] = 2;
                        move[1] = 2;
                    } else if (getBoardLayout().equals("100120000") || getBoardLayout().equals("000020011")) {
                        move[0] = 2;
                        move[1] = 0;
                    }
                }

            }
            //Turn 3
            else if (GameController.getTurnCount() == 5) {
                if (winPossibilityO) {
                    if (board[0][2] == 0) {
                        move[0] = 0;
                        move[1] = 2;
                    }
                    if (getBoardLayout().equals("011020210")) {
                        move[0] = 0;
                        move[1] = 0;
                    } else if (getBoardLayout().equals("001121100")) {
                        ;
                        move[0] = 2;
                        move[1] = 2;
                    }
                } else {
                    //Center first
                    if (getBoardLayout().equals("102011002") || getBoardLayout().equals("002011102") || getBoardLayout().equals("020011012")) {
                        ;
                        move[0] = 1;
                        move[1] = 0;
                    } else if (getBoardLayout().equals("010010122") || getBoardLayout().equals("000211102") || getBoardLayout().equals("120010012") || getBoardLayout().equals("020010112")) {
                        move[0] = 0;
                        move[1] = 2;
                    } else if (getBoardLayout().equals("001010212") || getBoardLayout().equals("000211012")) {
                        move[0] = 0;
                        move[1] = 1;
                        ;
                    } else if (getBoardLayout().equals("001112002") || getBoardLayout().equals("100211002") || getBoardLayout().equals("001211002") || getBoardLayout().equals("021010012")) {
                        move[0] = 2;
                        move[1] = 0;
                    } else if (getBoardLayout().equals("010211002")) {
                        move[0] = 2;
                        move[1] = 1;
                    } else if (getBoardLayout().equals("020110012")) {
                        move[0] = 1;
                        move[1] = 2;
                    }

                    //Edge or corner first
                    else if (getBoardLayout().equals("121020010") || getBoardLayout().equals("021122001") || getBoardLayout().equals("100020112")) {
                        move[0] = 1;
                        move[1] = 0;
                    } else if (getBoardLayout().equals("100221100") || getBoardLayout().equals("010020121") ||
                            getBoardLayout().equals("112020100") || getBoardLayout().equals("101120200") ||
                            getBoardLayout().equals("002021121") || getBoardLayout().equals("101021002")) {
                        move[0] = 0;
                        move[1] = 1;
                    } else if (getBoardLayout().equals("211020001") || getBoardLayout().equals("001020211")) {
                        move[0] = 1;
                        move[1] = 2;
                    } else if (getBoardLayout().equals("200120101")) {
                        move[0] = 2;
                        move[1] = 1;
                    } else if (getBoardLayout().equals("101021002")) {

                    }

                }
            }
            //Turn 4
            else if (GameController.getTurnCount() == 7) {
                if (getBoardLayout().equals("211020211") || getBoardLayout().equals("012011122")) {
                    move[0] = 1;
                    move[1] = 0;
                } else if (getBoardLayout().equals("211120210")) {
                    move[0] = 2;
                    move[1] = 2;
                } else if (getBoardLayout().equals("101121202")) {
                    move[0] = 2;
                    move[1] = 1;
                } else if (getBoardLayout().equals("001121212")) {
                    move[0] = 0;
                    move[1] = 0;
                } else if (getBoardLayout().equals("102211102") || getBoardLayout().equals("102211012")) {
                    move[0] = 0;
                    move[1] = 1;
                } else if (getBoardLayout().equals("112211002")) {
                    move[0] = 2;
                    move[1] = 0;
                } else if (getBoardLayout().equals("121010212") || getBoardLayout().equals("021110212")) {
                    move[0] = 0;
                    move[1] = 2;
                } else {
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                            if (board[i][j] == 0) {
                                move[0] = i;
                                move[1] = j;
                            }

                        }

                    }
                }
            }

        }
        return move;
    }
}

