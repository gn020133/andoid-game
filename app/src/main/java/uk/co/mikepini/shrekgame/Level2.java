package uk.co.mikepini.shrekgame;

//Other parts of the android libraries that we use
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.Random;

public class Level2 extends GameThread {

    //Will store the image of a ball
    private Bitmap mShrek;
    private int secsElapsed;

    //The X and Y position of the ball on the screen
    //The point is the top left corner, not middle, of the ball
    //Initially at -100 to avoid them being drawn in 0,0 of the screen
    private float mShrekX = -100;
    private float mShrekY = -100;

    //The speed (pixel/second) of the ball in direction X and Y
    private float mShrekSpeedX = 0;
    private float mShrekSpeedY = 0;


    //Will store the image of the Paddle used to hit the ball
    private Bitmap mOnion;

    //Paddle's x position. Y will always be the bottom of the screen
    private float mOnionX = 0;
    private float mOnionY = 0;

    //The speed (pixel/second) of the paddle in direction X and Y


    //Will store the image of the smiley ball (score ball)
    private Bitmap mOuthouse;

    //The X and Y position of the ball on the screen
    //The point is the top left corner, not middle, of the ball
    //Initially at -100 to avoid them being drawn in 0,0 of the screen
    private float mOuthouseX = -100;
    private float mOuthouseY = -100;

    //Will store the image of the smiley ball (score ball)
    private Bitmap wall;

    //The X and Y position of the SadBalls on the screen
    //The point is the top left corner, not middle, of the balls
    //Initially at -100 to avoid them being drawn in 0,0 of the screen
    private float[] wallX = new float[50];
    private float[] wallY = new float[50];

    //This will store the min distance allowed between a big ball and the small ball
    //This is used to check collisions
    private float mMinDistanceBetweenBallAndPaddle = 0;

    //This is run before anything else, so we can prepare things here
    public Level2(GameView gameView) {
        //House keeping
        super(gameView);

        //Prepare the image so we can draw it on the screen (using a canvas)
        mShrek = BitmapFactory.decodeResource
                (gameView.getContext().getResources(),
                        R.drawable.shrek);

        //Prepare the image of the paddle so we can draw it on the screen (using a canvas)
        mOnion = BitmapFactory.decodeResource
                (gameView.getContext().getResources(),
                        R.drawable.onion);

        //Prepare the image of the SmileyBall so we can draw it on the screen (using a canvas)
        mOuthouse =  BitmapFactory.decodeResource
                (gameView.getContext().getResources(),
                        R.drawable.outhouse);

        //Prepare the image of the SadBall(s) so we can draw it on the screen (using a canvas)
        wall =  BitmapFactory.decodeResource
                (gameView.getContext().getResources(),
                        R.drawable.brick_wall2);
    }


    protected int GetRandomX() {
        Random rand = new Random();
        return rand.nextInt(mCanvasWidth);

    }
    protected int GetRandomY() {
        Random rand = new Random();
        int num=rand.nextInt(mCanvasHeight);
        // for(int i=0;i<wallX.length;i++) {
        //   //   if (wallX[i]!=num){continue;
        // }else break;
        return num;
        //  }

    }
    //This is run before a new game (also after an old game)
    @Override
    public void setupBeginning() {
        //Initialise speeds
        //mCanvasWidth and mCanvasHeight are declared and managed elsewhere
        mShrekSpeedX = mCanvasWidth / 3;
        mShrekSpeedY = mCanvasHeight / 3;

        //Place the ball in the middle of the screen.
        //mShrek.Width() and mShrek.getHeigh() gives us the height and width of the image of the ball
        mShrekX = mCanvasWidth/8;
        mShrekY = (float) (mCanvasWidth/1.09090909);

        //Place Paddle in the middle of the screen
        mOnionX = GetRandomX();
        mOnionY = GetRandomY();

        //Place SmileyBall in the top middle of the screen
        mOuthouseX = (float) (mCanvasWidth/1.142857);
        mOuthouseY = mCanvasWidth/6;

        //Place all SadBalls forming a pyramid underneath the SmileyBall
        wallX[0] =  GetRandomX();
        wallY[0] = GetRandomY();

        wallX[1] =  GetRandomX();
        wallY[1] =  GetRandomY();

        wallX[2] =  GetRandomX();
        wallY[2] = GetRandomY();

        wallX[3] =  GetRandomX();
        wallY[3] = GetRandomY();

        wallX[4] =  GetRandomX();
        wallY[4] =GetRandomY();

        wallX[5] =  GetRandomX();
        wallY[5] =GetRandomY();

        wallX[6] =  GetRandomX();
        wallY[6] =GetRandomY();






        //Get the minimum distance between a small ball and a bigball
        //We leave out the square root to limit the calculations of the program
        //Remember to do that when testing the distance as well
        mMinDistanceBetweenBallAndPaddle = (mOnion.getWidth() / 2 + mShrek.getWidth() / 2) * (mOnion.getWidth() / 2 + mShrek.getWidth() / 2);
    }

