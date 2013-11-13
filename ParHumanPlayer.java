package parcheesi.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class ParHumanPlayer extends SurfaceView{
	
	private Paint redPawnPaint = new Paint();
	private int redInHome = 5;
	private int blueInHome = 5;
	private int greenInHome = 5;
	private int yellowInHome = 5;
	private int oneValue = 0;
	private int twoValue = 0;
	
	/**
	Implement Later
	*/
	//ParState recentState;

	public ParHumanPlayer(Context context) {
		super(context);
		startup();
		
	}

	public ParHumanPlayer(Context context, AttributeSet set) {
		super(context, set);
		startup();
		
	}
	
	public ParHumanPlayer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		startup();
		
	}

	public void startup(){
		setWillNotDraw(false);
	}
	
	
	/**
	 * Need to Implement
	 */
//	protected Component createApplComponent(){
//		
//	}
	
	/**
	 * Need to Implement
	 */
//	protected void moreActionPerformed(ActionEvent ae){
//		
//	}
	
	/**
	 * Need to Implement
	 */
	protected void requestMove(){
		
	}
	
	/**
	 * Need to Implement
	 */
	protected void stateChanged(){
		
	}
	
	@Override
	public void draw(Canvas canvas) {
		//Draw Board
		Bitmap board = BitmapFactory.decodeResource(getResources(),R.drawable.parboard);
		Bitmap finalBoard = Bitmap.createScaledBitmap(board, 700, 700, true);
		canvas.drawBitmap(finalBoard, 0, 0, new Paint());
		
		//Initialize Dice
		Bitmap d1 = BitmapFactory.decodeResource(getResources(),R.drawable.one);
		Bitmap d2 = BitmapFactory.decodeResource(getResources(),R.drawable.two);
		Bitmap d3 = BitmapFactory.decodeResource(getResources(),R.drawable.three);
		Bitmap d4 = BitmapFactory.decodeResource(getResources(),R.drawable.four);
		Bitmap d5 = BitmapFactory.decodeResource(getResources(),R.drawable.five);
		Bitmap d6 = BitmapFactory.decodeResource(getResources(),R.drawable.six);
		
	
		
		//Draw Red Pawn
//		redPawnPaint.setColor(Color.RED);
//		canvas.drawCircle(80, 70, 10, redPawnPaint);
//		canvas.drawCircle(140, 70, 10, redPawnPaint);
//		canvas.drawCircle(110, 100, 10, redPawnPaint);
//		canvas.drawCircle(80, 130, 10, redPawnPaint);
//		canvas.drawCircle(140, 130, 10, redPawnPaint);
		
		//Draw 1st Dice
		switch(MainActivity.dice1){
			case 0:
				canvas.drawBitmap(d1, 750, 250, new Paint());
				break;
			case 1:
				canvas.drawBitmap(d2, 750, 250, new Paint());
				break;
			case 2:
				canvas.drawBitmap(d3, 750, 250, new Paint());
				break;
			case 3:
				canvas.drawBitmap(d4, 750, 250, new Paint());
				break;
			case 4:	
				canvas.drawBitmap(d5, 750, 250, new Paint());
				break;
			case 5:
				canvas.drawBitmap(d6, 750, 250, new Paint());
				break;
		}
		
		//Draw 2nd Dice
		switch(MainActivity.dice2){
			case 0:
				canvas.drawBitmap(d1, 1000, 250, new Paint());
				break;
			case 1:
				canvas.drawBitmap(d2, 1000, 250, new Paint());
				break;
			case 2:	
				canvas.drawBitmap(d3, 1000, 250, new Paint());
				break;
			case 3:	
				canvas.drawBitmap(d4, 1000, 250, new Paint());
				break;
			case 4:
				canvas.drawBitmap(d5, 1000, 250, new Paint());
				break;
			case 5:	
				canvas.drawBitmap(d6, 1000, 250, new Paint());
				break;
		}
		
		//X across 2nd Dice
		Paint xPaint = new Paint();
		xPaint.setColor(Color.RED);
		canvas.drawLine(1000, 250, 1200, 450, xPaint);
		canvas.drawLine(1000, 440, 1200, 240, xPaint);
		
		
		invalidate();
	}


}
