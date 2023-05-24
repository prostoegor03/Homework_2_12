package com.mirea.kt.homework_2_12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder>{

    Context context;
    List<Car> list;
    CarClickListener carClickListener;

    public CarAdapter(Context context, List<Car> list, CarClickListener carClickListener) {
        this.context = context;
        this.list = list;
        this.carClickListener = carClickListener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarViewHolder(LayoutInflater.from(context).inflate(R.layout.car_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        holder.tvCarModel.setText(list.get(position).getModel());
        holder.tvCarNumber.setText(list.get(position).getNumber());
        String year = String.valueOf(list.get(position).getYear());
        holder.tvCarYear.setText(year);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class CarViewHolder extends RecyclerView.ViewHolder {

        CardView car_conteiner;
        TextView tvCarModel,tvCarYear,tvCarNumber;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);

            car_conteiner = itemView.findViewById(R.id.car_conteiner);
            tvCarModel = itemView.findViewById(R.id.tvCarModel);
            tvCarNumber = itemView.findViewById(R.id.tvCarNumber);
            tvCarYear = itemView.findViewById(R.id.tvCarYear);


        }
    }
}



