package com.nimesh.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivityGlobe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SwitchCompat switchCompat;
    Intent switchIntent;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    private static String URL_DATA = "https://www.hpb.health.gov.lk/api/get-current-statistical";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem2> listItems;

    ImageView refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchCompat = findViewById(R.id.switchButton);
        switchIntent = new Intent(this, MainActivity.class);

        switchCompat.setChecked(true);
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!switchCompat.isChecked()){
                    overridePendingTransition(0, 0);
                    startActivity(switchIntent);
                    overridePendingTransition(0, 0);
                }else {
                    recreate();
                }
            }
        });


        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        loadRecyclerViewData();

        refreshButton = findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityGlobe.this, MainActivityGlobe.class);
                finish();
                overridePendingTransition(0, 0);
                startActivity(i);
                overridePendingTransition(0, 0);
            }
        });

    }

    public void visitHpb(View view){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.hpb.health.gov.lk/"));
        startActivity(viewIntent);
    }

    public void visitGitHub(View view){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://github.com/nimeshkasun/COVID-19_Situation-Report/"));
        startActivity(viewIntent);
    }

    public void callTo(View view){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("tel:1999"));
        startActivity(viewIntent);
    }

    public void developedBy(){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.linkedin.com/in/nimeshkasun/"));
        startActivity(viewIntent);
    }

    public void updateApp(View view){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://nimeshkasun.github.io/COVID-19_Situation-Report/"));
        startActivity(viewIntent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.profile:
                developedBy();
                break;
            default:
                break;
        }
        return false;
    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONObject array = jsonObject.getJSONObject("data");

                    //for(int i=0; i<array.length(); i++){
                    //JSONObject o = array.getJSONObject(i);
                    ListItem2 item = new ListItem2(
                            array.getString("update_date_time"),
                            /*array.getString("local_total_cases"),
                            array.getString("local_new_cases"),
                            array.getString("local_total_number_of_individuals_in_hospitals"),
                            array.getString("local_deaths"),
                            array.getString("local_recovered"),*/
                            array.getString("global_total_cases"),
                            array.getString("global_new_cases"),
                            array.getString("global_deaths"),
                            array.getString("global_recovered")
                    );
                    listItems.add(item);
                    //}
                    adapter = new DataAdapter2(listItems, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
