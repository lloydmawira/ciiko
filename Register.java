package com.example.pceaciiko;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {
    EditText First_Name,Last_Name,User_Name,Phone_Number,Gender,Address,Password,Confirm,Member_ID;
    Button reg;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Member_ID=(EditText)findViewById(R.id.MemberID);
        First_Name=(EditText)findViewById(R.id.editFirstName);
        Last_Name=(EditText)findViewById(R.id.editLastName);
        User_Name=(EditText)findViewById(R.id.userName);
        Phone_Number=(EditText)findViewById(R.id.phoneNO);
        Gender=(EditText)findViewById(R.id.gender);
        Address=(EditText)findViewById(R.id.district);
        Password=(EditText)findViewById(R.id.editTextPassword);
        Confirm=(EditText)findViewById(R.id.editTextConfirmPassword);

        reg=(Button)findViewById(R.id.btn_register);
    }
    public void register(View view){
        if(Member_ID.getText().toString().equals("")||First_Name.getText().toString().equals("")||Last_Name.getText().toString().equals("")||User_Name.getText().toString().equals("")||Phone_Number.getText().toString().equals("")||Gender.getText().toString().equals("")||Address.getText().toString().equals("")||Password.getText().toString().equals("")||Confirm.getText().toString().equals("")){
      builder=new AlertDialog.Builder(Register.this);
            builder.setTitle("something went wrong");
            builder.setMessage("all fields must be filled");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
        else if(!Password.getText().toString().equals(Confirm.getText().toString())||(Password.length() < 6)){
        	builder=new AlertDialog.Builder(Register.this);
            builder.setTitle("something went wrong");
            builder.setMessage("passwords does not match or less than six characters");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Password.setText("");
                    Confirm.setText("");
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
        else {
            BackRegisterCustomer backregistercustomer=new BackRegisterCustomer(Register.this);
            backregistercustomer.execute("register",Member_ID.getText().toString(),First_Name.getText().toString(),Last_Name.getText().toString(),User_Name.getText().toString(),Phone_Number.getText().toString(),Gender.getText().toString(),Address.getText().toString(),Password.getText().toString());


        }
    }
}

