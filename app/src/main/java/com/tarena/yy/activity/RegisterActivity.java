package com.tarena.yy.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.tarena.yy.R;
import com.tarena.yy.entity.UserEntity;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {
    TextView tvBack;
    EditText etName,etPassword;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        addListener();
    }

    private void initViews() {
        tvBack= (TextView) findViewById(R.id.register_back);
        etName= (EditText) findViewById(R.id.register_nameedit);
        etPassword= (EditText) findViewById(R.id.register_passwordet);
        registerBtn= (Button) findViewById(R.id.register_registerBtn);
    }

    private void addListener() {
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().length()<3||etName.getText().length()>12||etPassword.getText().length()<6||
                        etPassword.getText().length()>12){
                    Toast.makeText(RegisterActivity.this, "您账号或者密码输入有误，请重新输入", Toast.LENGTH_SHORT).show();
                }else {
                    final String name=etName.getText().toString();
                    final String password=etPassword.getText().toString();
                    final UserEntity user=new UserEntity();
                    user.setUsername(name);
                    user.setPassword(password);
                    user.signUp(new SaveListener<UserEntity>() {
                        @Override
                        public void done(UserEntity s, BmobException e) {
                            if (e==null){
                                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            EMClient.getInstance().createAccount(name,password);
                                            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                                            startActivity(intent);
                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                                finish();
                            }
                        }
                    });
                }
            }
        });
    }

}
