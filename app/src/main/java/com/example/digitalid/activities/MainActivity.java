package com.example.digitalid.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.digitalid.R;
import com.example.digitalid.entities.User;
import com.example.digitalid.service.UserDataService;
import com.google.android.material.snackbar.Snackbar;

import static com.example.digitalid.entities.Constants.ADD_USER_ACTIVITY_CODE;
import static com.example.digitalid.entities.Constants.RECOVER_USER_ACTIVITY_CODE;

public class MainActivity extends AppCompatActivity {
    private UserDataService userDataService;
    private View rootView;
    EditText userName, password;
    String userNameString, passWordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = findViewById(android.R.id.content).getRootView();

        userDataService = new UserDataService();
        userDataService.init(this);

        //get the variables and pass them in a string value
        userName = findViewById(R.id.usernameEditText);

        password = findViewById(R.id.passwordEditText);


        Button loginButton = findViewById(R.id.loginButton);
        Button signUpButton = findViewById(R.id.signUpButton);
        TextView forgotPwdTextView = findViewById(R.id.forgotTextView);

        //login action
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGetAccountName(v, userName.getText().toString(), password.getText().toString());
            }
        });

        //recover password action
        forgotPwdTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoverPassword();
            }
        });

        //signUp action
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser();
            }
        });
    }

    private void onGetAccountName(View v, String username, String password) {
        User user = userDataService.getUserByUsernameAndPassword(username, password);
        String message;
        if(user == null){
            message = rootView.getContext().getString(R.string.userNameOrPasswordInvalid);
            hideKeyboard(this);
            Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show();
        }else{
            //state our intention, to get the name and move to log in page
            Intent goToMenuActivity = new Intent(MainActivity.this, HomeMainActivity.class);
            goToMenuActivity.putExtra("user", user);
            startActivity(goToMenuActivity);
        }

    }

    private void addNewUser() {
        Intent goToAddCreateUser = new Intent(this, AddUserScrollingActivity.class);
        startActivityForResult(goToAddCreateUser, ADD_USER_ACTIVITY_CODE);
    }
    private void recoverPassword() {
        Intent goToRecoverPasswordUser = new Intent(this, AddUserScrollingActivity.class);
        startActivityForResult(goToRecoverPasswordUser, RECOVER_USER_ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_USER_ACTIVITY_CODE){
            if(resultCode == RESULT_OK){
                addUser(data);
            }
        }
    }
    private void addUser(Intent data) {
        String message;
        User user = (User) data.getSerializableExtra(User.USER_KEY);
        //insert your User into the DB
        Long result = userDataService.add(user);
        //result holds the autogenerated id in the table
        if(result > 0){

            User monster1 = userDataService.getUser(result);

            message = rootView.getContext().getString(R.string.yourUserHasBeenCreatedSuccessfully);
        }else{
            message = rootView.getContext().getString(R.string.weCouldntCreateYourUserTryAgain);
        }
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

    public static void hideKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if(view == null){
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

}