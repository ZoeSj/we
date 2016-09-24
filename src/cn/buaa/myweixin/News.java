package cn.buaa.myweixin;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class News extends Activity {
	ListView myList;
	private int index = 0; // 当前索引
	private int[] imagePath = new int[] { R.drawable.img01, R.drawable.img04,
			R.drawable.img03, R.drawable.img02 }; // 声明并初始化一个保存访问图片的数组

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout); // 获取XML文件中定义的线性布局管理器
		ImageView img = new ImageView(this); // 创建一个ImageView组件
		img.setImageResource(imagePath[index]); // 为ImageView组件指定要显示的图片
		LayoutParams params = new LayoutParams(400, 600); // 设置图片的宽度和高度
		img.setLayoutParams(params); // 为ImageView组件设置布局参数
		img.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (index < 3) {
					index++;
				} else {
					index = 0;
				}
				((ImageView) v).setImageResource(imagePath[index]); // 为ImageView组件指定要显示的图片
				return false;
			}
		});
		layout.addView(img); // 将ImageView组件添加到布局管理器中
		myList = (ListView) findViewById(R.id.listView1);
		BaseAdapter adapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout line = new LinearLayout(News.this);
				line.setOrientation(0);
				ImageView image = new ImageView(News.this);
				image.setImageResource(R.drawable.login);
				TextView text = new TextView(News.this);
				text.setText("第" + (position + 1) + "个校内新闻");
				text.setTextSize(20);
				text.setTextColor(Color.BLUE);
				line.addView(image);
				line.addView(text);
				return line;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 20;
			}
		};
		myList.setAdapter(adapter);
	}
}
