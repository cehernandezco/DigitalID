package com.example.digitalid.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.digitalid.entities.User;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


import com.example.digitalid.R;

import java.util.Date;

public class AddUserScrollingActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText userNameEditText;
    private EditText lastNameEditText;
    private EditText dobEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText retypePasswordEditText;
    private Button addSignUpButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addSignUpButton = findViewById(R.id.addSignUpButton);


        addSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser(v);
            }
        });


    }
    private void addUser(View v) {
        //get values from the layout
        nameEditText = findViewById(R.id.addNameEditText);
        lastNameEditText = findViewById(R.id.addLastNameEditText);
        userNameEditText = findViewById(R.id.addUsernameEditText);
        dobEditText = findViewById(R.id.editTextDate);
        emailEditText = findViewById(R.id.addEmailEditText);
        passwordEditText = findViewById(R.id.addPasswordEditText);
        retypePasswordEditText = findViewById(R.id.addReTypePasswordEditText);


        String name = nameEditText.getText().toString();
        if(name.trim().isEmpty()){
            Snackbar.make(v, v.getContext().getString(R.string.nameIsRequired) , Snackbar.LENGTH_SHORT).show();
            nameEditText.getText().clear();
            nameEditText.requestFocus();
            return;
        }
        String lastName = lastNameEditText.getText().toString();
        if(lastName.trim().isEmpty()){
            Snackbar.make(v, v.getContext().getString(R.string.lastnameIsRequired) , Snackbar.LENGTH_SHORT).show();
            lastNameEditText.getText().clear();
            lastNameEditText.requestFocus();
            return;
        }
        String username = userNameEditText.getText().toString();
        if(username.trim().isEmpty()){
            Snackbar.make(v, v.getContext().getString(R.string.usernameIsRequired) , Snackbar.LENGTH_SHORT).show();
            userNameEditText.getText().clear();
            userNameEditText.requestFocus();
            return;
        }
        String email = emailEditText.getText().toString();
        if(email.trim().isEmpty()){
            Snackbar.make(v, v.getContext().getString(R.string.emailIsRequired) , Snackbar.LENGTH_SHORT).show();
            emailEditText.getText().clear();
            emailEditText.requestFocus();
            return;
        }
        String password = passwordEditText.getText().toString();
        if(password.trim().isEmpty()){
            Snackbar.make(v, v.getContext().getString(R.string.passwordIsRequired) , Snackbar.LENGTH_SHORT).show();
            passwordEditText.getText().clear();
            passwordEditText.requestFocus();
            return;
        }
        String retypePassword = retypePasswordEditText.getText().toString();
        if(retypePassword.trim().isEmpty()){
            Snackbar.make(v, v.getContext().getString(R.string.retypePasswordIsRequired) , Snackbar.LENGTH_SHORT).show();
            retypePasswordEditText.getText().clear();
            retypePasswordEditText.requestFocus();
            return;
        }
        if(!password.equals(retypePassword)){
            Snackbar.make(v, v.getContext().getString(R.string.passwordsDontMatch) , Snackbar.LENGTH_SHORT).show();
            retypePasswordEditText.getText().clear();
            retypePasswordEditText.requestFocus();
            return;
        }
        user = new User();
        user.setName(name);
        user.setLastname(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setDob(new Date(dobEditText.getText().toString()));
        //user.setCountry(countryCode);

        //set the intent to return the user to the caller activity
        Intent goingBack = new Intent();
        goingBack.putExtra(User.USER_KEY, user);
        setResult(RESULT_OK, goingBack);
        finish();
    }
}