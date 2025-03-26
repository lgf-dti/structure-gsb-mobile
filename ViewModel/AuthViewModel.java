package com.example.gsb_mobile_visites.ViewModel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gsb_mobile_visites.API.ApiGsbVisites;
import com.example.gsb_mobile_visites.API.RetrofitClientInstance;
import com.example.gsb_mobile_visites.Model.Visiteur;
import com.example.gsb_mobile_visites.Repository.AuthRepository;

public class AuthViewModel extends ViewModel {
    private AuthRepository authRepository;
    private MutableLiveData<Visiteur> visiteurLiveData;

    public AuthViewModel() {
        ApiGsbVisites service = RetrofitClientInstance.getRetrofitInstance().create(ApiGsbVisites.class);
        this.authRepository = new AuthRepository(service);
    }

    public LiveData<Visiteur> getVisiteur() {
        if (visiteurLiveData == null){
            visiteurLiveData = new MutableLiveData<>();
        }
        return visiteurLiveData;
    }

    public void login(String email, String password, LifecycleOwner lifecycleOwner) {
        authRepository.login(email, password).observe(lifecycleOwner, visiteurLiveData::setValue);
    }
}

