package com.example.recyclerviewjava2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.MahasiswaViewHolder>{
    private Context context;
    private List<Mahasiswa> mahasiswaList;
    private ItemClickListener itemClickListener;
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public Adapter(Context context, List<Mahasiswa> mahasiswaList, ItemClickListener itemClickListener) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tampilan, parent, false);
        return new MahasiswaViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Mahasiswa mahasiswa = mahasiswaList.get(position);
        holder.namaTextView.setText(mahasiswa.getNama());
        holder.nimTextView.setText(mahasiswa.getNim());
        holder.imageView.setImageResource(mahasiswa.getGambar());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView namaTextView, nimTextView;
        ImageView imageView;
        ItemClickListener itemClickListener;

        public MahasiswaViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            namaTextView = itemView.findViewById(R.id.name);
            nimTextView = itemView.findViewById(R.id.nim);
            imageView = itemView.findViewById(R.id.imageview);
            this.itemClickListener = itemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
