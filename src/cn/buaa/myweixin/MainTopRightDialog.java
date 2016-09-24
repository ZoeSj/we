package cn.buaa.myweixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainTopRightDialog extends Activity {
	// private MyDialog dialog;
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_top_right_dialog);
		// dialog=new MyDialog(this);
		layout = (LinearLayout) findViewById(R.id.main_dialog_layout);
		layout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainTopRightDialog.this,
						Tab01Activity.class);

				Toast.makeText(getApplicationContext(), "欢迎来我们学院！",
						Toast.LENGTH_SHORT).show();
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}
	/*
	 * public void exitbutton1(View v) { this.finish(); } public void
	 * exitbutton0(View v) { this.finish();
	 * MainWeixin.instance.finish();//关闭Main 这个Activity }
	 */
}
