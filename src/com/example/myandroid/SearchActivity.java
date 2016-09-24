package com.example.myandroid;

import cn.buaa.myweixin.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 搜索模块
 * */

public class SearchActivity extends Activity {

	// 导航条linearlayout作为按钮
	private LinearLayout mSearch_city, mSearch_search;
	// listview样式linearlayout作为按钮
	private LinearLayout bibei,clothes,daiyuse,dietary,military,stationery,tools,trip,xdq,yiyao,zhusu;
	// 语音识别按钮
	private ImageView mSearch_button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main11);
		initView();
	}

	private void initView() {
		// 导航条linearlayout作为按钮
		mSearch_city = (LinearLayout) findViewById(R.id.Search_city);
		mSearch_search = (LinearLayout) findViewById(R.id.Search_search);
		mSearch_button1 = (ImageView) findViewById(R.id.Search_button1);

		// listview样式linearlayout作为按钮
		bibei = (LinearLayout) findViewById(R.id.bibei);
		daiyuse = (LinearLayout) findViewById(R.id.xihuyongpin);
		clothes = (LinearLayout) findViewById(R.id.yiwu);
		dietary = (LinearLayout) findViewById(R.id.yinshi);
		zhusu = (LinearLayout) findViewById(R.id.zhusu);
		trip = (LinearLayout) findViewById(R.id.chuxing);
		xdq = (LinearLayout) findViewById(R.id.xiaoxingdianqi);
		tools = (LinearLayout) findViewById(R.id.xiaogongju);
		yiyao = (LinearLayout) findViewById(R.id.yiyao);
		military = (LinearLayout) findViewById(R.id.junxun);
		stationery = (LinearLayout) findViewById(R.id.xuexiyongpin);
		MyOnclickListener mOnclickListener = new MyOnclickListener();
		mSearch_city.setOnClickListener(mOnclickListener);
		mSearch_search.setOnClickListener(mOnclickListener);
		mSearch_button1.setOnClickListener(mOnclickListener);
		daiyuse.setOnClickListener(mOnclickListener);
		bibei.setOnClickListener(mOnclickListener);
		clothes.setOnClickListener(mOnclickListener);
		daiyuse.setOnClickListener(mOnclickListener);
		zhusu.setOnClickListener(mOnclickListener);
		tools.setOnClickListener(mOnclickListener);
		trip.setOnClickListener(mOnclickListener);
		xdq.setOnClickListener(mOnclickListener);
		military.setOnClickListener(mOnclickListener);
		stationery.setOnClickListener(mOnclickListener);
		yiyao.setOnClickListener(mOnclickListener);

	}

	private class MyOnclickListener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
			switch (mID) {
			case R.id.bibei:
				Intent intent = new Intent(SearchActivity.this,
						BiBei.class);
				SearchActivity.this.startActivity(intent);
				break;
			case R.id.xihuyongpin:
				Intent intent1 = new Intent(SearchActivity.this,
						DailyUse.class);
				SearchActivity.this.startActivity(intent1);
				break;
			case R.id.yiwu:
				Intent intent2 = new Intent(SearchActivity.this,
						Clothes.class);
				SearchActivity.this.startActivity(intent2);
				break;
			case R.id.yinshi:
				Intent intent3 = new Intent(SearchActivity.this,
						Dietary.class);
				SearchActivity.this.startActivity(intent3);
				break;
			case R.id.zhusu:
				Intent intent4 = new Intent(SearchActivity.this,
						ZhuSu.class);
				SearchActivity.this.startActivity(intent4);
				break;
			case R.id.chuxing:
				Intent intent5 = new Intent(SearchActivity.this,
						Trip.class);
				SearchActivity.this.startActivity(intent5);
				break;
			case R.id.xiaoxingdianqi:
				Intent intent6 = new Intent(SearchActivity.this,
						XiaoDianQi.class);
				SearchActivity.this.startActivity(intent6);
				break;
			case R.id.xiaogongju:
				Intent intent7 = new Intent(SearchActivity.this,
						Tools.class);
				SearchActivity.this.startActivity(intent7);
				break;
			case R.id.yiyao:
				Intent intent8 = new Intent(SearchActivity.this,
						YiYao.class);
				SearchActivity.this.startActivity(intent8);
				break;
			case R.id.junxun:
				Intent intent9 = new Intent(SearchActivity.this,
						Military.class);
				SearchActivity.this.startActivity(intent9);
				break;
			case R.id.xuexiyongpin:
				Intent intent10 = new Intent(SearchActivity.this,
						Stationery.class);
				SearchActivity.this.startActivity(intent10);
				break;
			// case R.id.Search_list_huiyuanka:
			// Intent intent8 = new Intent(SearchActivity.this,
			// TuanDetailsActivity.class);
			// SearchActivity.this.startActivity(intent8);
			// break;
			}
		}

	}
}
