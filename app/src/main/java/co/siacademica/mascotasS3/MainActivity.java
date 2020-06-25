package co.siacademica.mascotasS3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.pavovera.petagram.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascotas> pet;
    private RecyclerView listPets;
    ImageView imgStarIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.actionbarNavBar);
        setSupportActionBar(toolbar);

        listPets = findViewById(R.id.listPetsId);
        imgStarIcon = findViewById(R.id.imgStar);

        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        linearManager.setOrientation(LinearLayoutManager.VERTICAL);

        listPets.setLayoutManager(linearManager);
        initListPets();
        initAdapter();

        onClick(imgStarIcon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public void initAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(pet, this);
        listPets.setAdapter(adapter);
    }

    public void initListPets() {
        pet = new ArrayList<Mascotas>();

        pet.add(new Mascotas(R.drawable.bambie, getResources().getString(R.string.nickname_pet1), 5));
        pet.add(new Mascotas(R.drawable.luna, getResources().getString(R.string.nickname_pet2), 4));
        pet.add(new Mascotas(R.drawable.eva, getResources().getString(R.string.nickname_pet3), 1));
        pet.add(new Mascotas(R.drawable.teo, getResources().getString(R.string.nickname_pet4), 5));
        pet.add(new Mascotas(R.drawable.firulay, getResources().getString(R.string.nickname_pet5), 3));
        pet.add(new Mascotas(R.drawable.manchas, getResources().getString(R.string.nickname_pet6), 2));
    }

    public void onClick(View v) {
        imgStarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavMascotas.class);
                startActivity(intent);
            }
        });
    }
}
