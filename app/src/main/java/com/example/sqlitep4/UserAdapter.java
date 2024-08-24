package com.example.sqlitep4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.userName.setText(user.getName());
        holder.userEmail.setText(user.getEmail());
        Glide.with(holder.itemView.getContext())
                .load(user.getImageUrl())
                .centerCrop()
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    // Clase ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userImage;
        public TextView userName;
        public TextView userEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
            userEmail = itemView.findViewById(R.id.userEmail);

            // Agregar click listener a cada elemento
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    User user = users.get(position);
                    Toast.makeText(v.getContext(), "Usuario: " + user.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
