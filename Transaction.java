package com.example.pceaciiko;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Transaction extends Activity {
    EditText Transaction_NO,Amount,Confirm;
    Button reg;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction);
        Transaction_NO=(EditText)findViewById(R.id.Transaction_NO);
        Amount=(EditText)findViewById(R.id.editAmount);
        Confirm=(EditText)findViewById(R.id.ConfirmTransaction_NO);

        reg=(Button)findViewById(R.id.btn_register);
    }
    public void submit(View view){
        if(Transaction_NO.getText().toString().equals("")||Amount.getText().toString().equals("")||Confirm.getText().toString().equals("")){
      builder=new AlertDialog.Builder(Transaction.this);
            builder.setTitle("something went wrong");
            builder.setMessage("all fields should be filled");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
        else if(!Transaction_NO.getText().toString().equals(Confirm.getText().toString())||(Transaction_NO.length() < 10)||(Transaction_NO.length() > 10)){
        	builder=new AlertDialog.Builder(Transaction.this);
            builder.setTitle("Oops! something went wrong");
            builder.setMessage("Transaction_NO does not match OR does not exist");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Transaction_NO.setText("");
                    Confirm.setText("");
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
        else {
            BackTransaction backtransaction=new BackTransaction(Transaction.this);
            backtransaction.execute("submit",Transaction_NO.getText().toString(),Amount.getText().toString());


        }
    }
}
