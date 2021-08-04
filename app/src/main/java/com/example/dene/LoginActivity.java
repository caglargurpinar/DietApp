package com.example.dene;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    public static List<user> userList = new ArrayList<>();
    public static final String[] username = new String[1];
    public static final String[] password = new String[1];
    ImageButton loginbutton;
    EditText usernametext;
    EditText passwordtext;
    TextView wrongpasstext;
    Switch modeswitch;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ConstraintLayout layout = findViewById(R.id.loginlayout);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        user user1 = new user("ahmet","doğan","ahmet@gmail.com","password");
        user user2 = new user("uğur","taş","ugur@gmail.com","devpass");
        user user3 = new user("ayşe","dal","ayse@outlook.com","testpass");
        user user4 = new user("melike","bozkurt","melike@gmail.com","userpass");
        user user5 = new user("ali","veli","admin@gmail.com","123");
        userList.add(user1); userList.add(user2); userList.add(user3); userList.add(user4);
        userList.add(user5);

        mode = "";

        wrongpasstext = findViewById(R.id.wrongpass);
        usernametext = findViewById(R.id.usernameText);
        passwordtext = findViewById(R.id.passwordText);
        modeswitch = findViewById(R.id.modeswitch);
        modeswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    mode = "dark";
                    layout.setBackgroundColor(getResources().getColor(R.color.darkbackground));
                    linearLayout.setElevation(0);
                    linearLayout.setBackground(getResources().getDrawable(R.drawable.layoutbackgrounddark));
                    usernametext.setBackground(getResources().getDrawable(R.drawable.logintextbackwhite));
                    usernametext.setTextColor(getResources().getColor(R.color.darkbackground));
                    usernametext.setHintTextColor(getResources().getColor(R.color.darkbackground));
                    passwordtext.setBackground(getResources().getDrawable(R.drawable.passwordtextbackwhite));
                    passwordtext.setHintTextColor(getResources().getColor(R.color.darkbackground));
                    passwordtext.setTextColor(getResources().getColor(R.color.darkbackground));
                    loginbutton.setBackground(getResources().getDrawable(R.drawable.loginbuttonbackwhite));
                    wrongpasstext.setTextColor(getResources().getColor(R.color.white));
                    modeswitch.setTextColor(getResources().getColor(R.color.white));
                    loginbutton.setImageDrawable(getResources().getDrawable(R.drawable.arrow_forward));
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    // The toggle is disabled
                    mode = "light";
                    layout.setBackgroundColor(getResources().getColor(R.color.white));
                    linearLayout.setElevation(40);
                    linearLayout.setBackground(getResources().getDrawable(R.drawable.layoutbackground));
                    usernametext.setBackground(getResources().getDrawable(R.drawable.logintextbackground));
                    usernametext.setHintTextColor(getResources().getColor(R.color.white));
                    passwordtext.setBackground(getResources().getDrawable(R.drawable.passwordtextbackground));
                    passwordtext.setHintTextColor(getResources().getColor(R.color.white));
                    loginbutton.setBackground(getResources().getDrawable(R.drawable.loginbuttonbackground));
                    wrongpasstext.setTextColor(getResources().getColor(R.color.darkbackground));
                    modeswitch.setTextColor(getResources().getColor(R.color.darkbackground));
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
        final Boolean[] passwordStatus = {false};



        loginbutton = findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username[0] = usernametext.getText().toString().trim();
                password[0] = passwordtext.getText().toString().trim();
                if(username[0].contains("@") && username[0].contains(".com")){
                    for (user x : userList) {
                        if (username[0].equals(x.getEmail()) && password[0].equals(x.getPassword())){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("mode",mode);
                            startActivity(intent);
                            passwordStatus[0] = true;
                        }
                    }
                    if (!passwordStatus[0])
                        wrongpasstext.setText("Yanlış Kullanıcı Adı veya Şifre girdiniz");
                }
                else {
                    wrongpasstext.setText("Lütfen email formatında girdiniz.");
                }

            }
        });
    }
}