Your code demonstrates a good understanding of basic Java concepts including classes, methods, arrays, and exception handling. I like that you changed the menu based on availability, that's a nice touch. The code is functional, reasonably organized, and shows thoughtful consideration of user experience. Keep up the great work, and don't hesitate to refactor as you learn new concepts.

OVERALL: PASSED

Minor Tweaks:

* **Code Duplication in Main**: The switch statements in your main loop are identical whether lockers are available or not. I think you meant to remove option 1 for renting if there aren't lockers available.

* **Method Naming**: `nullConfirmation()` and `validatePinClosure()` aren't very clear names for what these methods do. Maybe `confirmLockerRelease()` / `validatePinForRelease()`?

* **Inconsistent Spacing**: Some method calls have extra blank lines, others don't.

* **Unnecessary Conversion**: In `LockerServices` you're converting strings to strings:

  ```java
  String currentPin = String.valueOf(Lockers.getPin(requestedLockerNum));
  ```

  `getPin()` already returns a string.