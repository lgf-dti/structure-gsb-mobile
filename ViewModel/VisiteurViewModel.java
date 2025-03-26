package com.example.gsb_mobile_visites.ViewModel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gsb_mobile_visites.API.ApiGsbVisites;
import com.example.gsb_mobile_visites.API.RetrofitClientInstance;
import com.example.gsb_mobile_visites.Model.Visiteur;
import com.example.gsb_mobile_visites.Repository.AuthRepository;
import com.example.gsb_mobile_visites.Repository.VisiteurRepository;

public class VisiteurViewModel extends ViewModel {
    private VisiteurRepository visiteurRepository;


    public VisiteurViewModel() {
        ApiGsbVisites service = RetrofitClientInstance.getRetrofitInstance().create(ApiGsbVisites.class);
        this.visiteurRepository = new VisiteurRepository(service);
    }

    public LiveData<Visiteur> getVisiteurById(String token, String id) {
        return visiteurRepository.getVisiteurById(token, id);
    }
}

