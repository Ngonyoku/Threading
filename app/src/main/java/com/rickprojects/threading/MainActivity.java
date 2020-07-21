package com.rickprojects.threading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void stopThread(View view) {
    }

    public void startThread(View view) {
//        new ExampleThread(10).start(); /*------Method 1------*/
        new Thread(new ExammpleRunnable(10)).start(); /*------Method 2------*/
    }

    /**
     * ------Method 1------
     * We can create an Inner class that Extends from the Thread Class and override the
     * run() method. We the do all the work on the run() method.
     */
    class ExampleThread extends Thread {
        int seconds;

        ExampleThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ------Method 2------
     * We can also create an Inner class which will Implement the Runnable Interface and override
     * the run() method. All the Work is done on the overriden run() method
     */
    class ExammpleRunnable implements Runnable {
        int seconds;

        public ExammpleRunnable(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}