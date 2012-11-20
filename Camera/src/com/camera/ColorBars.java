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
	Paint fontColor = new Paint();

	private final Paint mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final Paint mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final Paint mPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private int x = 0;
	private int y = 0;
	private int rgb1[];
	private int rgb2[];
	private int rgb3[];
	private int rgb4[];

	public ColorBars(Context context, int screenWidth, int screenHeight,
			int color1, int color2, int color3, int color4) {
		super(context);
		// TODO Auto-generated constructor stub
		this.x = screenWidth;
		this.y = screenHeight;
		System.out.println(screenHeight);
		mPaint1.setColor(color1);
		mPaint2.setColor(color2);
		mPaint3.setColor(color3);
		mPaint4.setColor(color4);
		this.sq1.set(0, 0, screenWidth / 4, screenHeight);
		this.sq2.set(screenWidth / 4, 0, screenWidth / 2, screenHeight);
		this.sq3.set(screenWidth / 2, 0, (screenWidth / 4) * 3, screenHeight);
		this.sq4.set((screenWidth / 4) * 3, 0, screenWidth, screenHeight);
		fontColor.setAntiAlias(true);
		fontColor.setTextSize(30);
		fontColor.setColor(Color.BLACK);
		fontColor.setTextAlign(Paint.Align.RIGHT);
		// int R,G,B = calculateRGB(color1);
		this.rgb1 = new int[] { (color1 >> 16) & 0xff, // red
				(color1 >> 8) & 0xff, // green
				(color1) & 0xff // blue
		};
		this.rgb2 = new int[] { (color2 >> 16) & 0xff, // red
				(color2 >> 8) & 0xff, // green
				(color2) & 0xff // blue
		};
		this.rgb3 = new int[] { (color3 >> 16) & 0xff, // red
				(color3 >> 8) & 0xff, // green
				(color3) & 0xff // blue
		};
		this.rgb4 = new int[] { (color4 >> 16) & 0xff, // red
				(color4 >> 8) & 0xff, // green
				(color4) & 0xff // blue
		};
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// canvas.drawCircle(x, y, r, mPaint);
		canvas.drawRect(sq1, mPaint1);
		canvas.drawRect(sq2, mPaint2);
		canvas.drawRect(sq3, mPaint3);
		canvas.drawRect(sq4, mPaint4);
		//creating text with RGB values
		canvas.drawText(String.valueOf("R: " + rgb1[0]), x / 4 - 20, y / 2, fontColor);
		canvas.drawText(String.valueOf("G: " + rgb1[1]), x / 4 - 20, y / 2 +35, fontColor);
		canvas.drawText(String.valueOf("B: " + rgb1[2]), x / 4 - 20, y / 2 +70, fontColor);
		
		canvas.drawText(String.valueOf("R: " + rgb2[0]), x / 2 - 20, y / 2, fontColor);
		canvas.drawText(String.valueOf("G: " + rgb2[1]), x / 2 - 20, y / 2 +35, fontColor);
		canvas.drawText(String.valueOf("B: " + rgb2[2]), x / 2 - 20, y / 2 +70, fontColor);
		
		canvas.drawText(String.valueOf("R: " + rgb3[0]), (x / 4)*3 - 20, y / 2, fontColor);
		canvas.drawText(String.valueOf("G: " + rgb3[1]), (x / 4)*3 - 20, y / 2 +35, fontColor);
		canvas.drawText(String.valueOf("B: " + rgb3[2]), (x / 4)*3 - 20, y / 2 +70, fontColor);
		
		canvas.drawText(String.valueOf("R: " + rgb4[0]), x - 20, y / 2, fontColor);
		canvas.drawText(String.valueOf("G: " + rgb4[1]), x - 20, y / 2 +35, fontColor);
		canvas.drawText(String.valueOf("B: " + rgb4[2]), x - 20, y / 2 +70, fontColor);
	}
}
