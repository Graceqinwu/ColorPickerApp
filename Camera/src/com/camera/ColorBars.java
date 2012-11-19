package com.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class ColorBars extends View {
	private final RectF sq1 = new RectF();
	private final RectF sq2 = new RectF();
	private final RectF sq3 = new RectF();
	private final RectF sq4 = new RectF();
	
	

	private final Paint mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final Paint mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final Paint mPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);

	public ColorBars(Context context, int screenWidth, int screenHeight, int color1, int color2, int color3, int color4) {
		super(context);
		// TODO Auto-generated constructor stub
		System.out.println(screenHeight);
		mPaint1.setColor(color1);
		mPaint2.setColor(color2);
		mPaint3.setColor(color3);
		mPaint4.setColor(color4);
		this.sq1.set(0,0,screenWidth/4,screenHeight);
		this.sq2.set(screenWidth/4,0,screenWidth/2,screenHeight);
		this.sq3.set(screenWidth/2,0,(screenWidth/4)*3,screenHeight);
		this.sq4.set((screenWidth/4)*3,0,screenWidth,screenHeight);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		canvas.drawCircle(x, y, r, mPaint);
		canvas.drawRect(sq1, mPaint1 );
		canvas.drawRect(sq2, mPaint2 );
		canvas.drawRect(sq3, mPaint3 );
		canvas.drawRect(sq4, mPaint4 );
	}

}
