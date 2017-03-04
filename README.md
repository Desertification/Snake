# School assignment

## Description
* Implement the game Snake 
    * Game consists of a maze, a snake and food 
        * Simple maze: just a rectangular wall
    * At start: a snake consists of a single body part
    * The player controls the snake in four directions, up, down, left ,right. A single step at a time.
    * Every step check if the snake hits the wall or itself => game over
    * Every step check if the snake hits food => food is added as a body part to the snake body
* Build your own data structure classes (only use primitive data types and arrays)
    * No predefined classes are allowed, except for a test framework, e.g. for Java JUnit and a random number generator, e.g. Math.random().

## Extra's
* Multiple snakes, as if they are controlled by different players, in the same maze. When a snake hits another snake, it's game over for that snake.
* You can use additional predefined classes to implement the extra's (if needed)
* Provide actual user input, instead of calling methods (Hint: in Java you can use the Scanner class)
* Real-time behavior, instead of waiting for user input every step (Hint: in Java you can use the Timer class)
* Provide a user interface
* Add your own features