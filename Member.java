package com.example.pceaciiko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Member extends Activity{
		Button b1,b2;
		   TextView tx1;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.member);
	        
	        b1=(Button)findViewById(R.id.button1);
	        b2=(Button)findViewById(R.id.button2);
	        tx1=(TextView)findViewById(R.id.textView1);
	       
	        
	        b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intentLogIn=new Intent(getApplicationContext(),Login.class);
					startActivity(intentLogIn);
					
				}
			});
	        b2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intentSignup=new Intent (getApplicationContext(),Transaction.class);
					startActivity(intentSignup);
				}
			});
	       
	    }

}
