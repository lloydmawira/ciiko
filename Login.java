package com.example.pceaciiko;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends Activity 
  {
    Button LogIn;
    EditText User_Name,Password;
    TextView tv1,tv2;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv1=(TextView)findViewById(R.id.User_Name);
        tv2=(TextView)findViewById(R.id.Password);
        User_Name=(EditText)findViewById(R.id.uname);
        Password=(EditText)findViewById(R.id.password);
        LogIn = (Button) findViewById(R.id.btn_login);
    }
    public void login(View view)
    {
        if(User_Name.getText().toString().equals("")||Password.getText().toString().equals("")){
      builder=new AlertDialog.Builder(Login.this);
            builder.setTitle("oops! something went wrong");
            builder.setMessage("all fields must be filled");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	
                @Override
                public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }else{
        BackgroundTask backgroundTask=new BackgroundTask(Login.this);
        backgroundTask.execute("login",User_Name.getText().toString(),Password.getText().toString());
        
    }
        }
}
