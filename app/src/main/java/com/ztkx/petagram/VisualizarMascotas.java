package com.ztkx.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class VisualizarMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    MascotaAdaptador adaptador;
    private RecyclerView listaMascotas;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_mascotas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.visualizarMascotas);

        listaMascotas= (RecyclerView) findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavs:
                Intent goToFavs = new Intent(this,MascotasFavoritas.class);
                startActivity(goToFavs);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.bandido,0,"Bandido"));
        mascotas.add(new Mascota(R.drawable.pirata,0,"Pirata"));
        mascotas.add(new Mascota(R.drawable.coffe,0,"Coffe"));
        mascotas.add(new Mascota(R.drawable.donatelo,0,"Donatelo"));
        mascotas.add(new Mascota(R.drawable.fluffy,0,"Fluffy"));
        mascotas.add(new Mascota(R.drawable.lucy,0,"Lucy"));
        mascotas.add(new Mascota(R.drawable.negan,0,"Negan"));
        mascotas.add(new Mascota(R.drawable.pelusa,0,"Pelusa"));

    }
}
