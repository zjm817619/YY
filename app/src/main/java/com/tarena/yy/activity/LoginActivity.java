package com.tarena.yy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.tarena.yy.R;
import com.tarena.yy.entity.UserEntity;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    TextView tvBack, tvRegister;
    EditText etName, etPassword;
    Button loginBtn;
    hadUser huser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        addListener();
    }

    private void initViews() {
        tvBack = (TextView) findViewById(R.id.login_backimage);
        tvRegister = (TextView) findViewById(R.id.login_register);
        etName = (EditText) findViewById(R.id.login_nameedit);
        etPassword = (EditText) findViewById(R.id.login_passwordet);
        loginBtn = (Button) findViewById(R.id.login_loginBtn);

    }

    private void addListener() {
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final UserEntity user = new UserEntity();
                final String name=etName.getText().toString();
                final String password=etPassword.getText().toString();
                user.setUsername(name);
                user.setPassword(password);
                user.login(new SaveListener<UserEntity>() {
                    @Override
                    public void done(UserEntity s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            huser.onhadUser(user);
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    EMClient.getInstance().login(name, password, new EMCallBack() {
                                        @Override
                                        public void onSuccess() {
                                            EMClient.getInstance().groupManager().loadAllGroups();
                                            EMClient.getInstance().chatManager().loadAllConversations();
                                            Log.d("main", "登录聊天服务器成功！");
                                        }
                                        @Override
                                        public void onError(int code, String error) {
                                            Log.i("TAG","聊天服务登录失败");
                                        }
                                        @Override
                                        public void onProgress(int progress, String status) {
                                        }
                                    });
                                }
                            }).start();
                            finish();
                        }
                    }
                });
            }
        });
    }
    public interface hadUser{
        void onhadUser(UserEntity user);
    }
}
