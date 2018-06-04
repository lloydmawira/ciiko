package com.example.pceaciiko;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberAfterLogin extends Activity{
	
			Button b1,b2,b3,b4,b5,b6;
			   TextView tx,tx1,tx2,CC;
			   

		    @Override
		    protected void onCreate(Bundle savedInstanceState){
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.member_after_login);
		        
		        b1=(Button)findViewById(R.id.button1);
		        b2=(Button)findViewById(R.id.button2);
		        b3=(Button)findViewById(R.id.button3);
		        b4=(Button)findViewById(R.id.button4);
		        b5=(Button)findViewById(R.id.button5);
		        b6=(Button)findViewById(R.id.button6);
		        tx=(TextView)findViewById(R.id.textView);
		        tx1=(TextView)findViewById(R.id.textView1);
		        tx2=(TextView)findViewById(R.id.textView2);

		        
		        b1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intentTrip=new Intent(getApplicationContext(),Youth.class);
						startActivity(intentTrip);
						
					}
				});
		        b2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intentBooking=new Intent (getApplicationContext(),PCMF.class);
						startActivity(intentBooking);
					}
				});
                b3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intentViewRoute=new Intent (getApplicationContext(),WomensGuild.class);
						startActivity(intentViewRoute);
					}
				});
                b4.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intentTransaction=new Intent (getApplicationContext(),ChurchSchool.class);
						startActivity(intentTransaction);
					}
				});
                b5.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intentTransaction=new Intent (getApplicationContext(),BoysAndGirlsBrigade.class);
						startActivity(intentTransaction);
					}
				});
                b6.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intentTransaction=new Intent (getApplicationContext(),ChristianEducation.class);
						startActivity(intentTransaction);
					}
				});
		    }

	}

