package co.siacademica.mascotasS3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.pavovera.petagram.R;

import java.util.ArrayList;

public class FavMascotas extends AppCompatActivity {
    ArrayList<ListFavMascotas> favPets;
    private RecyclerView listFavPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_mascotas);

        Toolbar toolbar = findViewById(R.id.actionbarNavBar);
        setSupportActionBar(toolbar);

        listFavPets = findViewById(R.id.listFavPets);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        linearManager.setOrientation(LinearLayoutManager.VERTICAL);

        listFavPets.setLayoutManager(linearManager);
        initListFavPets();
        initAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public void initAdapter() {
        MascotasFavoriteAdapter adapter = new MascotasFavoriteAdapter(favPets, this);
        listFavPets.setAdapter(adapter);
    }

    public void initListFavPets() {
        favPets = new ArrayList<ListFavMascotas>();

        favPets.add(new ListFavMascotas(R.drawable.teo, getResources().getString(R.string.nickname_pet4), 5));
        favPets.add(new ListFavMascotas(R.drawable.bambie, getResources().getString(R.string.nickname_pet1), 5));
        favPets.add(new ListFavMascotas(R.drawable.luna, getResources().getString(R.string.nickname_pet2), 4));
        favPets.add(new ListFavMascotas(R.drawable.firulay, getResources().getString(R.string.nickname_pet5), 3));
        favPets.add(new ListFavMascotas(R.drawable.manchas, getResources().getString(R.string.nickname_pet6), 2));
    }
}
