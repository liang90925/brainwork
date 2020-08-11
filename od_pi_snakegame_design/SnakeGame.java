
import java.io.*;
import java.util.*;

public class SnakeGame {

    /*
     * Click `Run` to execute the snippet below!
     */


    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */



    /**
     *
     func (g Game) GameOver() bool {
     // return game over state
     }

     func (g *Game) Tick() {
     // move the game one frame forward
     }

     func (s *Snake) SetDirection(dir Direction) {
     // change the snake's direction
     }
     */


        public static class Game {
            int row;
            int col;
            Snake snake;
            Direction currDir;

            public Game(int row, int col, Snake snake, Direction dir) {
                this.row = row;
                this.col = col;
                this.snake = snake;
                this.currDir = dir;
            }

            public boolean gameOver() {
                // Check collide with itself
                for (Point point: snake.body) {
                    if (snake.head.r == point.r && snake.head.c == point.c) {
                        return true;
                    }
                }

                // Collide with the wall
                if (!inBoard(snake.head, row, col)) {
                    return true;
                }

                return false;
            }


            public void Tick() {
                // move snake to the next position
      /*
      move the head to the next position.
      move the rest of the body to the prev one
      */
                Point prevHead = new Point(snake.head.r, snake.head.c);
                snake.setNewHead(currDir);
                snake.moveBobyForward(prevHead);

            }

            public void setDirection(Direction dir) {
                this.currDir = dir;
            }

        }

        public static class Snake {
            Point head;
            List<Point> body;

            public Snake(List<Point> points) {
                this.head = points.get(0);
                this.body = points.subList(1, points.size());
            }

            private void setNewHead(Direction dir) {
                switch (dir) {
                    case UP:
                        head.r -= 1;
                        break;
                    case DOWN:
                        head.r += 1;
                        break;
                    case LEFT:
                        head.c -= 1;
                        break;
                    case RIGHT:
                        head.c += 1;
                        break;
                }
            }

            private void moveBobyForward(Point head) {
                List<Point> newBody = new ArrayList<>();

                newBody.add(head);
                for (int i = 0; i < body.size() - 1; i++) {
                    newBody.add(body.get(i));
                }
                this.body = newBody;
            }

        }

        public static class Point {
            int r;
            int c;

            public Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        enum Direction {
            UP,
            DOWN,
            LEFT,
            RIGHT
        }

        private static boolean inBoard(Point p, int boardR, int boardC) {
            if (p.r >= 0 && p.c >=0 && p.r < boardR && p.c < boardC) {
                return true;
            }

            return false;
        }

        public static void main(String[] args) {

            SnakeGame solution = new SnakeGame();
            List<Point> points = new ArrayList<>();
            points.add(new Point(5, 5));
            points.add(new Point(4, 5));
            points.add(new Point(3, 5));
            points.add(new Point(2, 5));
            points.add(new Point(1, 5));


            Game snakeGame = new Game(8, 8, new Snake(points), Direction.DOWN);

            Point head = snakeGame.snake.head;
            List<Point> body = snakeGame.snake.body;
            System.out.println(head.r +", "+  head.c);
            for (Point point: body) {
                System.out.println(point.r  +", "+ point.c);

            }


//     snakeGame.Tick();

//     System.out.println(snakeGame.snake.head.r +", "+  snakeGame.snake.head.c);
//     for (Point point: snakeGame.snake.body) {
//         System.out.println(point.r  +", "+ point.c);

//     }

//     System.out.println(snakeGame.gameOver() + " == false");


//     snakeGame.Tick();
//     System.out.println(snakeGame.gameOver() + " == false");

//     snakeGame.Tick();
//     System.out.println(snakeGame.gameOver() + " == true");

            snakeGame.setDirection(Direction.RIGHT);
            snakeGame.Tick();
            System.out.println(snakeGame.snake.head.r +", "+  snakeGame.snake.head.c);
            for (Point point: snakeGame.snake.body) {
                System.out.println(point.r  +", "+ point.c);

            }
        }
    }


/*
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!








Hi! I'm Maggie, and I'll be your interviewer today!







What we’re looking for
- Think out loud: For every decision you make, we want to know why you made it and the trade-offs that came with it. We also want to know the paths you explored, but chose not to take.
- Working solution: The main focus is on getting to code that successfully solves the problem, but try to be explicit about where we are cutting corners on code quality to get there.
- Language familiarity: We really don’t care what language you write your code in, and it’s 100% okay to look up documentation during the interview. However, try to pick a language that you are comfortable writing idiomatic code in.










Problem Description:
Implement the state transition and game rules for a variant of the game Snake.
Start off with having the snake travel around and dying when colliding with something.


Not familiar with the Snake game? Play it for yourself! https://www.google.com/search?q=snake%20game



Requirements
The game exists on a 2D grid.


The rules:
- On each frame, the snake travels one block. As it moves forward, it leaves a tail behind, resembling a moving snake.
- If the snake’s head hits the boundary, or hits its own body, it will die.
- The snake will continue traveling in the previously traveled direction unless controlled otherwise.


Provide functionality for the following:
- Set a direction for the snake to travel on the next frame.
    - Just setting the direction does not cause the snake to travel (e.g. `snake.SetDirection(up)`)
- See whether the game is over (e.g. `game.GameOver()`)
- Move the game forward one frame (e.g. `game.Tick()`)
    - If the game is over, the game state does not change on the next frame.


                           .
                        ....
                       .....



Visual representation is not a requirement, but be sure to print the game state for testing.

Visual example of game state transition (@ is the snake head, X is the snake body, * is the boundary):


Example states:
Starting state:

**********
*        *
*     X  *
*     X  *
*     X  *
*     X  *
*     @  *
*        *
*        *
**********


Change direction, tick state forward:

**********
*        *
*        *
*     X  *
*     X  *
*     X  *
*     X@ *
*        *
*        *
**********


Tick state forward:

**********
*        *
*        *
*        *
*     X  *
*     X  *
*     XX@*
*        *
*        *
**********


Tick state forward, Game over:

**********
*        *
*        *
*        *
*        *
*     X  *
*     XXX#
*        *
*        *
**********


Change direction up, tick:

**********
*        *
*        *
*        *
*        *
*     X @*
*     XXX*
*        *
*        *
**********


Change direction left, tick:

**********
*        *
*        *
*        *
*        *
*      @X*
*     XXX*
*        *
*        *
**********


Change direction down, tick:

**********
*        *
*        *
*        *
*        *
*      XX*
*      #X*
*        *
*        *
**********



Getting started

Start by implementing the three methods described in the description. (This example is written in Go, but we don't care what programming language you use. You will, however, be expected to run your code.)


    func (g Game) GameOver() bool {
      // return game over state
    }

    func (g *Game) Tick() {
      // move the game one frame forward
    }

    func (s *Snake) SetDirection(dir Direction) {
      // change the snake's direction
    }


 */
