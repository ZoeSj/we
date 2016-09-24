package cn.buaa.myweixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Tab01Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab02);
		ImageButton imagebutton4 = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton imagebutton5 = (ImageButton) findViewById(R.id.imageButton5);
		ImageButton imagebutton1 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton imagebutton2 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton imagebutton3 = (ImageButton) findViewById(R.id.imageButton3);
		imagebutton4.setOnClickListener(listener1);
		imagebutton5.setOnClickListener(listener1);
		imagebutton1.setOnClickListener(listener1);
		imagebutton2.setOnClickListener(listener1);
		imagebutton3.setOnClickListener(listener1);
	}

	private OnClickListener listener1 = new OnClickListener() {

		@Override
		public void onClick(View v) {

			ImageButton btnButton = (ImageButton) v;
			switch (btnButton.getId()) {
			case R.id.imageButton4:
				Intent intent = new Intent(Tab01Activity.this,
						News.class);// 创建Intent对象
				Toast.makeText(Tab01Activity.this, "welcome", Toast.LENGTH_LONG)
						.show();
				startActivity(intent);// 启动主Activity
				break;
			case R.id.imageButton5:
				Intent intent1 = new Intent(Tab01Activity.this,
						News.class);// 创建Intent对象
				Toast.makeText(Tab01Activity.this, "welcome", Toast.LENGTH_LONG)
						.show();
				startActivity(intent1);// 启动主Activity
				break;
			case R.id.imageButton1:
				// 创建Intent对象
				Toast.makeText(Tab01Activity.this, "此功能后期实现", Toast.LENGTH_LONG)
						.show();
				
				break;
			case R.id.imageButton2:
				
				Toast.makeText(Tab01Activity.this, "此功能后期实现", Toast.LENGTH_LONG)
						.show();
				
				break;
			case R.id.imageButton3:
				
				Toast.makeText(Tab01Activity.this, "此功能后期实现", Toast.LENGTH_LONG)
						.show();
				
				break;

			}
		}

		public void onClick1(View v) {
			// TODO Auto-generated method stub
			
		}
	};
	}
