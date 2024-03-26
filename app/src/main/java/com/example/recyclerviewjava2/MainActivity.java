package com.example.recyclerviewjava2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<Mahasiswa> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mahasiswaList = new ArrayList<>();
        mahasiswaList.add(new Mahasiswa("Nama: Abmi Sukma Edri","Nim: 12050120341",R.drawable.amiii));
        mahasiswaList.add(new Mahasiswa("Nama: Ahmad Kurniawan","Nim: 12250111514",R.drawable.ahmed));
        mahasiswaList.add(new Mahasiswa("Nama: Aufa Hajati","Nim: 12250120338",R.drawable.aufa));
        mahasiswaList.add(new Mahasiswa("Nama: Daffa Finanda","Nim: 12250111603",R.drawable.dapin));
        mahasiswaList.add(new Mahasiswa("Nama: Daffa Ikhwan Nurfauzan","Nim: 12250110979",R.drawable.dafuq));
        mahasiswaList.add(new Mahasiswa("Nama: Diki Afdol","Nim: 112250110383",R.drawable.diki));
        mahasiswaList.add(new Mahasiswa("Nama: Dwi Jelita Adhliyah","Nim: 12250120331",R.drawable.jelita));
        mahasiswaList.add(new Mahasiswa("Nama: Dwi Mahdini","Nim: 12250111298",R.drawable.dwik));
        mahasiswaList.add(new Mahasiswa("Nama: Fajri","Nim: 1225011082",R.drawable.fajri));
        mahasiswaList.add(new Mahasiswa("Nama: Farras Lathief","Nim: 12250111328",R.drawable.farras));
        mahasiswaList.add(new Mahasiswa("Nama: Gilang Ramadhan Indra","Nim: 12250111323",R.drawable.gilang));
        mahasiswaList.add(new Mahasiswa("Nama: Hafidz Alhadid Rahman","Nim: 12250111794",R.drawable.hafidz));
        mahasiswaList.add(new Mahasiswa("Nama: Haritsah Naufaldy","Nim: 12250110361",R.drawable.aldy));
        mahasiswaList.add(new Mahasiswa("Nama: M. Nabil Dawami","Nim: 12250111527",R.drawable.nabil));
        mahasiswaList.add(new Mahasiswa("Nama: M. Zaki Erbay Syas","Nim: 12250111134",R.drawable.zaki));
        mahasiswaList.add(new Mahasiswa("Nama: Muhammad Aditya Rinaldi","Nim: 12250111048",R.drawable.adit));
        mahasiswaList.add(new Mahasiswa("Nama: Muhammad Dhimas Hadid","Nim: 12250111231",R.drawable.dms));
        mahasiswaList.add(new Mahasiswa("Nama: Muhammad Rafly Wirayudha","Nim: 12250111489",R.drawable.rafly));
        mahasiswaList.add(new Mahasiswa("Nama: Nurika Dwi Wahyuni","Nim: 12250120360",R.drawable.nurika));
        mahasiswaList.add(new Mahasiswa("Nama: Ogya Secio Noegroho.s","Nim: 12250111346",R.drawable.ogi));
        mahasiswaList.add(new Mahasiswa("Nama: Rahma Laksita","Nim:12250124357",R.drawable.rahma));
        mahasiswaList.add(new Mahasiswa("Nama: Nama: Raka Sabri","Nim: 12250110342",R.drawable.bili));
        mahasiswaList.add(new Mahasiswa("Nama: Surya Hidayatullah Firdaus","Nim: 12250111759",R.drawable.srya));

        adapter = new Adapter(this, mahasiswaList, this::onItemClick);
        recyclerView.setAdapter(adapter);
    }
    public void onItemClick(View view, int position) {
        Mahasiswa mahasiswa = mahasiswaList.get(position);

        Intent intent = new Intent(MainActivity.this, ActivityResult.class);
        intent.putExtra("image", mahasiswa.getGambar());
        intent.putExtra("name", mahasiswa.getNama());
        intent.putExtra("nim", mahasiswa.getNim());
        startActivity(intent);
    }
}

