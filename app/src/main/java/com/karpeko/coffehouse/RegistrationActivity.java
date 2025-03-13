package com.karpeko.coffehouse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.karpeko.coffehouse.database.DatabaseHelper;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextConfirmPassword, editTextPassword, editTextEmail;
    private Button buttonRegister;
    private DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        editTextEmail = findViewById(R.id.editTextEmail);
        databaseHelper = new DatabaseHelper(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser ();
            }
        });
    }

    private void registerUser () {
        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showInfo("Все поля должны быть заполнены");
            return;
        }

        if (!password.equals(confirmPassword)) {
            editTextConfirmPassword.setTextColor(Color.RED);
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            return;
        }

        if (databaseHelper.checkUser (username, email)) {
            showInfo("Логин или почта уже существуют");
            return;
        }

        if (databaseHelper.insertData(username, email, password)) {
            showInfo("Регистрация успешна!");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            showInfo("Ошибка регистрации");
        }
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void showInfo(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
