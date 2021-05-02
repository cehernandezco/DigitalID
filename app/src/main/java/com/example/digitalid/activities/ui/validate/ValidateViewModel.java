package com.example.digitalid.activities.ui.validate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ValidateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ValidateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is not yet implemented");
    }

    public LiveData<String> getText() {
        return mText;
    }
}