package com.appsbymonil.cashnmod;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
TextInputEditText user , pass;
    Button btn ;
    TextView btnTexxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getId();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this , Main.class );
                startActivity(i);
            }
        });

    }

public void getId(){
    user = (TextInputEditText)findViewById(R.id.username);
    pass = (TextInputEditText)findViewById(R.id.password);
    btn = (Button)findViewById(R.id.button);
}

public void register(View view){
    Intent i = new Intent(Login.this , Register.class);
    startActivity(i);

}

}

