package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    public static List<Order> orders = OrderGenerator.generateOrders();
    private RecyclerView recyclerView;
    private Button calculateButton;
    private final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(new OnPriceChangeListener() {
        @Override
        public void onPriceChanged(final String price, final int position) {
            orders.get(position).setPrice(price);
            Log.d("XXX", "price was changed in position " + position + " for price = " + price);
        }
    }, new OnAdapterClickListener() {
        @Override
        public void onClick(final int position) {
            Toast.makeText(MainActivity.this, "View with position " + position + " was clicked", Toast.LENGTH_SHORT).show();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int sum = 0;
                for (final Order order : orders) {
                    sum += Integer.parseInt(order.getPrice());
                }

                Toast.makeText(MainActivity.this, "" + sum, Toast.LENGTH_SHORT).show();
            }
        });

        initRecycler();

        recyclerAdapter.update(orders);
    }

    private void initRecycler() {
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void onChange(String text, int position) {
        orders.get(position).setPrice(text);
    }
}
