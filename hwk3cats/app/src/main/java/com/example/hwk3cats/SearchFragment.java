package com.example.hwk3cats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SearchFragment extends Fragment {

    public Button searchB;
    public EditText searchT;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_search, container, false);


        searchB = view.findViewById(R.id.searchButton);
        searchT = view.findViewById(R.id.searchText);

        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        final RecyclerView recyclerView = view.findViewById(R.id.rv_search);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final SearchAdapter searchAdapter = new SearchAdapter();

        searchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://api.thecatapi.com/v1/breeds/search?q=" + searchT.getText();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Gson gson = new Gson();
                                Type arrayListType = new TypeToken<ArrayList<Cat>>(){}.getType();
                                ArrayList<Cat> target = gson.fromJson(response, arrayListType);
                                System.out.println(target.size());
                                searchAdapter.setData(target);
                                recyclerView.setAdapter(searchAdapter);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });

                requestQueue.add(stringRequest);
            }
        });

        return view;
    }

}
