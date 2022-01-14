package com.example.uas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterQ extends RecyclerView.Adapter<AdapterQ.ViewHolderQ> {

    String data1[], data2[], data3[], data4[];
    int images[];
    Context context;

    public AdapterQ(Context ct, String s1[], String s2[], String s3[], String s4[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        images = img;
    }

    @NonNull
    @Override
    public ViewHolderQ onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.baris_qu, parent,false);
        return new ViewHolderQ(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQ holder, @SuppressLint("RecyclerView") final int position) {
        holder.textQ1.setText(data1[position]);
        holder.textQ3.setText(data3[position]);
        holder.textQ4.setText(data4[position]);
        holder.imageQ.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, secHome.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("data3", data3[position]);
                intent.putExtra("data4", data4[position]);
                intent.putExtra("imageQ", images[position]);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolderQ extends RecyclerView.ViewHolder{

        TextView textQ1, textQ3, textQ4;
        ImageView imageQ;
        ConstraintLayout mainLayout;

        public ViewHolderQ(@NonNull View itemView) {
            super(itemView);
            textQ1 = itemView.findViewById(R.id.txtMenuMakanan);
            textQ3 = itemView.findViewById(R.id.txtHargaMakanan);
            textQ4 = itemView.findViewById(R.id.txtRatingMakanan);
            imageQ = itemView.findViewById(R.id.imageViewQ);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}