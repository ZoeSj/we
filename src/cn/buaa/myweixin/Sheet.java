package cn.buaa.myweixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Sheet extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sheet);
	}
	 public void save(View v) {  
	      	Intent intent = new Intent();
			intent.setClass(Sheet.this,Login.class);
			startActivity(intent);
			//this.finish();
	      }  
	    public void resign(View v) {  
	      	Intent intent = new Intent();
			intent.setClass(Sheet.this,Sheet.class);
			startActivity(intent);
			//this.finish();
	      }  
}
