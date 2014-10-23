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
     * 装点点的ImageView数组 
     */  
    private ImageView[] tips;  
      
    /** 
     * 装ImageView数组 
     */  
    private ImageView[] mImageViews;  
      
    /** 
     * 图片资源id 
     */  
    private int[] imgIdArray ;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main); 
        //获得group
        ViewGroup group = (ViewGroup)findViewById(R.id.viewGroup); 
        //获得viewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);  
          
        //载入图片资源ID   
        imgIdArray = new int[]{R.drawable.t1, R.drawable.t2, R.drawable.t3, R.drawable.t4,  
                R.drawable.t5,R.drawable.tu, R.drawable.lanhua, R.drawable.xiantiao};  
          
          
        //将点点加入到ViewGroup中   
        tips = new ImageView[imgIdArray.length];  
        for(int i=0; i<tips.length; i++){  
        	//定义imageView并实例化
            ImageView imageView = new ImageView(this);  
            //定义每个imageView的长宽为10
            imageView.setLayoutParams(new LayoutParams(10,10));  
            //把imageView添加到tips数组
            tips[i] = imageView;  
//            if(i == 0){  
//                tips[i].setBackgroundResource(R.drawable.hd);  
//            }else{  
//                tips[i].setBackgroundResource(R.drawable.hd);  
//            }  
//            配置LinearLayout的长和宽
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,    
                    LayoutParams.WRAP_CONTENT));  
            //设置原点图片左边距离为5
            layoutParams.leftMargin = 5; 
            //设置原点右边距离为5
            layoutParams.rightMargin = 5;  
            //把imageView和设置的layoutParams添加到group
            group.addView(imageView, layoutParams);  
        }  
          
          
        //将图片装载到数组中   
        mImageViews = new ImageView[imgIdArray.length];  
        for(int i=0; i<mImageViews.length; i++){  
        	//定义imageview并实例化
            ImageView imageView = new ImageView(this);  
            //把
            mImageViews[i] = imageView; 
            //把图片添加到imageView中
            imageView.setBackgroundResource(imgIdArray[i]);  
        }  
          
        //设置Adapter   
        viewPager.setAdapter(new MyAdapter());  
        //设置监听，主要是设置点点的背景   
        viewPager.setOnPageChangeListener(this);  
        //设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动   
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
         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键 
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
     * 设置选中的tip的背景 
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
