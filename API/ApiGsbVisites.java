package com.example.gsb_mobile_visites.API;

import com.example.gsb_mobile_visites.Model.Visiteur;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiGsbVisites {

    @POST("api/visiteurs/login")
    Call<Visiteur> loginVisiteur(@Body Map<String, String> body);

    @GET("api/visiteurs/{id}")
    Call<Visiteur> getVisiteurById(@Header("Authorization") String token, @Path("id") String id);
}
