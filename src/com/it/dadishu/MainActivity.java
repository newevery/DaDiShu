package com.it.dadishu;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	int index;
	int longth=10*1000;
	int time=0;	
	ImageButton[] btns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btns = new ImageButton[6];

		btns[0] = (ImageButton) findViewById(R.id.imageButton1);
		btns[1] = (ImageButton) findViewById(R.id.imageButton2);
		btns[2] = (ImageButton) findViewById(R.id.imageButton3);
		btns[3] = (ImageButton) findViewById(R.id.imageButton4);
		btns[4] = (ImageButton) findViewById(R.id.imageButton5);
		btns[5] = (ImageButton) findViewById(R.id.imageButton6);

		new Thread(new Runnable() {
			@Override
			public void run(){
				while (time<longth){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					time=time+2000;
					index = new Random().nextInt(6);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							btns[index]
									.setImageResource(R.drawable.ic_launcher);
							btns[index].setTag("dishu");
						}
					});
				}
				System.out.println("qwer"+score);
				runOnUiThread(new Runnable() {
					public void run () {
						Toast.makeText(MainActivity.this, "" + score, 1).show();
					}
					
					
				});

			}
		}).start();
	}

	int score;

	public void fun(View view) {
		ImageButton btn = (ImageButton) view;
		String tag =  (String) btn.getTag();
		if ("dishu".equals(tag)) {
			score++; 
			btn.setImageResource(R.drawable.z8);
			btn.setTag("qwer");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
