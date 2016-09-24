package com.example.wework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cn.buaa.myweixin.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class HDPView extends SurfaceView implements Callback {

	private boolean isRunning=true;
	private Handler h = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			
			if(msg.what==location){
				Log.e("what",""+msg.what);
				location = msg.what;
				drawBit();
				Message m = new Message();
				location=m.what=(location+1)%list.size();
				
				if(isRunning){
					
					h.sendMessageDelayed(m, 2000);
				}
			}
			
		};
	};
	private float swt,sht;
	private Paint paint  = new Paint();
	private SurfaceHolder sh;
	private List<Integer>list;
	private Bitmap bp;
	public HDPView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitDrawable();
		sh = this.getHolder();
		sh.addCallback(this);
		
	}
	
	public void bitDrawable(){
		list = new ArrayList<Integer>();
		Field [] fs = R.drawable.class.getDeclaredFields();
		
		for(Field f:fs){
			
			if(f.getName().startsWith("img")){
				
				try {
					int id = f.getInt(R.drawable.class);
					list.add(id);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
		Message msg = new Message();
		msg.what=0;
		h.sendMessage(msg);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		swt = this.getWidth();
		sht = this.getHeight();		
	}
	private int location;
	public void drawBit(){
		Canvas cs = sh.lockCanvas();
		
		if(cs!=null){
			Log.e("Canvas", ""+cs.toString());
			bp = BitmapFactory.decodeResource(getResources(), list.get(location));
			Log.e("bp",bp.toString());
			Bitmap bit = Bitmap.createScaledBitmap(bp, (int)swt,(int)sht,false);
			Log.e("bit",bit.toString());
			
			Log.e("cs","ÊÇNULL");
			cs.drawBitmap(bit,0,0, paint);
			sh.unlockCanvasAndPost(cs);
		}
		
		
	}
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.e("surfaceDestroyed","surfaceDestroyed");
		/*this.isRunning=false;*/
		
	}
	/*@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			
			location=-1;
			
			break;

		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}
*/
}
