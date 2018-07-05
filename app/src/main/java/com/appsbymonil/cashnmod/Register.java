package com.appsbymonil.cashnmod;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.appsbymonil.cashnmod.R;

public class Register extends AppCompatActivity {

    DataBaseHelper myDb ;
TextInputEditText name1 , user , email1 , con , count , gen , pass;
    Button b1 , b2 , b3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDb = new DataBaseHelper(this);

        getId();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String name , username , email , contact , gender , country ;
                insertData();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1.setText(null);
                user.setText(null);
                email1.setText(null);
                con.setText(null);
                count.setText(null);
                gen.setText(null);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(Register.this , Login.class);
                startActivity(i);

            }
        });

    }
public void getId(){
    name1= (TextInputEditText)findViewById(R.id.name);
    user = (TextInputEditText)findViewById(R.id.username);
    email1 =  (TextInputEditText)findViewById(R.id.email);
    con = (TextInputEditText)findViewById(R.id.contact);
    count = (TextInputEditText)findViewById(R.id.country);
    gen = (TextInputEditText)findViewById(R.id.gender);
    pass = (TextInputEditText)findViewById(R.id.password);
    b1 = (Button)findViewById(R.id.button);
    b2 = (Button)findViewById(R.id.button1);
    b3 = (Button)findViewById(R.id.button2);
}

public void insertData(){
    String name = name1.getText().toString();
    String username= user.getText().toString();
    String email = email1.getText().toString();
    String contact = con.getText().toString();
    String country = count.getText().toString();
    String gender = gen.getText().toString();
    String password = pass.getText().toString();
    Boolean result = myDb.insertData(name , username , email , contact , gender , country , password);
    if (result==true){
        Toast.makeText(this , "You are successfullhy registerd" , Toast.LENGTH_SHORT).show();
    }
    else{
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }
}

}


