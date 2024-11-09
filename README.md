Dependancy
Appium Java Client: Enables mobile automation.
Selenium Java: Adds web automation capabilities.
JUnit: Provides basic test structuring and assertions.
TestNG: Adds advanced test structuring and parallel execution.
Apache common IO : For Saving the Screenshot file. 

1. Setup Instructions: How to Install Dependencies and Run the Tests\
   Prerequisites:\
   Java Development Kit (JDK): Ensure that JDK 23 or later is installed.\
   Maven: This project uses Maven to manage dependencies, so Maven should be installed.\
   Appium: Install the Appium Desktop application or run Appium Server via CLI. Ensure the server is running at http://127.0.0.1:4723/.
   Android Emulator/Real Device: Set up an Android emulator with Android version 11 or connect a real device.\
   Instructions:\
   Clone the Repository: If this code is part of a repository, clone it to your local machine.\
   Install Dependencies:\
   1.Open a terminal in the project directory.\
   Run mvn clean install to download the required dependencies as specified in the pom.xml file.\
   Prepare the Application Under Test:\
   Place the APK file (ApiDemos-debug.apk) in the correct path (D:\EclipsProject\PH_test\src\main\resources\) or update the path in the code.\
   Run the Tests:\
   Start the Appium server on http://127.0.0.1:4723/. \
   Execute the test with Maven: mvn test.\
   Alternatively, open the project in IntelliJ and run the ph class directly.
2. Automation Strategy\
      Strategy:\
      The test case performs several actions to navigate through an Android app (ApiDemos), interacting with specific UI elements to validate functionality.

Test Setup:\

setup() method initializes the Appium driver with UiAutomator2Options specifying device details, app path, and platform information.
This setup is crucial to enable automation on Android.\
Automation Steps:\

Locate and Interact with Elements:\
WebElement accesWE: Finds the element with the accessibility ID "Views" and clicks on it. Uses createWait to ensure element visibility, handling dynamic load times.\
Scroll to Find Elements:\
Uses UiScrollable to scroll and locate elements such as "Expandable Lists" and "Drag and Drop."\
Long Press Action:\
Uses the Selenium Actions class to simulate a long press on an element ("People Names") in the "Custom Adapter" list.\
Navigation:\
Uses driver.navigate().back() to go back to the previous screen multiple times, simulating the user navigating back through the app.\
Drag and Drop Interaction:\
Using Actions, the test performs a drag-and-drop action from one circle element to another.\
Assertions:

At each key step, Assert.assertTrue() statements with messages validate successful actions (e.g., "Accessibility Clicked," "Custom Adapter Clicked").\
If any element is not found, NoSuchElementException is caught, and Assert.fail() provides a descriptive message in the output.\
Challenges and Solutions:

Dynamic Element Loading: Used WebDriverWait and ExpectedConditions.visibilityOf to handle loading times dynamically.
Scrollable Elements: Solved the need to locate off-screen elements using UiScrollable to scroll within the app’s view.
Long Press and Drag-and-Drop: Selenium Actions API was used to simulate long presses and drag-and-drop actions, a commonly challenging task in mobile automation.


3. Screenshots / Logs\
   Screenshots and logs would be generated upon successful execution of each step. Here’s how to capture or interpret them:\

Example Log Output (Typical Success Flow):\
"Accessiblity Clicked": Confirms successful click on the "Views" element.\
"Scroll to Expandable and Clicked": Confirms successful scrolling and clicking of the "Expandable Lists" element.\
"Custom Adapter Clicked": Confirms the "Custom Adapter" option was successfully selected.\
"Long Clicked to First Element": Confirms successful long-click action on the "People Names" element.\
"Automation Success": Final confirmation that all actions were completed successfully without errors. \

4. Expected Output
   After running the test, the expected output should confirm that each test step has been completed successfully. The console output will display assertions and confirmations for each step, validating the automation flow as follows:

Views button is clicked successfully.\
App scrolls to and clicks "Expandable Lists."\
"Custom Adapter" option is selected.\
"People Names" is long-pressed, simulating a long-click action.\
The app navigates back multiple times to reach the main screen.\
"Drag and Drop" action is performed between two elements (first circle and second circle).\
If all steps execute without exceptions, the final message should print:\ "Automation Success" \

If any elements are not found or the interactions fail, the output will contain the failure message: "One or multiple element not found"

This setup, strategy, and expected output ensure the app’s functionality is validated by simulating user interactions through Appium automation.\