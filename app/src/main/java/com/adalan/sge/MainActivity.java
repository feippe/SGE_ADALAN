package com.adalan.sge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.adalan.sge.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity  {

    private boolean logueado = false;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_administradores, R.id.nav_asistencias, R.id.nav_calificaciones, R.id.nav_documentacion)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Toast.makeText(MainActivity.this, "Creado", Toast.LENGTH_SHORT).show();

        //MenuItem miAdministradores = findViewById(R.id.nav_administradores);


        //si no está logueado le digo que vaya a la pantalla de login
        if (!this.logueado) startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void abrirAdministradores(){

    }


    public boolean onNavigationItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, "Click "+item.getItemId(), Toast.LENGTH_SHORT).show();
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.administradoresFragment:
                Toast.makeText(MainActivity.this, "Click AdministradoresFragment", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AdministradoresFragment.class));
                return true;
            case R.id.asistenciasFragment:
                Toast.makeText(MainActivity.this, "Click asistenciasFragment", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, asistenciasFragment.class));
                return true;
            case R.id.calificacionesFragment:
                Toast.makeText(MainActivity.this, "Click calificacionesFragment", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, calificacionesFragment.class));
                return true;
            case R.id.documentacionFragment:
                Toast.makeText(MainActivity.this, "Click documentacionFragment", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, documentacionFragment.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }






}


