package com.example.gsb_mobile_visites.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.gsb_mobile_visites.Model.Visiteur;
import com.example.gsb_mobile_visites.ViewModel.AuthViewModel;
import com.example.gsb_mobile_visites.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Visiteur visiteur;
    private boolean isLogged;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialisation du ViewModel
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        binding.buttonMainLogin.setOnClickListener(v -> {
            String email = binding.editTextMainEmail.getText().toString();
            String password = binding.editTextMainPassword.getText().toString();
            authViewModel.login(email, password, this);
        });

        // Observer la réponse de l'API
        authViewModel.getVisiteur().observe(this, visiteur -> {
            if (visiteur != null) {
                Toast.makeText(MainActivity.this, "Connexion réussie !", Toast.LENGTH_SHORT).show();

                Intent intentHome = new Intent(MainActivity.this, HomeActivity.class);
                intentHome.putExtra("visiteur", visiteur);
                startActivity(intentHome);
            } else {
                Toast.makeText(MainActivity.this, "Connexion échouée !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}