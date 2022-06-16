# Connect Four

## *Gregory L*

**Connect Four** A classic game where the main goal of the game is to form a line of four discs of the same color horizontally,
vertically, or diagonally.
This project is creating a software version of this game. Typically, the game board has 6 rows and 7 columns,
but in this version, the number of rows and columns can vary from 5 to 9.

## Objectives

The following **required** Objectives are completed:


### Stage 1


* [X] The program prints the program title ```Connect Four```, asks for the 1st player's name with the prompt 
  ```First player's name:```, and read it.
  Then it asks for the 2nd player's name with the prompt ```Second player's name:``` and read it.


* [X] Subsequently, the program asks for the board dimensions with the following prompt:
  ```
  Set the board dimensions (Rows x Columns)
  Press Enter for default (6 x 7)
  ```


* [X] Once the dimensions are entered, it reads them. Ignores any whitespaces.
  If users press the Enter button right away (ignoring the dimension prompt), then the board size is 6 rows and 7 columns.


* [X] If the number of rows is outside the 5-9 range, prints the following message 
```Board rows should be from 5 to 9```
  and asks for dimensions once again.


* [X] If the number of columns is outside the 5-9 range,
  prints the following message ```Board columns should be from 5 to 9``` and ask for dimensions once again.


* [X] If users fail to input dimensions in the correct format, prints ```Invalid input``` and ask for dimensions once again.


* [X] Finally, output the following message:
    ```
   <1st player's name> VS <2nd players name>
   <Rows> X <Columns> board
    ```

### Stage 2


* [X] Draws the game board, constructing a board in the manner shown in the following example for a 7x8 board:
  ```
   1 2 3 4 5 6 7 8
  | | | | | | | | |
  | | | | | | | | |
  | | | | | | | | |
  | | | | | | | | |
  | | | | | | | | |
  | | | | | | | | |
  | | | | | | | | |
  =================
  ```
  The board size can vary, so the program is adapting to any possible size.


* [X] Prints the column numbers on the board. Minding the spaces between characters.


### Stage 3

* [X] In the classic game players use red and yellow colored discs in the "hardware" version of the game. In this project, 
I'm going to substitute them with ```o``` and ```*``` characters. The ```o``` is for the first player.


* [X] Each player inputs a column number one after another. 
The program reads the input and prints the appropriate character ( ```o``` or ```*```) 
on the first available position at the bottom of that column. 
If the user input isn't correct, prints the appropriate message and ask for a new one. 
The program also check whether a column is full or not. 
If it is, no more discs can be added to it.


* [X] Asks each player to input a column number by prompting ```<First player's name>'s turn:``` or ```<Second player's name>'s turn:```.
  Reads the column number and prints ```o``` or ```*``` on the first available position of that column. The first player is ```o```;
  the second player is ```*```.


* [X] If players input end instead of a column number, the program terminates and prints the respective message.


* [X] If the input contains an integer number outside the scope of available columns, warns the players with the 
```The column number is out of range (1 - <Max column number>)``` message and ask for it once again. If players' input doesn't contain an integer, 
warn the players with ```Incorrect column number``` and ask for it once again.


### Stage 4


* [ ] Checks the board for the winning condition. If a player wins, outputs Player ```<Player's name>``` won.


* [ ] If the board is full, but neither of the players has won, prints ```It is a draw```.


* [ ] Regardless of whether it is a draw or somebody's victory, prints ```Game Over!``` and terminates the program.