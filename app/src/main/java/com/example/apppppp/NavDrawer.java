package com.example.apppppp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.example.apppppp.ui.gallery.Details;
import com.example.apppppp.ui.gallery.GalleryFragment;
import com.example.apppppp.ui.gallery.cashapp;
import com.example.apppppp.ui.gallery.paypal;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apppppp.databinding.ActivityNavDrawerBinding;

public class NavDrawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavDrawerBinding binding;
    String choice = "";
    Double price = 0.00;
    Button cartcake, cartbeyaynet, cartburger, pizzacart, icecart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavDrawer.toolbar);
//        binding.appBarNavDrawer.toolbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_contact, R.id.nav_website)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        cartcake = (Button) findViewById(R.id.cartcake);
        cartbeyaynet = (Button) findViewById(R.id.cartbeyaynet);
        cartburger = (Button) findViewById(R.id.cartbrgr);
        pizzacart = (Button) findViewById(R.id.pizzacart);
        icecart = (Button) findViewById(R.id.icecart);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void close_app(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You sure you want to logout?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }); builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(NavDrawer.this, MainActivity.class);
                startActivity(intent);
            }
        }).show();

    }

    public void addtolist(View view) {
        if (view == findViewById(R.id.cartcake)){
            choice = choice + "Caramel Cheese Cake"+"\n";
            price = price + 50;
            Toast.makeText(getApplicationContext(), "Caramel Cheese Cake Added To Cart!", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.cartbeyaynet)){
            choice = choice + "Beyaynet" + "\n";
            price = price + 105;
            Toast.makeText(getApplicationContext(), "Beyaynet Added To Cart!", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.cartbrgr)){
            choice = choice + "Triple Decker Burger" + "\n";
            price = price + 250;
            Toast.makeText(getApplicationContext(), "Triple Decker Burger Added To Cart!", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.pizzacart)){
            choice = choice + "Meat Loaded Pizza" + "\n";
            price = price + 285;
            Toast.makeText(getApplicationContext(), "Meat Loaded Pizza Added To Cart!", Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.icecart)){
            choice =choice + "Vanilla and Chocolate Ice Cream" + "\n";
            price = price + 50;
            Toast.makeText(getApplicationContext(), "Vanilla and Chocolate Ice Cream Added To Cart!", Toast.LENGTH_SHORT).show();
        }
    }

    public void placeOrder(View view) {
        Intent i = new Intent(this, Details.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices", choice);
        bundle.putDouble("price", price);
        i.putExtras(bundle);
        startActivity(i);
    }


}