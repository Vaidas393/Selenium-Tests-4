# Selenium Assignment

This project is for educational purposes only. Pull request are welcome! Thank you for your cooperation!

## Requirements
- Google Chrome Version 94 (if you are using different chrome version you need download and replace chromedriver.exe file inside driver folder) download link for drivers (https://chromedriver.chromium.org/downloads)
- Java SE Development Kit ([Download]( https://www.oracle.com/java/technologies/javase-jdk15-downloads.html))
- IntelliJ IDEA ([Download]( https://www.jetbrains.com/idea/download/#section=windows))
- Eclipse IDE ([Download]( https://www.eclipse.org/downloads/))
- Another IDE with Java support

## Setup
I prefer Eclipse IDE so example is done using Eclipse
- Install Eclipse IDE
- Once launched Eclipse IDE install TestNG Plugin
- Tutorial: https://www.youtube.com/watch?v=yAzLc0xz0l4

## Usage
- Download folder or clone using GIT
- Import Maven project in Eclipse
- Run ```testng.xml``` file to start test. (Run As TestNG Suite)
- Tutorial: https://vimeo.com/614728596

## Additional comments:
- AddRemove tests:
- AddButtons
- 1)Adds chosen number of buttons
- 2)Prints out number of added AddButtons
- 3)Assert checks if buttons were Added
- RemoveButtons
- 1)Removes chosen number of AddButtons
- 2)Prints out message that buttons removed
- 3)Assert checks elemnts Div size to check if all buttons there remowed

- Checkboxes tests:
- SelectCheckboxes
- 1)Counts number of checkboxes available
- 2)Loops trough number of boxes available and selects all chexboxes
- 3)Assert confirms that all boxes are selected
- UnselectCheckboxes
- 1)Counts number of checkboxes available
- 2)Loops trough number of boxes available and unselects all chexboxes
- 3)Assert confirms that all boxes are unselected

- Dropdown test:
- 1)Method accepts variables so user can enter which select option to choose
- 2)Assert checks if right option selected (chosen option needs to be inserted manually)

- Hower test:
- 1)Howers selected image
- 2)Method accepts integer variables, user can choose which image to Hower
- 3)Prints out name of howered image
- 4)Asserts checks if hower worked by checking if h5 is available(need to change number value to chosen number)

- Inputs tests
- 1)User can choose how many numbers to enter by changing for loop value
- 2)Entered numbers are chosen randomly from given interval
- 3)Printouts all entered numbers

- Tables test:
- 1)Table sorted by last Name
- 2)Assert checks if table sorted correctly

- ContextMenu test:
- 1)Right clicked on area to get alertIsPresent
- 2)Alert dismised using selenium
- 3)Printouts if alert was present

### Authors: [Vaidas Pocius]( https://github.com/Vaidas393)
