package com.example.android.ksinternshipdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText email;
    private EditText password;
    private AppCompatCheckBox soulTradeCheckbox;
    private AppCompatCheckBox spamMailingCheckbox;
    private AppCompatButton saveButton;
    private AppCompatButton checkButton;

    private String emailText;
    private String passText;
    private boolean soulChecked;
    private boolean spamChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Registration");

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        soulTradeCheckbox = findViewById(R.id.soul_checkbox);
        spamMailingCheckbox = findViewById(R.id.spam_checkbox);
        saveButton = findViewById(R.id.btn_save);
        checkButton = findViewById(R.id.btn_read);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInputData();
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readSavedData();
            }
        });

    }

    private void saveInputData() {
        emailText = email.getText().toString();
        passText = password.getText().toString();
        soulChecked = soulTradeCheckbox.isChecked();
        spamChecked = spamMailingCheckbox.isChecked();

        email.setText("");
        password.setText("");
        soulTradeCheckbox.setChecked(false);
        spamMailingCheckbox.setChecked(false);
    }

    private void readSavedData() {

        String message;

        if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passText)) {
            message = "Oops! There is NO saved data! :(";
        } else {
            message = "Email: " + emailText + "\r\n"
                    + "Password: " + passText + "\r\n"
                    + "User accepted soul trade: " + soulChecked + "\r\n"
                    + "User agreed to receive spam: " + spamChecked;
        }


        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

    }

}
