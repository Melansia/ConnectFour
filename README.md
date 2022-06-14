# Connect Four

## *Gregory L*

**Connect Four** A classic game where the main goal of the game is to form a line of four discs of the same color horizontally,
vertically, or diagonally.
This project is creating a software version of this game. Typically, the game board has 6 rows and 7 columns,
but in this version, the number of rows and columns can vary from 5 to 9.

## Objectives

The following **required** Objectives are completed:


### Stage 1

* [X] The program prints the program title ```Connect Four```, asks for the 1st player's name with the prompt ```First player's name:```, and read it.
  Then it asks for the 2nd player's name with the prompt ```Second player's name:``` and read it.


* [X] Subsequently, the program asks for the board dimensions with the following prompt:
  ```
  Set the board dimensions (Rows x Columns)
  Press Enter for default (6 x 7)
  ```


* [X] Once the dimensions are entered, it reads them. Ignores any whitespaces.
  If users press the Enter button right away (ignoring the dimension prompt), then the board size is 6 rows and 7 columns.


* [X] If the number of rows is outside the 5-9 range, prints the following message ```Board rows should be from 5 to 9```
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

* [X] When the user inputs the command hide, the program prompt them for an input image filename with the message "Input image file:"
  and an output image filename with the message "Output image file:".
  These are used for reading the input image file and writing the output image file, respectively.


* [X] After reading the filenames, the program prints the following messages:
  Input Image: [input filename] and Output Image: [output filename].


* [X] When the input image is read, the least significant bit for each color (Red, Green, and Blue) is set to 1.
  The resulting image will be saved with the provided output image filename in the PNG format.


* [X] A proper method is applied so that the I/O exceptions do not terminate the program.
  In such cases, an exception message should be printed and the program should return to the command loop.

### Stage 3

* [X] When the hide command is given, the program gets the input and output image filenames.
  Then, it prompts the user for the secret message by printing "Message to hide:".


* [X] The program is checking that the image size is adequate for holding the Bytes array.
  If not, it prints an error message with the text "The input image is not large enough to hold this message."
  and return to the menu.


* [X] Each bit of this Bytes Array is saved at the position of the least significant bit of the blue color of each pixel,
  The output image is saved in the PNG format.


* [X] When the "show" command is given, the program asks for the image filename
  (previously saved with the hidden message) by printing "Input image file:".
  The image is opened and the Bytes Array is reconstructed bit by bit;
  the program stops reading it when the bytes with the values 0, 0, 3 are encountered.


* [X] The last 3 bytes (values 0, 0, 3) are removed from the end of the Bytes Array.
  Then, the message is restored as a String from the Bytes Array (or 00000000 00000000 00000011 bits).
  The program then prints "Message:" and then the message itself on a new line.

### Stage 4

* [X] When the hide command is given and the secret message is input,
  the user is prompted for a password with the message "Password:".


* [X] The program reads the password string and converts it to a Bytes Array.
  The first message byte will be XOR encrypted using the first password byte,
  the second message byte will be XOR encrypted with the second password byte, and so on.
  If the password is shorter than the message, then after the last byte of the password,
  the first byte of the password is used again.


* [X] Three Bytes with values 0, 0, 3 are added to the encrypted Bytes Array.
  If the image size is adequate for holding the Bytes array, the result is hidden in the image like in the previous stage.


* [X] When the show command is given and the filename is input,
  the user is prompted for the password with the message "Password:".
  The image is open and the encrypted Bytes Array are reconstructed ,
  the program stops reading it when the bytes with the values 0, 0, 3 are found.
  The last three bytes are removed and the encrypted Bytes Array are decrypted using the password.


* [X] Finally, the message is restored to the String type, and the program prints "Message:" and then the message itself on a new line.