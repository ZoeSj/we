package cn.buaa.myweixin;
//Download by http://www.codefans.net
import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class ViewPicturesActivity extends Activity {
	ImageSwitcher imageSwitcher;  //声明ImageSwitcher对象，图片显示区域
	Gallery gallery;              //声明Gallery对象，图片列表索引
	int imagePosition;            //标记图片数组下标，用于循环显示
	//声明图片整型数组
	private int[] images = {
			R.drawable.b1,R.drawable.b2,
			R.drawable.b3,R.drawable.b4,
			R.drawable.b5,R.drawable.b6,
			R.drawable.b7,R.drawable.b8,
			R.drawable.b9,R.drawable.b10,
			R.drawable.b11,R.drawable.b12,
			R.drawable.b13,R.drawable.g1,
			R.drawable.g2,R.drawable.g3,
			R.drawable.g4};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);
        //通过控件的ID获得imageSwitcher的对象
        imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
        //设置自定义的图片显示工厂类
        imageSwitcher.setFactory(new MyViewFactory(this));
        //通过控件的ID获得gallery的对象
        gallery = (Gallery) findViewById(R.id.gallery);
        //设置自定义的图片适配器
        gallery.setAdapter(new ImageAdapter(this));  
        //实现被选中的事件监听器
        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {               	
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//通过求余数，循环显示图片
				imageSwitcher.setImageResource(images[position%images.length]);				
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub				
			}
		});        
    }
    
    //自定义图片适配器，继承BaseAdapter
    class ImageAdapter extends BaseAdapter{    	
		private Context context;  //定义上下文
		
		//参数为上下文的构造方法
		public ImageAdapter(Context context) {
			this.context = context;
		}
    	
		//得到图片的大小
		@Override
		public int getCount() {	  //设置为整型的最大数
			return Integer.MAX_VALUE;
		}

		//得到指定图片的对象
		@Override
		public Object getItem(int position) {			
			return null;
		}
		
		//得到指定图片的对象的ID
		@Override
		public long getItemId(int position) {			
			return 0;
		}

		//显示图标列表
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView iv = new ImageView(context);  //创建ImageView对象
			iv.setImageResource(images[position%images.length]);   //设置循环显示图片
			iv.setAdjustViewBounds(true);	//图片自动调整显示
			//设置图片的宽和高
			iv.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			return iv;  //返回ImageView对象
		}    	
    }
    
    //自定义图片显示工厂类，继承ViewFactory
    class MyViewFactory implements ViewFactory{
		private Context context;  //定义上下文
		
		//参数为上下文的构造方法
		public MyViewFactory(Context context) {
			this.context = context;
		}

		//显示图标区域
    	@Override
		public View makeView() {
			ImageView iv = new ImageView(context);  //创建ImageView对象
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);  //图片自动居中显示
			//设置图片的宽和高
			iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
			return iv;  //返回ImageView对象
		}    	
    }    
}