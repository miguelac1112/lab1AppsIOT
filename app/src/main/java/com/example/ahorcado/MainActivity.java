package com.example.ahorcado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat; // Importa la clase ContextCompat
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private int currentTextColor; // Almacena el color actual del texto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.textView2);
        currentTextColor = ContextCompat.getColor(this, android.R.color.black); // Color inicial
        titleTextView.setTextColor(currentTextColor);

        registerForContextMenu(titleTextView);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String title = item.getTitle().toString(); // Obtiene el título del elemento de menú

        if ("Azul".equals(title)) {
            currentTextColor = ContextCompat.getColor(this, R.color.blue_color);
        } else if ("Verde".equals(title)) {
            currentTextColor = ContextCompat.getColor(this, R.color.green_color);
        } else if ("Rojo".equals(title)) {
            currentTextColor = ContextCompat.getColor(this, R.color.red_color);
        }

        titleTextView.setTextColor(currentTextColor);
        return true;
    }




    public void play(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

