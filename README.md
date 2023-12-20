JAVA FX fighting game:

This project is complete
This program is a Java FX java app that was developed as the final project for my Object-oriented Programming course in the Spring of 2023. 
The program itself is a graphic user interface that allows you to create up to 50 characters and fight them against each other.

To run this program you will need to have Java fx set up in your IDE for the graphic user interface to run. 

Understanding the files:
        1. The fighting Game final fx: The main fx file that starts the game window when you run the program and calls the start menu
        2. Start menu package: This package consists of the start menu fxml design and the fxml controller with button controls to call the add character window
        3. Add character package: This package consists of the add character fxml design, fxml controller, and the same for the stats and error message window. This window is called from either the main menu or the start menu when the program first begins. The add character window will allow you to create the character stats, and powers, and add them to the saved characters.
        4. Add powers package: This consists of the add powers fxml design window and fxml controller for that window. This window is opened when a user creates a character with powers or when thre user wants to give a saved character more powers.
        5. Main menu package: This package consists of the main menu fxml window and fxml controller for that window. This is the main window of the game that allows you to add characters, see saved characters, whether they are villains or heroes, see a fighter's stats, search for a fighter, give new power to a saved fighter, and finally the fight function to compare two characters. 
        6. Fight character select package: This package is used to display the heroes, villains, or full character display. When the full character display is called for the fight function it will allow the user to select two characters to fight against each other.
        7. Fight package: this package contains the fight xml and controller that takes the two selected characters and simulates the results of a battle to display who won based on which character has more total power. 