    @Override
    protected void doDraw(Canvas canvas) {
        //If there isn't a canvas to do nothing
        //It is ok not understanding what is happening here
        if(canvas == null) return;
        mShrekSpeedX *=0.8;
        mShrekSpeedY *=0.8;

        //House keeping
        super.doDraw(canvas);

        //canvas.drawBitmap(bitmap, x, y, paint) uses top/left corner of bitmap as 0,0
        //we use 0,0 in the middle of the bitmap, so negate half of the width and height of the ball to draw the ball as expected
        //A paint of null means that we will use the image without any extra features (called Paint)

        //draw the image of the ball using the X and Y of the ball
        canvas.drawBitmap(mShrek, mShrekX - mShrek.getWidth() / 2, mShrekY - mShrek.getHeight() / 2, null);

        //Draw Paddle using X of paddle and the bottom of the screen (top/left is 0,0)
        canvas.drawBitmap(mOnion, mOnionX - mOnion.getWidth() / 2, mOnionY - mOnion.getHeight() / 2, null);

        //Draw SmileyBall
        canvas.drawBitmap(mOuthouse, mOuthouseX - mOuthouse.getWidth() / 2, mOuthouseY - mOuthouse.getHeight() / 2, null);

        //Loop through all SadBall
        for(int i = 0; i < wallX.length; i++) {
            //Draw SadBall in position i
            canvas.drawBitmap(wall, wallX[i] - wall.getWidth() / 2, wallY[i] - wall.getHeight() / 2, null);
        }
    }


    //This is run whenever the phone is touched by the user
    @Override
    protected void actionOnTouch(float x, float y) {
        //Move the ball to the x position of the touch



        if (x>mCanvasWidth/2)
            mShrekSpeedX +=Math.abs(x-mCanvasWidth/2);
        else mShrekSpeedX -=Math.abs(x-mCanvasWidth/2);

        if (y>mCanvasHeight/2)
            mShrekSpeedY +=Math.abs(y-mCanvasHeight/2);
        else mShrekSpeedY -=Math.abs(y-mCanvasHeight/2);

    }





    //This is run just before the game "scenario" is printed on the screen
    @Override
    protected void updateGame(float secondsElapsed) {

        //If the ball moves down on the screen
        if(mShrekSpeedY > 0) {
            //Check for a paddle collision
            updateBallCollision(mOnionX, mCanvasHeight);
        }
        updateScore(1);


        //Move the ball's X and Y using the speed (pixel/sec)
        mShrekX = mShrekX + secondsElapsed * mShrekSpeedX;
        mShrekY = mShrekY + secondsElapsed * mShrekSpeedY;



        //Check if the ball hits either the left side or the right side of the screen
        //But only do something if the ball is moving towards that side of the screen
        //If it does that => change the direction of the ball in the X direction
        if((mShrekX <= mShrek.getWidth() / 2 && mShrekSpeedX < 0) || (mShrekX >= mCanvasWidth - mShrek.getWidth() / 2 && mShrekSpeedX > 0) ) {
            mShrekSpeedX = -mShrekSpeedX;
        }

        //Check for SmileyBall collision

        if(updateBallCollision(mOuthouseX, mOuthouseY)) {
            //go to next level
            setState(GameThread.STATE_WIN);
        }
        if(updateBallCollision(mOnionX, mOnionY)) {
            setScore(0);
        }

        //Loop through all SadBalls
        for(int i = 0; i < wallX.length; i++) {
            //Perform collisions (if necessary) between SadBall in position i and the red ball
            updateBallCollision(wallX[i], wallY[i]);
        }

        //If the ball goes out of the top of the screen and moves towards the top of the screen =>
        //change the direction of the ball in the Y direction
        if(mShrekY <= mShrek.getWidth() / 2 && mShrekSpeedY < 0) {
            mShrekSpeedY = -mShrekSpeedY;
        }
        //If the ball goes out of the bottom of the screen and moves towards the bottom of the screen =>
        //change the direction of the ball in the Y direction



        if(mShrekY >= mCanvasHeight) {
            mShrekSpeedY = -mShrekSpeedY;
        }
        //If the ball goes out of the bottom of the screen => lose the game
        if(getScore()>=100) {
            setState(GameThread.STATE_LOSE);
        }

    }

    //Collision control between mShrek and another big ball
    private boolean updateBallCollision(float x, float y) {
        //Get actual distance (without square root - remember?) between the mShrek and the ball being checked
        float distanceBetweenBallAndPaddle = (x - mShrekX) * (x - mShrekX) + (y - mShrekY) *(y - mShrekY);

        //Check if the actual distance is lower than the allowed => collision
        if(mMinDistanceBetweenBallAndPaddle >= distanceBetweenBallAndPaddle) {
            //Get the present speed (this should also be the speed going away after the collision)
            float speedOfBall = (float) Math.sqrt(mShrekSpeedX * mShrekSpeedX + mShrekSpeedY * mShrekSpeedY);

            //Change the direction of the ball
            mShrekSpeedX = mShrekX - x;
            mShrekSpeedY = mShrekY - y;

            //Get the speed after the collision
            float newSpeedOfBall = (float) Math.sqrt(mShrekSpeedX * mShrekSpeedX + mShrekSpeedY * mShrekSpeedY);

            //using the fraction between the original speed and present speed to calculate the needed
            //velocities in X and Y to get the original speed but with the new angle.
            mShrekSpeedX = mShrekSpeedX * speedOfBall / newSpeedOfBall;
            mShrekSpeedY = mShrekSpeedY * speedOfBall / newSpeedOfBall;

            return true;
        }

        return false;
    }
}

// This file is part of the course "Begin Programming: Build your first mobile game" from futurelearn.com
// Copyright: University of Reading and Karsten Lundqvist
// It is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// It is is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
//
// You should have received a copy of the GNU General Public License
// along with it.  If not, see <http://www.gnu.org/licenses/>.
