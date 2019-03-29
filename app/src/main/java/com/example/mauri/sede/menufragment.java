package com.example.mauri.sede;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class menufragment extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,vertodoFragment.OnFragmentInteractionListener,verAprobados.OnFragmentInteractionListener,RegistrarUsuarioFragment.OnFragmentInteractionListener {
    String titulo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy p = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(p);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menufragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Solicitudes");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment = new vertodoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_menu,fragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment miFragment = null;
        boolean fragmentSeleccionado = true;
        if (id == R.id.nav_camera) {
            titulo="Solicitudes";
            cargarBarra();
            miFragment=new vertodoFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_gallery) {
            titulo="Agendar reservación";
            cargarBarra();
            miFragment=new RegistrarUsuarioFragment();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_slideshow) {
            titulo="Historial aprobadas";
            cargarBarra();
            miFragment=new verAprobados();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_manage) {
           titulo="Registrar usuarios";
           cargarBarra();
            miFragment=new RegistrarUsuarioFragment();
            fragmentSeleccionado=true;

        }

        if(fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_menu,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
public void cargarBarra(){
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle(titulo);
    setSupportActionBar(toolbar);
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();
}
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
