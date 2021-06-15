package com.example.toolbar.ui.creditos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreditosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CreditosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Estudiantes: \n \n \nRonald Sancho Madrigal B66666\n\n  " +
                "Graciela Porras Rojas B75923\n\n  " +
                "Randall Centeno Vargas B61776\n\n  " +
                "Fauricio Chavez Hernández B61976");
    }

    public LiveData<String> getText() {
        return mText;
    }
}