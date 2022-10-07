package com.example.farmtofork.ui.cropcalender;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CropCalenderViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CropCalenderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}