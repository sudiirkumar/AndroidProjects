package com.sudhir.padhaisala.ui.batch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BatchViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BatchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is batch fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}