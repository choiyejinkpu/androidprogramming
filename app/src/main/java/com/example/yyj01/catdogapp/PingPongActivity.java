package com.example.yyj01.catdogapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.camera2.params.BlackLevelPattern;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

public class PingPongActivity extends AppCompatActivity {
    MySurfaceView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_pong);

        Display display=getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);
        Ball.WIDTH=size.x;
        Ball.HEIGHT=size.y;

        view=new MySurfaceView(this);
        setContentView(view);
    }
}

class Ball {
    int x, y, xlnc = 1, ylnc = 1;
    int radius;
    static int WIDTH = 1080, HEIGHT = 1920;

    public Ball() {
        radius = WIDTH / 20;

        x = (int) (Math.random() * (WIDTH - radius));
        y = (int) (Math.random() * (HEIGHT - radius));
        x = x < radius ? radius : x;
        y = y < radius ? radius : y;

        xlnc = (int) (Math.random() * 30 + 1);
        ylnc = (int) (Math.random() * 30 + 1);
    }

    public void paint(Canvas g) {
        Paint paint = new Paint();

        if (x < radius || x > (WIDTH - radius))
            xlnc = -xlnc;
        if (y < radius || y > (HEIGHT - radius))
            ylnc = -ylnc;

        x += xlnc;
        y += ylnc;

        paint.setColor(Color.RED);
        g.drawCircle(x, y, radius, paint);
    }
}
class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public Ball basket[] = new Ball[1];
    private MyThread thread;

    public MySurfaceView(Context context) {
        super(context);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        thread = new MyThread(holder);
        for (int i = 0; i < 1; i++) {
            basket[i] = new Ball();
        }

    }

    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;

        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    public class MyThread extends Thread {
        private boolean mRun = false;
        private SurfaceHolder mSurfaceHolder;

        public MyThread(SurfaceHolder surfaceHolder) {
            mSurfaceHolder = surfaceHolder;
        }

        public void run() {
            while (mRun) {
                Canvas c = null;
                try {
                    c = mSurfaceHolder.lockCanvas(null);
                    c.drawColor(Color.BLACK);
                    synchronized (mSurfaceHolder) {
                        for (Ball b : basket) {
                            b.paint(c);
                        }
                    }
                } finally {
                    if (c != null) {
                        mSurfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }

        public void setRunning(boolean b) {
            mRun = b;
        }
    }
}