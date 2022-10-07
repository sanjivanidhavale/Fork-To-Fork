package com.example.farmtofork.ui.farminfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FarminfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FarminfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}