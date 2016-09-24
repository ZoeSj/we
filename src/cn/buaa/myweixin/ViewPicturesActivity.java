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
	ImageSwitcher imageSwitcher;  //����ImageSwitcher����ͼƬ��ʾ����
	Gallery gallery;              //����Gallery����ͼƬ�б�����
	int imagePosition;            //���ͼƬ�����±꣬����ѭ����ʾ
	//����ͼƬ��������
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
        //ͨ���ؼ���ID���imageSwitcher�Ķ���
        imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
        //�����Զ����ͼƬ��ʾ������
        imageSwitcher.setFactory(new MyViewFactory(this));
        //ͨ���ؼ���ID���gallery�Ķ���
        gallery = (Gallery) findViewById(R.id.gallery);
        //�����Զ����ͼƬ������
        gallery.setAdapter(new ImageAdapter(this));  
        //ʵ�ֱ�ѡ�е��¼�������
        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {               	
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//ͨ����������ѭ����ʾͼƬ
				imageSwitcher.setImageResource(images[position%images.length]);				
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub				
			}
		});        
    }
    
    //�Զ���ͼƬ���������̳�BaseAdapter
    class ImageAdapter extends BaseAdapter{    	
		private Context context;  //����������
		
		//����Ϊ�����ĵĹ��췽��
		public ImageAdapter(Context context) {
			this.context = context;
		}
    	
		//�õ�ͼƬ�Ĵ�С
		@Override
		public int getCount() {	  //����Ϊ���͵������
			return Integer.MAX_VALUE;
		}

		//�õ�ָ��ͼƬ�Ķ���
		@Override
		public Object getItem(int position) {			
			return null;
		}
		
		//�õ�ָ��ͼƬ�Ķ����ID
		@Override
		public long getItemId(int position) {			
			return 0;
		}

		//��ʾͼ���б�
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView iv = new ImageView(context);  //����ImageView����
			iv.setImageResource(images[position%images.length]);   //����ѭ����ʾͼƬ
			iv.setAdjustViewBounds(true);	//ͼƬ�Զ�������ʾ
			//����ͼƬ�Ŀ�͸�
			iv.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			return iv;  //����ImageView����
		}    	
    }
    
    //�Զ���ͼƬ��ʾ�����࣬�̳�ViewFactory
    class MyViewFactory implements ViewFactory{
		private Context context;  //����������
		
		//����Ϊ�����ĵĹ��췽��
		public MyViewFactory(Context context) {
			this.context = context;
		}

		//��ʾͼ������
    	@Override
		public View makeView() {
			ImageView iv = new ImageView(context);  //����ImageView����
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);  //ͼƬ�Զ�������ʾ
			//����ͼƬ�Ŀ�͸�
			iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
			return iv;  //����ImageView����
		}    	
    }    
}