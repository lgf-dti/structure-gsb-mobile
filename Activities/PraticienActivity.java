package com.example.gsb_mobile_visites.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsb_mobile_visites.databinding.ActivityPraticienBinding;

public class PraticienActivity extends AppCompatActivity {

    private ActivityPraticienBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPraticienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}