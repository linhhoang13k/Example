    /*Your friend is a soccer fan and you were watching some World Cup matches with him. You liked this game, but the rules are very complicated for you, so you decided just to try to guess whether the given attack will end with a goal or not.

In the beginning, the ball is in the attacking team's goalkeeper's hands. On the attacking team, there's a very talented goalscorer, who is waiting for his chance at the other end of the field. His teammates want to give him the ball so he can score. They can move the ball by passing it one to another along a straight line, but the defender can steal the pass if he is closer than d to the ball at any point throughout the pass. Now you want to know if the attacking team can score or not.

Formally, you are given the coordinates of all attacking players in an array attackingPlayers (where the player at index 0 is the goalkeeper and the player at the final index is the goalscorer), the coordinates of all defending players in an array defendingPlayers, and an integer d (representing how far each defending player can reach in order to intercept a pass). You need to find out whether it is possible to score a goal by passing the ball to the best scorer without any passes being intercepted.

Example

    For attackingPlayers = [[0, 0], [1, 2], [3, 1]], defendingPlayers = [[2, 1]] and d = 1, the output should be canScore(attackingPlayers, defendingPlayers, d) = false.

    Attacking player 0 can pass to attacking player 1 without the pass being intercepted, but neither attacking player 0 nor attacking player 1 can pass to attacking player 2 (the goal scorer), so the goal cannot be completed.

    For attackingPlayers = [[0, 0], [1, 2], [3, 3], [3, 1]], defendingPlayers = [[2, 1]] and d = 1, the output should be canScore(attackingPlayers, defendingPlayers, d) = true.

    The goal can be scored if the ball is passed from attacking players 0 to 1 to 2 to 3.

    For attackingPlayers = [[1, 2], [5, 3], [4, -2], [8, 0], [8, 6]], defendingPlayers = [[4, 4], [1, -1], [9, 2]] and d = 2, the output should be canScore(attackingPlayers, defendingPlayers, d) = true.

    The goal can be scored if the ball is passed from attacking players 0 to 3 to 2 to 4.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.array.integer attackingPlayers

    An array of coordinates of all players from the attacking team. The first one is the goalkeeper's coordinates and the last one is the best goalscorer's coordinates.

    Guaranteed constraints:
    2 ≤ attackingPlayers.length ≤ 100
    attackingPlayers[i].length = 2
    -104 ≤ attackingPlayers[i][j] ≤ 104

    [input] array.array.integer defendingPlayers

    An array of coordinates of all players from the defending team.

    Guaranteed constraints:
    1 ≤ defendingPlayers.length ≤ 100
    defendingPlayers[i].length = 2
    -104 ≤ defendingPlayers[i][j] ≤ 104,

    [input] integer d

    The distance that each defending player can reach in intercepting a pass.

    Guaranteed constraints:
    0 ≤ d ≤ 104

    [output] boolean

    True if attacking team can score a goal, False otherwise
    */


boolean canScore(int[][] attackingPlayers, int[][] defendingPlayers, int d) {
  Game game = new Game(attackingPlayers, defendingPlayers, d);
  return game.canScore();
}

class Game {
  final int[][] attackingPlayers;
  final int[][] defendingPlayers;
  final int d;
  
  Game(int[][] attackingPlayers, int[][] defendingPlayers, int d) {
    this.attackingPlayers = attackingPlayers;
    this.defendingPlayers = defendingPlayers;
    this.d = d;
  }
  
  boolean canPass(int i, int j) {
    if (i == j) {
      return false;
    }
    int x1 = attackingPlayers[i][0];
    int y1 = attackingPlayers[i][1];
    int x2 = attackingPlayers[j][0];
    int y2 = attackingPlayers[j][1];
    for (int[] defendingPlayer : defendingPlayers) {
      if (pDistance(defendingPlayer[0], defendingPlayer[1], x1, y1, x2, y2) < d) {
        return false;
      }
    }
    return true;
  }
  
  boolean canScore() {
    boolean canReach[] = new boolean[attackingPlayers.length];
    canReach[0] = true;
    
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.push(0);    
    
    while (!queue.isEmpty()) {
      int from = queue.pop();
      for (int to = 0; to < attackingPlayers.length; to++) {
        if (!canReach[to] && canPass(from, to)) {
          canReach[to] = true;
          queue.push(to);
          
          if (to == attackingPlayers.length - 1) return true; // reached scorer
        }
      }
    }
   
    return false;
  }
}

public double pDistance(double x, double y, double x1, double y1, double x2, double y2) {
  double A = x - x1;
  double B = y - y1;
  double C = x2 - x1;
  double D = y2 - y1;

  double dot = A * C + B * D;
  double len_sq = C * C + D * D;
  double param = -1;
  if (len_sq != 0) //in case of 0 length line
      param = dot / len_sq;

  double xx, yy;

  if (param < 0) {
    xx = x1;
    yy = y1;
  }
  else if (param > 1) {
    xx = x2;
    yy = y2;
  }
  else {
    xx = x1 + param * C;
    yy = y1 + param * D;
  }

  double dx = x - xx;
  double dy = y - yy;
  return Math.sqrt(dx * dx + dy * dy);
}
