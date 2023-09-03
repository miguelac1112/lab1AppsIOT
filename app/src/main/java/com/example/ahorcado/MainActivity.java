package com.example.ahorcado;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View titleTextView = findViewById(R.id.textView2);
        registerForContextMenu(titleTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_context,menu);
        return true;
    }

    //Metodo para asignar las funciones correspondientes a las opciones
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        TextView titleTextView = findViewById(R.id.textView2);

        switch (item.getItemId()) {
            case 100: // Valor constante para color azul
                titleTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
                return true;
            case 101: // Valor constante para color verde
                titleTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                return true;
            case 102: // Valor constante para color rojo
                titleTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void play(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}