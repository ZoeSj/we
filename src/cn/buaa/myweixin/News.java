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
	private int index = 0; // ��ǰ����
	private int[] imagePath = new int[] { R.drawable.img01, R.drawable.img04,
			R.drawable.img03, R.drawable.img02 }; // ��������ʼ��һ���������ͼƬ������

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout); // ��ȡXML�ļ��ж�������Բ��ֹ�����
		ImageView img = new ImageView(this); // ����һ��ImageView���
		img.setImageResource(imagePath[index]); // ΪImageView���ָ��Ҫ��ʾ��ͼƬ
		LayoutParams params = new LayoutParams(400, 600); // ����ͼƬ�Ŀ�Ⱥ͸߶�
		img.setLayoutParams(params); // ΪImageView������ò��ֲ���
		img.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (index < 3) {
					index++;
				} else {
					index = 0;
				}
				((ImageView) v).setImageResource(imagePath[index]); // ΪImageView���ָ��Ҫ��ʾ��ͼƬ
				return false;
			}
		});
		layout.addView(img); // ��ImageView�����ӵ����ֹ�������
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
				text.setText("��" + (position + 1) + "��У������");
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
