package co.siacademica.mascotasS3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pavovera.petagram.R;

import java.util.ArrayList;

public class MascotasFavoriteAdapter extends RecyclerView.Adapter<MascotasFavoriteAdapter.PetsFavoriteViewHolder> {
    private ArrayList<ListFavMascotas> listFavPets;
    Activity activity;

    public MascotasFavoriteAdapter(ArrayList<ListFavMascotas> listFavPets, Activity activity) {
        this.listFavPets = listFavPets;
        this.activity = activity;
    }

    static class PetsFavoriteViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatarPet, imgBoneNickNameDog, imgBoneGoldRaiting;
        TextView nickNameDog, numRaitingPet;

        public PetsFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatarPet = itemView.findViewById(R.id.imgAvatarPet);
            imgBoneNickNameDog = itemView.findViewById(R.id.imgBoneNickNameDog);
            imgBoneGoldRaiting = itemView.findViewById(R.id.imgBoneGoldRaiting);
            nickNameDog = itemView.findViewById(R.id.nickNameDog);
            numRaitingPet = itemView.findViewById(R.id.numRaitingPet);
        }
    }

    @NonNull
    @Override
    public PetsFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_favorita_mascotas, parent, false);
        return new PetsFavoriteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetsFavoriteViewHolder holder, int position) {
        final ListFavMascotas FavPets = listFavPets.get(position);
        holder.imgAvatarPet.setImageResource(FavPets.getImgAvatarPet());
        holder.nickNameDog.setText(FavPets.getNickName());
        holder.numRaitingPet.setText(toString().valueOf(FavPets.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return listFavPets.size();
    }
}
