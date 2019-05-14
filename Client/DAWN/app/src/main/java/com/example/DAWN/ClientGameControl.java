package com.example.DAWN;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.*;

import java.lang.*;
import java.util.Arrays;

import android.graphics.*;


public class ClientGameControl extends AppCompatActivity {
    Intent intent = getIntent();

    private Button Lbutton,Rbutton,Ubutton,Dbutton ;
    private TextView testtxt ;
    private ImageView myroleview ;
    private Data dataclass;

    //屏幕左上角为{0,0}，我的角色的绝对位置为{860,0}，相对（地图）位置为{x,y}
    //则地图相对位置为{-x,-y}，绝对位置{860-x,0-y}
    //其他角色绝对位置为{840-x+m,430-y+n}
    //(所有图片的左上角为判定点）

    private int direction = 3;
    float[] location={0,0}; //当前位置

    private Map map;
    private Role myrole;
    int vision=20;//视野范围

    //AsyncTask for TCP-client.
    private class AsyncConTCP extends AsyncTask<String ,Void, Void>{
        @Override
        protected Void doInBackground(String... s2) {
            RunnableTCP R1 = new RunnableTCP( "Thread-TCP");
//            R1.start(Arrays.toString (location));
            R1.start(s2[0]);
            return null;
        }

//        @Override
//        protected void onProgressUpdate(String... values) { super.onProgressUpdate (values);}
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute (aVoid);
//        }
    }

    // AsyncTask for UDP-Client
    private class AsyncConUDP extends AsyncTask<String, String, Void> {
        @Override
        protected Void doInBackground(String... s2) {
            RunnableUDP R1 = new RunnableUDP ("Thread-UDP");
            R1.start ();
            return null;
        }

//        @Override
//        protected void onProgressUpdate(String... values) { super.onProgressUpdate (values);        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute (aVoid);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_process);

        testtxt= findViewById(R.id.Fortest);
        testtxt.setText("loading... ");
        testtxt.setText(Arrays.toString(location));

        myroleview = findViewById(R.id.Myrole);
        dataclass = new Data ();
        MapInit();

        //对上下左右进行监听
        Lbutton= findViewById(R.id.Lbutton);
        Lbutton.setOnTouchListener(new View.OnTouchListener(){
            private Boolean longclicked=false;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // TODO Auto-generated method stub
//                handler.postDelayed(task, 1000);
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        longclicked=true;
                        Thread t = new Thread(){
                            public void run(){
                                super.run();
                                while (longclicked){
                                    Lmove();
                                    try{
                                        Thread.sleep(20);
                                    }catch(InterruptedException e){
                                        e.printStackTrace();
                                    }

                                }
                            }
                        };
                        t.start();
                        break;
                    case MotionEvent.ACTION_UP:
                        longclicked = false;
                        break;
                }
                return true;
            }
        });
        Rbutton= findViewById(R.id.Rbutton);
        Rbutton.setOnTouchListener(new View.OnTouchListener(){
            private Boolean longclicked=false;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // TODO Auto-generated method stub
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        longclicked=true;
                        Thread t = new Thread(){
                            public void run(){
                                super.run();
                                while (longclicked){
                                    Rmove();
                                    try{
                                        Thread.sleep(20);
                                    }catch(InterruptedException e){
                                        e.printStackTrace();
                                    }

                                }
                            }
                        };
                        t.start();
                        break;
                    case MotionEvent.ACTION_UP:
                        longclicked = false;
                        break;
                }
                return true;
            }
        });
        Ubutton= findViewById(R.id.Ubutton);
        Ubutton.setOnTouchListener(new View.OnTouchListener(){
            private Boolean longclicked=false;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // TODO Auto-generated method stub
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        longclicked=true;
                        Thread t = new Thread(){
                            public void run(){
                                super.run();
                                while (longclicked){
                                    Umove();
                                    try{
                                        Thread.sleep(20);
                                    }catch(InterruptedException e){
                                        e.printStackTrace();
                                    }

                                }
                            }
                        };
                        t.start();
                        break;
                    case MotionEvent.ACTION_UP:
                        longclicked = false;
                        break;
                }
                return true;
            }
        });
        Dbutton= findViewById(R.id.Dbutton);
        Dbutton.setOnTouchListener(new View.OnTouchListener(){
            private Boolean longclicked=false;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // TODO Auto-generated method stub
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        longclicked=true;
                        Thread t = new Thread(){
                            public void run(){
                                super.run();
                                while (longclicked){
                                    Dmove();
                                    try{
                                        Thread.sleep(20);
                                    }catch(InterruptedException e){
                                        e.printStackTrace();
                                    }

                                }
                            }
                        };
                        t.start();
                        break;
                    case MotionEvent.ACTION_UP:
                        longclicked = false;
                        break;
                }
                return true;
            }
        });

        handler.postDelayed(runnable, 1000 * 1);//等1s后开始刷新显示
