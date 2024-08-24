package com.example.sqlitep4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar la lista de usuarios
        userList = new ArrayList<>();
        userList.add(new User("Nombre 1", "correo1@ejemplo.com", "https://icons.iconarchive.com/icons/custom-icon-design/pretty-office-2/72/man-icon.png"));
        userList.add(new User("Nombre 2", "correo2@ejemplo.com", "https://icons.iconarchive.com/icons/icons-land/vista-people/72/Person-Male-Dark-icon.png"));
        // ... añadir más usuarios

        // Inicializar RecyclerView y Adapter
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}