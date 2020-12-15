package com.app.customspinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    LinearLayout lLSpinnerType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lLSpinnerType = findViewById(R.id.lL_spinner_type);
        lLSpinnerType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

    }

    public void show() {

        final BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
        dialog.setContentView(R.layout.bottomsheet_transaction_type);
        dialog.show();

        // adapter
        String[] arrStr = getResources().getStringArray(R.array.transaction_type_label);
        TransactionTypeAdapter adapter  = new TransactionTypeAdapter(arrStr);

        // recycleView
        RecyclerView rvList = dialog.findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);


        // clicked
        adapter.setTransactionTypeClick(new TransactionTypeAdapter.TransactionTypeClick() {
            @Override
            public void onItemClicked(int position) {
                Log.d(TAG, "onItemClicked: " + position);
                dialog.dismiss();
            }
        });

    }



}