//        handlerUDP.postDelayed(runnableUDP, 1000 * 1);//等1s后开始刷新位置UDP


        scr = findViewById(R.id.background) ;
        sfh = scr.getHolder();
        sfh.addCallback(new MyCallBack());
        draw = new Draw(sfh);
    }

    //上下左右按键的监听函数
    public void Lmove(){
        location[0]=location[0]-3;
        dataclass.location = location;
        if(direction == 0)
            direction = 4;
        else
            direction = 0;
    //    new AsyncConTCP ().execute ();
    }
    public void Rmove(){
      location[0]=location[0]+3;
        dataclass.location = location;
        if(direction == 1)
            direction = 5;
        else
            direction = 1;
  //      new AsyncConTCP ().execute ();
    }
    public void Umove(){
        location[1]=location[1]-3;
        dataclass.location = location;
        if(direction == 2)
            direction = 6;
        else
            direction = 2;
//        new AsyncConTCP ().execute ();
    }
    public void Dmove(){
        location[1]=location[1]+3;
        dataclass.location = location;
        if(direction == 3)
            direction = 7;
        else
            direction = 3;
  //      new AsyncConTCP ().execute ();
    }

    //Map初始化
    private Boolean MapInit(){
        //发送请求并将服务器传递过来的所有数据转化为Map对象
        //失败请return false
        //仅供测试
        map=new Map();
        Role_simple test_r1=new Role_simple();
        test_r1.location=new int[2];  test_r1.location[0]=100;  test_r1.location[1]=200;
        Role_simple test_r2=new Role_simple();
        test_r2.location=new int[2];  test_r2.location[0]=200;  test_r2.location[1]=400;
        map.livingrole.add(test_r1);
        map.livingrole.add(test_r2);


        //for drawing
        background = BitmapFactory.decodeResource(this.getResources(),R.drawable.map).copy(Bitmap.Config.ARGB_8888, true);
        //Rolepic load
        role_pic = new Bitmap[2][4][4];//人物数，方向数，每个方向动作帧数
        Resources res=getResources();
        String fname;
        for (int i=0;i<1;i++){
            for (int j=0;j<4;j++){
                for (int k=0;k<2;k++){
                    fname="r_"+Integer.toString(i)+"_"+Integer.toString(j)+"_"+Integer.toString(k);
                    role_pic[i][j][k]=BitmapFactory.decodeResource(this.getResources(),res.getIdentifier(fname,"drawable",getPackageName())).copy(Bitmap.Config.ARGB_8888, true);
                }
            }
        }

        return true;
    }


    //位置刷新UDP
    private Handler handlerUDP = new Handler();
    private Runnable runnableUDP = new Runnable() {
        public void run() {
            new AsyncConUDP ().execute ();
            location = dataclass.location;
            handlerUDP.postDelayed(this, 20);// 刷新间隔(ms)
        }
//        void update() {
//            location = dataclass.location;
//        }
    };

    //界面刷新
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
//            new AsyncConUDP ().execute ();
            this.update();
            handler.postDelayed(this, 20);// 刷新间隔(ms)
        }
        void update() {

            testtxt.setText(Arrays.toString(location));
            switch(direction){
                case 0 :
                    myroleview.setImageResource(R.drawable.r_0_0_0);
                    break;
                case 1 :
                    myroleview.setImageResource(R.drawable.r_0_1_0);
                    break;
                case 2 :
                    myroleview.setImageResource(R.drawable.r_0_2_0);
                    break;
                case 3 :
                    myroleview.setImageResource(R.drawable.r_0_3_0);
                    break;
                case 4 :
                    myroleview.setImageResource(R.drawable.r_0_0_1);
                    break;
                case 5 :
                    myroleview.setImageResource(R.drawable.r_0_1_1);
                    break;
                case 6 :
                    myroleview.setImageResource(R.drawable.r_0_2_1);
                    break;
                case 7 :
                    myroleview.setImageResource(R.drawable.r_0_3_1);
                    break;
            }
        }
    };


    //SurfaceView
    private SurfaceView scr;
    private SurfaceHolder sfh;
    private Draw draw;
    private Bitmap background;
    private Bitmap[][][] role_pic;//所有角色图的Bitmap点阵,第一层为角色，第二层为方向，第三层为动作
    class MyCallBack implements SurfaceHolder.Callback {
        @Override
        //当SurfaceView的视图发生改变，比如横竖屏切换时，这个方法被调用
        public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
        }
        //当SurfaceView被创建的时候被调用
        public void surfaceCreated(SurfaceHolder holder) {
            draw.isRun = true;
  //          c=new Canvas(background);
            draw.start();

        }
        //当SurfaceView被销毁的时候，比如不可见了，会被调用
        public void surfaceDestroyed(SurfaceHolder holder) {
            draw.isRun = false;
            testtxt.setText("end");
            sfh.removeCallback(this);
        }


    }
    class Draw extends Thread {
        private SurfaceHolder holder;
        public boolean isRun ;
        private Canvas c;
        public Draw(SurfaceHolder holder){
            this.holder =holder;
            isRun = true;
        }
        @Override
        public void run(){
            Role_simple r;
            Paint p = new Paint();
            //RadialGradient radialGradient = new RadialGradient(location[0],location[1],vision*10, Color.TRANSPARENT,Color.BLACK,Shader.TileMode.CLAMP);
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            int[] center_location=new int[2];
            center_location[0] = dm.widthPixels/2;
            center_location[1] = dm.heightPixels/2;

            while(isRun){
                c=null;
                try {
                    synchronized (holder) {
                        c = holder.lockCanvas();
                        //执行具体的绘制操作
                        c.drawColor(Color.WHITE);
                        c.drawBitmap(background, center_location[0] - location[0], center_location[1] - location[1], p);

                        for (int i=0;i<map.livingrole.size();i++) {
                            r = map.livingrole.get(i);
                            if (Math.abs(r.location[0] - location[0]) < vision * 10 && Math.abs(r.location[1] - location[1]) < vision * 10) {
                                continue;
                            }
                            c.drawBitmap(role_pic[r.id%100][r.direction][r.walk_mov],center_location[0] - location[0]+r.location[0],center_location[0] - location[1]+r.location[1],p);
                            if (r.walk_mov!=0){
                                r.walk_mov=(r.walk_mov+1)/3;//每个动作循环的帧数
                            }
                        }
                        //画黑雾
                        c.saveLayer(0, 0, center_location[0]*2+1, center_location[1]*2+1, p, Canvas.ALL_SAVE_FLAG);//保存上一层
                        p.setColor(Color.BLACK);
                        c.drawRect(0,0,center_location[0]*2+1, center_location[1]*2+1,p);
                        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                        c.drawCircle(center_location[0],center_location[1],vision*15,p);
                        p.setXfermode(null);
                        c.restore();
                    }
                    Thread.sleep(10);

                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    if (c != null) {
                        holder.unlockCanvasAndPost(c);
                    }
                }


            }
        }
    }




    //析构
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}
