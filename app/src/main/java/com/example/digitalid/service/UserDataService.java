package com.example.digitalid.service;

import android.content.Context;
import com.example.digitalid.database.UserDatabaseHelper;
import com.example.digitalid.entities.User;

import java.util.List;


public class UserDataService {
    private UserDatabaseHelper sqlite;

    public void connect(){

    }

    public void disconnect(){

    }

    public void init(Context context){
        sqlite = sqlite.getInstance(context);
    }

    public Long add(User user){
        return sqlite.insertUser(user.getName(), user.getLastname(), user.getCountry(), user.getEmail(), user.getUsername(), user.getPassword(), user.getDob());
    }

    public boolean delete(User user){
        return sqlite.deleteUser(user.getId());
    }

    public boolean update(User user){
        return sqlite.updateUser(user.getId(), user.getName(), user.getLastname(), user.getCountry(), user.getEmail(), user.getUsername(), user.getDob());
    }

    public List<User> getUsers(){
        List<User> users = sqlite.getUsers();
        return users;
    }

    public User getUser(Long id){
        return sqlite.getUser(id);
    }

    public boolean updateLoginBiometrics(Long id, Integer loginBiometrics){
        return sqlite.update_loginBiometricsUser(id, loginBiometrics);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        return sqlite.getUserByUsernameAndPassword(username, password);
    }
}

