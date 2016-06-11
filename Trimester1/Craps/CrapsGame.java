// Implements the game of Craps logic

public class CrapsGame
{
    private int point = 0;

    private enum GameState {NEW_ROLL, KEEP_ROLLING};
    private GameState currState = GameState.NEW_ROLL;

    /**
     *  Calculates the result of the next dice roll in the Craps game.
     *  The parameter total is the sum of dots on two dice.
     *  point is set to the saved total, if the game continues,
     *  or 0, if the game has ended.
     *  Returns 1 if player won, -1 if player lost,
     *  0 if player continues rolling.
     */
    public int processRoll(int total)
    {
        int rv;  
        switch (currState) {
            case NEW_ROLL:
            if (total == 7 || total == 11) rv = 1;
            else if (total == 2 || total == 3 || total == 12) rv = -1;
            else {
                point = total;
                currState = GameState.KEEP_ROLLING;
                rv = 0;
                break;
            }
            default:
            if (total == point) {
                //player wins, reset point to 0
                point = 0;
                currState = GameState.NEW_ROLL;
                rv = 1;
            }
            else if (total == 7) {
                //player loses, reset point to 0
                point = 0;
                currState = GameState.NEW_ROLL;
                rv = -1;
            }
            else {
                //game continues with point
                rv = 0;
            }
        }
        return rv;
    }

    /**
     *  Returns the saved point
     */
    public int getPoint()
    {
        return point;
    }
}

