package com.example.wedlock.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wedlock.R;
import com.example.wedlock.models.viewAllModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailedActivity extends AppCompatActivity {

    ImageView detailedImg;
    TextView name, price, description;
    Button addToCart;
    viewAllModel viewAllModel = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        final Object object = getIntent().getSerializableExtra("detail");

        if (object instanceof viewAllModel) {
            viewAllModel = (viewAllModel) object;
        }

        detailedImg = findViewById(R.id.detailed_img);
        name = findViewById(R.id.detailed_name);
        price = findViewById(R.id.detailed_price);
        description = findViewById(R.id.detailed_description);

        if (viewAllModel != null) {
            Glide.with(getApplicationContext()).load(viewAllModel.getImg_url()).into(detailedImg);
            name.setText(viewAllModel.getName());
            description.setText(viewAllModel.getDescription());
            price.setText("Price: LKR. "+ viewAllModel.getPrice());
        }


        addToCart = findViewById(R.id.add_to_cart);

      
    }
}