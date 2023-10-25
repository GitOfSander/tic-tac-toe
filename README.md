# Rock paper scissors
Tic tac toe game programmed with Java while following the Introduction to Java course from the Jetbrains Academy on Hyperskill.

# Overview
The program works as described in the following step-by-step guide:

1. Player X starts and can enter the coordinates. The program will validate if these coordinates are possible.
2. After each turn a overview of the game will be printed.
3. Player O starts and can enter the coordinates.
4. Step 1 till 3 will repeat till there is a winner or draw.

<pre>
Player X can input the coordinates:
1 2
---------
|   X   |
|       |
|       |
---------


Player O can input the coordinates:
1 1
---------
| O X   |
|       |
|       |
---------


Player X can input the coordinates:
3 2
---------
| O X   |
|       |
|   X   |
---------


Player O can input the coordinates:
2 1
---------
| O X   |
| O     |
|   X   |
---------


Player X can input the coordinates:
2 2
---------
| O X   |
| O X   |
|   X   |
---------

X wins
</pre>

# Usage
Download the release and go in your terminal where you placed tic-tac-toe.jar and run:

<pre>java -jar tic-tac-toe.jar</pre>