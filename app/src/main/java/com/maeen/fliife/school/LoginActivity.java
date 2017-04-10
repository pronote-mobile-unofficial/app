package com.maeen.fliife.school;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Login page
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Toast.makeText(this, AESEncryption.getInstance().setInitVector("").setKey("").decrypt(""), Toast.LENGTH_LONG).show();
    }
}

