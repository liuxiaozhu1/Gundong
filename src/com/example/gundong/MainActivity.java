package com.example.gundong;
import android.app.Activity;  
import android.os.Bundle;  
import android.support.v4.view.PagerAdapter;  
import android.support.v4.view.ViewPager;  
import android.support.v4.view.ViewPager.OnPageChangeListener;  
import android.view.View;  
import android.view.ViewGroup;  
import android.view.ViewGroup.LayoutParams;  
import android.widget.ImageView;  
import android.widget.LinearLayout;  
  
public class MainActivity extends Activity implements OnPageChangeListener{  
    /** 
     * ViewPager 
     */  
    private ViewPager viewPager;  
      
    /** 
     * װ����ImageView���� 
     */  
    private ImageView[] tips;  
      
    /** 
     * װImageView���� 
     */  
    private ImageView[] mImageViews;  
      
    /** 
     * ͼƬ��Դid 
     */  
    private int[] imgIdArray ;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main); 
        //���group
        ViewGroup group = (ViewGroup)findViewById(R.id.viewGroup); 
        //���viewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);  
          
        //����ͼƬ��ԴID   
        imgIdArray = new int[]{R.drawable.t1, R.drawable.t2, R.drawable.t3, R.drawable.t4,  
                R.drawable.t5,R.drawable.tu, R.drawable.lanhua, R.drawable.xiantiao};  
          
          
        //�������뵽ViewGroup��   
        tips = new ImageView[imgIdArray.length];  
        for(int i=0; i<tips.length; i++){  
        	//����imageView��ʵ����
            ImageView imageView = new ImageView(this);  
            //����ÿ��imageView�ĳ���Ϊ10
            imageView.setLayoutParams(new LayoutParams(10,10));  
            //��imageView��ӵ�tips����
            tips[i] = imageView;  
//            if(i == 0){  
//                tips[i].setBackgroundResource(R.drawable.hd);  
//            }else{  
//                tips[i].setBackgroundResource(R.drawable.hd);  
//            }  
//            ����LinearLayout�ĳ��Ϳ�
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,    
                    LayoutParams.WRAP_CONTENT));  
            //����ԭ��ͼƬ��߾���Ϊ5
            layoutParams.leftMargin = 5; 
            //����ԭ���ұ߾���Ϊ5
            layoutParams.rightMargin = 5;  
            //��imageView�����õ�layoutParams��ӵ�group
            group.addView(imageView, layoutParams);  
        }  
          
          
        //��ͼƬװ�ص�������   
        mImageViews = new ImageView[imgIdArray.length];  
        for(int i=0; i<mImageViews.length; i++){  
        	//����imageview��ʵ����
            ImageView imageView = new ImageView(this);  
            //��
            mImageViews[i] = imageView; 
            //��ͼƬ��ӵ�imageView��
            imageView.setBackgroundResource(imgIdArray[i]);  
        }  
          
        //����Adapter   
        viewPager.setAdapter(new MyAdapter());  
        //���ü�������Ҫ�����õ��ı���   
        viewPager.setOnPageChangeListener(this);  
        //����ViewPager��Ĭ����, ����Ϊ���ȵ�100���������ӿ�ʼ�������󻬶�   
        viewPager.setCurrentItem((mImageViews.length) * 100);  
          
    }  
    /** 
     *  
     * @author xiaanming 
     * 
     */  
    public class MyAdapter extends PagerAdapter{  
  
        @Override  
        public int getCount() {  
            return Integer.MAX_VALUE;  
        }  
  
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {  
            return arg0 == arg1;  
        }  
  
        @Override  
        public void destroyItem(View container, int position, Object object) {  
            ((ViewPager)container).removeView(mImageViews[position % mImageViews.length]);  
              
        }  
  
        /** 
         * ����ͼƬ��ȥ���õ�ǰ��position ���� ͼƬ���鳤��ȡ�����ǹؼ� 
         */  
        @Override  
        public Object instantiateItem(View container, int position) {  
            ((ViewGroup) container).addView(mImageViews[position % mImageViews.length], 0);  
            return mImageViews[position % mImageViews.length];  
        }  
          
          
          
    }  
  
    @Override  
    public void onPageScrollStateChanged(int arg0) {  
          
    }  
  
    @Override  
    public void onPageScrolled(int arg0, float arg1, int arg2) {  
          
    }  
  
    @Override  
    public void onPageSelected(int arg0) {  
        setImageBackground(arg0 % mImageViews.length);  
    }  
      
    /** 
     * ����ѡ�е�tip�ı��� 
     * @param selectItems 
     */  
    private void setImageBackground(int selectItems){  
        for(int i=0; i<tips.length; i++){  
            if(i == selectItems){  
                tips[i].setBackgroundResource(R.drawable.hd);  
            }else{  
                tips[i].setBackgroundResource(R.drawable.bd);  
            }  
        }  
    }  
  
}  
