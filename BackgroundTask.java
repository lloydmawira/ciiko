package com.example.pceaciiko;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.app.AlertDialog;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by LLOYD on 16/10/2016.
 */
public class BackgroundTask extends AsyncTask<String, String, String> {
    String register_url="http://10.0.2.2/login/Register.php";
    String login_url="http://10.0.2.2/login/login.php";
    Context context;
    ProgressDialog progressDialog;
    Activity activity;
    AlertDialog.Builder builder;
    public BackgroundTask(Context context){
        this.context=context;
        activity=(Activity)context;
    }
    @Override
    protected void onPreExecute() {
       builder=new AlertDialog.Builder(activity);
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("please wait");
        progressDialog.setMessage("connecting to server");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        String method=params[0];
        if(method.equals("register")){
            try {
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String Customer_ID=params[1];
                String First_Name=params[2];
                String Last_Name=params[3];
                String User_Name=params[4];
                String Phone_Number=params[5];
                String Gender=params[6];
                String Address=params[7];
                String Password=params[8];
             
                String data= URLEncoder.encode("Customer_ID","UTF-8")+"="+URLEncoder.encode(Customer_ID,"UTF-8")+"&"+
                		URLEncoder.encode("First_Name","UTF-8")+"="+URLEncoder.encode(First_Name,"UTF-8")+"&"+
                        URLEncoder.encode("Last_Name","UTF-8")+"="+URLEncoder.encode(Last_Name,"UTF-8")+"&"+
                        URLEncoder.encode("User_Name","UTF-8")+"="+URLEncoder.encode(User_Name,"UTF-8")+"&"+
                        URLEncoder.encode("Phone_Number","UTF-8")+"="+URLEncoder.encode(Phone_Number,"UTF-8")+"&"+
                        URLEncoder.encode("Gender","UTF-8")+"="+URLEncoder.encode(Gender,"UTF-8")+"&"+
                        URLEncoder.encode("Address","UTF-8")+"="+URLEncoder.encode(Address,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(Password,"UTF-8");
                        
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    stringBuilder.append(line+"\n");
                }
                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();
            }catch (MalformedURLException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}

        else
        	if(method.equals("login")){
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String User_Name=params[1];
                String Password=params[2];
                String data= URLEncoder.encode("User_Name","UTF-8")+"="+URLEncoder.encode(User_Name,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(Password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    stringBuilder.append(line+"\n");
                }
                httpURLConnection.disconnect();
                Thread.sleep(1000);
                System.out.println(stringBuilder.toString());
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

   /* @Override
    protected void onProgressUpdate(String.. values) {
        super.onProgressUpdate(values);
    }*/

    @Override
    protected void onPostExecute(String Json) {
        try {
            progressDialog.dismiss();
            JSONObject jsonObject=new JSONObject(Json);
            JSONArray jsonArray=jsonObject.getJSONArray("server_response");
            JSONObject JO=jsonArray.getJSONObject(0);
            String code=JO.getString("code");
            String message=JO.getString("message");
            String customerId =JO.getString("customer_id");
            showDialog("Customer ID: "+customerId,message,code);
            saveCustomerId(customerId.trim());
            
          if(code.equals("reg_true")){
              showDialog("Registration success....Thank you",message,code);
          }
            else if (code.equals("reg_false")){
              showDialog("Registration failed.....Try again",message,code);
          }
            else if(code.equals("login_true")){
              Intent intent=new Intent(activity,MemberAfterLogin.class);
              intent.putExtra("message",message);
               activity.startActivity(intent);
          }
            else if(code.equals("login_false")){
              showDialog("Login Error.....Try again",message,code);
          }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void showDialog(String title,String message,String code){
    builder.setTitle(title);
        if(code.equals("reg_true")||code.equals("reg_false")){
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.finish();
                }
            });
        }
        else if(code.equals("login_false")){
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText User_Name,Password;
                    User_Name=(EditText)activity.findViewById(R.id.userName);
                    Password=(EditText)activity.findViewById(R.id.Password);

                    User_Name.setText("");
                    Password.setText("");
                    dialog.dismiss();
                }
            });
        }
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
    private void saveCustomerId(String customerId){
    	SharedPreferences sharedPreferences = activity.getSharedPreferences("app",Context.MODE_PRIVATE);
    	SharedPreferences.Editor edit = sharedPreferences.edit();
    	edit.putString("customer_id",customerId);
    	edit.commit();
    }
}
