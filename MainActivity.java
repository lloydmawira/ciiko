package com.example.pceaciiko;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button b1,b2;
    TextView tx1,tx2,tx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.member);
        b2=(Button)findViewById(R.id.administrator);
        tx1=(TextView)findViewById(R.id.textView1);
        tx2=(TextView)findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intentCustomer=new Intent(getApplicationContext(),Member.class);
                startActivity(intentCustomer);

            }
        });
        
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intentMatOwner=new Intent(getApplicationContext(),Admin.class);
                startActivity(intentMatOwner);
            }
        });
    }}
