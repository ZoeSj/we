package com.mingrisoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.buaa.myweixin.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class Chi extends Activity {
	/** Called when the activity is first created. */
	private int[] imageId = new int[] { R.drawable.tu1, R.drawable.tu2,
			R.drawable.tu3, R.drawable.tu4, R.drawable.tu5,
			R.drawable.tu6, R.drawable.tu7, R.drawable.tu8,
			R.drawable.tu9, R.drawable.tu10, R.drawable.tu11,
			R.drawable.tu12, }; // ���岢��ʼ������ͼƬid������
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintu);
		GridView gridview = (GridView) findViewById(R.id.gridView1); // ��ȡGridView���
		/***********************ʹ��SimpleAdapterָ��Ҫ��ʾ������*********************************/
		String[] title = new String[] { "��������", "����һɫ", "�ճ�", "��·", "һ֦����",
				"��", "��ռ��ͷ", "�ѹ�Ӣ��", "���Ž���", "���涷��", "��г", "�ּ�С·" }; // ���岢��ʼ������˵�����ֵ�����
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();// ����һ��list����
		// ͨ��forѭ����ͼƬid���б������ַŵ�Map�У�����ӵ�list������
		for (int i = 0; i < imageId.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", imageId[i]);
			map.put("title", title[i]);
			listItems.add(map); // ��map������ӵ�List������
		}

		SimpleAdapter adapter = new SimpleAdapter(this,
								listItems,
								R.layout.items,
								new String[] { "title", "image" },
								new int[] {R.id.title, R.id.image }
		); // ����SimpleAdapter
		gridview.setAdapter(adapter); // ����������GridView����
		/*********************************************************************************/
		/**********************ʹ��BaseAdapterָ��Ҫ��ʾ������*****************************/
//		BaseAdapter adapter=new BaseAdapter() {
//			
//			@Override
//			public View getView(int position, View convertView, ViewGroup parent) {
//				ImageView imageview;	//����ImageView�Ķ���
//				if(convertView==null){
//					imageview=new ImageView(MainActivity.this);	//ʵ����ImageView�Ķ���
//					imageview.setScaleType(ImageView.ScaleType.CENTER_INSIDE);	//�������ŷ�ʽ
//					imageview.setPadding(5, 0, 5, 0);		//����ImageView���ڱ߾�
//				}else{
//					imageview=(ImageView)convertView;
//				}
//				imageview.setImageResource(imageId[position]);	//ΪImageView����Ҫ��ʾ��ͼƬ
//				return imageview;	//����ImageView
//			}
//			
//			/* 
//			 * ���ܣ���õ�ǰѡ���ID
//			 * (non-Javadoc)
//			 * @see android.widget.Adapter#getItemId(int)
//			 */
//			@Override
//			public long getItemId(int position) {
//				return position;
//			}
//			
//			/* 
//			 * ���ܣ���õ�ǰѡ��
//			 * (non-Javadoc)
//			 * @see android.widget.Adapter#getItem(int)
//			 */
//			@Override
//			public Object getItem(int position) {
//				return position;
//			}
//			
//			/*
//			 * �������
//			 *  (non-Javadoc)
//			 * @see android.widget.Adapter#getCount()
//			 */
//			@Override
//			public int getCount() {
//				return imageId.length;
//			}
//		};
//		gridview.setAdapter(adapter); // ����������GridView����
		/*********************************************************************************/
	}
}