package com.example.gsb_mobile_visites.API;

import com.example.gsb_mobile_visites.Model.Visiteur;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiGsbVisites {

    @POST("api/visiteurs/login")
    Call<Visiteur> loginVisiteur(@Body Map<String, String> body);

}
