package com.example.android.ksinternshipdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
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

    private final static String KEY_EMAIL = "KEY_EMAIL";
    private final static String KEY_PASSWORD = "KEY_PASSWORD";
    private final static String KEY_SOUL_TRADE = "KEY_SOUL_TRADE";
    private final static String KEY_SPAM_AGREED = "KEY_SPAM_AGREED";

    private final static String LOG_TAG = "SaveStateActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "onCreate()");

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

        checkForSavedState(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState()");

        outState.putString(KEY_EMAIL, emailText);
        outState.putString(KEY_PASSWORD, passText);
        outState.putBoolean(KEY_SOUL_TRADE, soulChecked);
        outState.putBoolean(KEY_SPAM_AGREED, spamChecked);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // This One Called after "onStart()". "savedInstanceState" guaranteed not to be null.
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_TAG, "onRestoreInstanceState()");

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

    private void checkForSavedState(Bundle stateBundle) {
        if (stateBundle == null) {
            return;
        }

        emailText = stateBundle.getString(KEY_EMAIL);
        passText = stateBundle.getString(KEY_PASSWORD);
        soulChecked = stateBundle.getBoolean(KEY_SOUL_TRADE);
        spamChecked = stateBundle.getBoolean(KEY_SPAM_AGREED);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy()");
    }

}
