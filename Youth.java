package com.example.pceaciiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Youth extends Activity{
	
	Button b1,b2,b3,b4,b5,b6,b7;
	   TextView tx1,tx2;
	   

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youthmain);
        
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        tx1=(TextView)findViewById(R.id.textView1);
        tx2=(TextView)findViewById(R.id.textView2);

        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentTrip=new Intent(getApplicationContext(),YouthRegister.class);
				startActivity(intentTrip);
				
			}
		});
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentBooking=new Intent (getApplicationContext(),YouthMissionAndVision.class);
				startActivity(intentBooking);
			}
		});
        b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentViewRoute=new Intent (getApplicationContext(),YouthMeetings.class);
				startActivity(intentViewRoute);
			}
		});
        b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentTransaction=new Intent (getApplicationContext(),YouthUpcomingEvents.class);
				startActivity(intentTransaction);
			}
		});
        b5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentTransaction=new Intent (getApplicationContext(),YouthLeadership.class);
				startActivity(intentTransaction);
			}
		});
        b6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentTransaction=new Intent (getApplicationContext(),YouthPostInfo.class);
				startActivity(intentTransaction);
			}
		});
        b7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentTransaction=new Intent (getApplicationContext(),BackYouth.class);
				startActivity(intentTransaction);
			}
		});
    }
}

