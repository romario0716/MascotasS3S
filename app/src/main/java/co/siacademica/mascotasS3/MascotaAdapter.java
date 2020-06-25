package co.siacademica.mascotasS3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pavovera.petagram.R;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.PetViewHolder> {
    private ArrayList<Mascotas> pets;
    private Activity activity;

    MascotaAdapter(ArrayList<Mascotas> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    static class PetViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatarPet, imgBoneNickNameDog, imgBoneGoldRaiting;
        TextView nickNameDog, numRaitingPet;

        PetViewHolder(@NonNull View itemView) {
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
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_mascota, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        final Mascotas pet = pets.get(position);
        holder.imgAvatarPet.setImageResource(pet.getImgAvatarPet());
        holder.nickNameDog.setText(pet.getNickName());
        holder.numRaitingPet.setText(toString().valueOf(pet.getRaiting()));

        holder.imgBoneNickNameDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Te encanta " + pet.getNickName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return (pets == null) ? 0 : pets.size();
    }
}
