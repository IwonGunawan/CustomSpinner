package com.app.customspinner;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionTypeAdapter extends RecyclerView.Adapter<TransactionTypeAdapter.ViewHolder>{
    public final static String TAG = TransactionTypeAdapter.class.getSimpleName();

    private String arrString[];
    private TransactionTypeClick transactionTypeClick;


    public TransactionTypeAdapter(String[] arrStr) {
        arrString = arrStr;
    }

    public void setTransactionTypeClick(TransactionTypeClick transactionTypeClick) {
        this.transactionTypeClick = transactionTypeClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottomsheet_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvLabel.setText(arrString[position]);
        holder.tvLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionTypeClick.onItemClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrString.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvLabel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLabel = itemView.findViewById(R.id.tv_label);
        }
    }

    public interface TransactionTypeClick{
        void onItemClicked(int position);
    }
}
