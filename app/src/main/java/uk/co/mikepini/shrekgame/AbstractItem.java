package uk.co.mikepini.shrekgame;

import java.util.Random;

public abstract class AbstractItem {

    int x;
    int y;
    int speedX=0;
    int speedY=15;
    int width=50;
    int height=50;
    int canvasWidth;
    int canvasHeight;


   void AbstractItem(int x, int y){//constructor
        this.x=x;
        this.y=y;
    }
    public int getX(){//getter for x
        return x;
    }
    public int getY(){//getter for y
        return y;
    }
    public int getSpeedX(){// getter for x speed
        return speedX;
    }
    public int getSpeedY(){// getter for y speed
        return speedY;
    }
    public void move(){// method for moving the item
        x=x+speedX;
        y=y+speedY;
        //IsTouchingWall();
    }
    public void setX(int newX){//setter for x
         x=newX;
    }
    public void setY(int newY){// setter for y
        y=newY;
    }
    public void setSpeedX(int newSpeed){//setter for x speed
        speedX=newSpeed;
    }
    public void setSpeedY(int newSpeed){//asetter for y speed
        speedY=newSpeed;
    }
    public int getWidth(){//getter fot width
        return width;
    }
    public int getHeight(){//getter for height
        return height;
    }




    private void IsTouchingWall(){

     /*   if((x <= width / 2 && speedX < 0) || (x >= canvasWidth - width / 2 && speedX > 0) ) {
            speedX = -speedX;
        }
        if((y <= height / 2 && speedY < 0) || (y >= canvasHeight - height / 2 && speedY> 0) ) {
            speedY = -speedY;
        }
        */

     if(y>canvasHeight){
         y=0;
         Random rand = new Random();
         x= rand.nextInt(canvasWidth);

     }
      //if (x<0 || x> canvasWidth){// if x is out of bounds
        //  speedX = -speedX;// flip the speed
          //x=x+speedX;

        // return true;//retrun true
     // }
        //if (y<0 || y>canvusHight) {//if y is out of bounds
        //    speedY = -speedY;//flip the speed
            //y=y+speedY;
        //    return true; //return ture
       // }
      //  return false;//return false
    }

}
