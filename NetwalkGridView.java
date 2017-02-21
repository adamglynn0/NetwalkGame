package com.adamglynn.netwalk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import java.util.Random;


/**
 * Created by adamglynn on 1/31/17.
 */

public class NetwalkGridView extends View {

    protected boolean enabled = true;
    int max_col;
    int max_row;
    int cellArea = 0;
    int click_number = 0;
    Bitmap bitmap1;
    private GestureDetector mGestureDetector;
    private NetwalkGrid nGrid;

    //Below are the unconnected wires (shown as red wires)
    Bitmap down_left = BitmapFactory.decodeResource(this.getResources(), R.drawable.down_left);
    Bitmap down_left_up = BitmapFactory.decodeResource(this.getResources(), R.drawable.down_left_up);
    Bitmap left_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.left_right);
    Bitmap left_up = BitmapFactory.decodeResource(this.getResources(), R.drawable.left_up);
    Bitmap left_up_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.left_up_right);
    Bitmap right_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.right_down);
    Bitmap right_down_left = BitmapFactory.decodeResource(this.getResources(), R.drawable.right_down_left);
    Bitmap up_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.up_down);
    Bitmap up_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.up_right);
    Bitmap up_right_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.up_right_down);

    //Below are are all the possible server connections (seeing as they are technically always connected, they are all blue)
    Bitmap server_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_down);
    Bitmap server_left = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_left);
    Bitmap server_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_right);
    Bitmap server_up = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_up);
    Bitmap server_left_up = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_left_up);
    Bitmap server_up_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_up_right);
    Bitmap server_right_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_right_down);
    Bitmap server_left_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_left_down);
    Bitmap server_up_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_up_down);
    Bitmap server_left_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_left_right);
    Bitmap server_left_up_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_left_up_right);
    Bitmap server_right_down_left = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_left_down_right);
    Bitmap server_up_right_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_up_right_down);
    Bitmap server_down_left_up = BitmapFactory.decodeResource(this.getResources(), R.drawable.server_down_left_up);

    //Below are all the the unconnected nodes (only 4 possibilities)
    Bitmap node_down = BitmapFactory.decodeResource(this.getResources(), R.drawable.node_down);
    Bitmap node_left = BitmapFactory.decodeResource(this.getResources(), R.drawable.node_left);
    Bitmap node_right = BitmapFactory.decodeResource(this.getResources(), R.drawable.node_right);
    Bitmap node_up = BitmapFactory.decodeResource(this.getResources(), R.drawable.node_up);

    /*
    Creating the constructor which requires the context and also the difficulty to draw the grid size
     */
    public NetwalkGridView(Context context, int difficulty) {
        super(context);
        mGestureDetector = new GestureDetector(context, new MyGestureListener());

        nGrid = new NetwalkGrid(difficulty, difficulty);
        max_col = difficulty;
        max_row = difficulty;
        randomGenerator();
    }

    //The two methods below diable touch once the user has completed the grid
    public void enable(boolean b) {
        enabled = b;
    }
    //For some hints with disabling touch I used this post on StackOverflow
    //http://stackoverflow.com/questions/4280608/disable-a-whole-activity-from-user-action

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return !enabled || super.dispatchTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent e) {
        this.mGestureDetector.onTouchEvent(e);
        return super.onTouchEvent(e);
    }

    //This method below has one purpose, which is to rotate a certain grid element a random number
    //of times.
    public void randomGenerator() {
        for (int col = 0; col < max_col; col++) {
            for (int row = 0; row < max_row; row++) {
                for (int r = 0; r < new Random().nextInt(3); r++) {
                    nGrid.rotateRight(col, row);
                }
            }
        }
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        int cellContent;

        //The calculation below works out the width of the screen and divides it by how many rows
        // are required for the grid. Seeing as they are all squares the width is the same as
        //the height.
        float cellWidth = getWidth() / nGrid.getRows();
        cellArea = (int) cellWidth;

        //The two for loops below traverse through each sqaure in the gird and set a corresponding bitmap
        //to the binary value given inside the algorithm
        for (int col = 0; col < max_col; col++) {
            for (int row = 0; row < max_row; row++) {

                //Cell content describes which image should be in a particular square due to its row and col values
                cellContent = nGrid.getGridElem(col, row);

                //Using an if loop to go through all the possible values and assign a particular bitmap to the
                //variable 'bitmap1'
                if (cellContent == 9) {
                    bitmap1 = down_left;
                } else if (cellContent == 13) {
                    bitmap1 = down_left_up;
                } else if (cellContent == 10) {
                    bitmap1 = left_right;
                } else if (cellContent == 12) {
                    bitmap1 = left_up;
                } else if (cellContent == 14) {
                    bitmap1 = left_up_right;
                } else if (cellContent == 33) {
                    bitmap1 = node_down;
                } else if (cellContent == 40) {
                    bitmap1 = node_left;
                } else if (cellContent == 34) {
                    bitmap1 = node_right;
                } else if (cellContent == 36) {
                    bitmap1 = node_up;
                } else if (cellContent == 3) {
                    bitmap1 = right_down;
                } else if (cellContent == 11) {
                    bitmap1 = right_down_left;
                } else if (cellContent == 5) {
                    bitmap1 = up_down;
                } else if (cellContent == 6) {
                    bitmap1 = up_right;
                } else if (cellContent == 7) {
                    bitmap1 = up_right_down;
                } else if (cellContent == 81) {
                    bitmap1 = server_down;
                } else if (cellContent == 88) {
                    bitmap1 = server_left;
                } else if (cellContent == 82) {
                    bitmap1 = server_right;
                } else if (cellContent == 84) {
                    bitmap1 = server_up;
                } else if (cellContent == 92) {
                    bitmap1 = server_left_up;
                } else if (cellContent == 86) {
                    bitmap1 = server_up_right;
                } else if (cellContent == 83) {
                    bitmap1 = server_right_down;
                } else if (cellContent == 89) {
                    bitmap1 = server_left_down;
                } else if (cellContent == 85) {
                    bitmap1 = server_up_down;
                } else if (cellContent == 90) {
                    bitmap1 = server_left_right;
                } else if (cellContent == 94) {
                    bitmap1 = server_left_up_right;
                } else if (cellContent == 91) {
                    bitmap1 = server_right_down_left;
                } else if (cellContent == 87) {
                    bitmap1 = server_up_right_down;
                } else if (cellContent == 93) {
                    bitmap1 = server_down_left_up;
                }

                //The code below calculates the dimensions of the square and resizes and draws the bitmap
                //in this area.
                canvas.drawBitmap(bitmap1, null, new Rect((int) (col * cellArea), (int) (row * cellArea),
                            (col + 1) * (int) cellArea, (row + 1) * cellArea), null);

            }


            //Creating a Paint vairable so that I can draw onto the background of the canvas
            Paint paint = new Paint();

            //Setting the co-ordinates for where I want to draw the text and variable amount
            int numX = 435;
            int numY = 1600;
            int textX = 100;
            int textY = 1600;

            paint.setColor(Color.BLACK);
            paint.setTextSize(100);

            //The two elements are drawn onto the canvas by providing them with co-ordinate values.
            //'click_number' has been incremeneted upon each click on the screen
            canvas.drawText("Clicks:", textX, textY, paint);
            canvas.drawText(String.valueOf(click_number), numX, numY, paint);

            //Some help for Paint and positioning was found from the address below
            //http://stackoverflow.com/questions/4039713/how-to-draw-text-on-canvas for the color above.
        }
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        public void onLongPress(MotionEvent e) {
            //Creating 2 ints and setting them to the X and Y co-ordinates of where the user pressed the screen
            int x = (int) e.getX();
            int y = (int) e.getY();

            //The two calculations below find the rounded row and column numbers inside the grid which were selected
            int columnCheck = x / (getWidth() / nGrid.getColumns());
            int rowCheck = y / (getWidth() / nGrid.getRows());


            //The method below checks if the user has clicked inside the grid, if not, their selection is ignored
            if (rowCheck < nGrid.getRows() && (columnCheck < nGrid.getColumns())) {
                //Calling the rotateRight method and setting the parameters to those row and column number selected
                //by the user.
                nGrid.rotateRight(columnCheck, rowCheck);
                click_number++;
            }
            invalidate();

            /*
            Calling the checkWin() method inside the NetwalkGrid class to check if the user has won.
            If positive the code inside the if loop is executed
             */
            if (nGrid.checkWin()) {
                //Calling the enable method to disble the touch upon completion
                enable(false);

                //Creating a toast to notify the user that they have completed the game
                Toast.makeText(getContext(), "Game Completed Well Done!!!", Toast.LENGTH_LONG).show();
            }
        }
    }
}




