package com.android.filmlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.android.filmlist.CustomGridView;
import com.android.filmlist.adapter.FilmAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends Activity {

    private View title;
    private CustomGridView mListGridView;
    private FilmAdapter mFilmAdapter;
    private ArrayList datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        title = findViewById(R.id.title);

        title.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String[] names = {"奇迹笨小孩", "诡扯", "你好，李焕英", "这个杀手不太冷静", "狙击手"};
                for (int i = 0; i < 5; i++) {
                    HashMap map = new HashMap();
                    map.put("img", R.drawable.film_001 + i);
                    map.put("name", names[i]);
                    map.put("filmId", "h_114");
                    datas.add(map);
                }
                mFilmAdapter.notifyDataSetChanged();
            }
        });

        mListGridView = (CustomGridView) findViewById(R.id.film_gridview);
        datas = new ArrayList();
        mFilmAdapter = new FilmAdapter(this, datas);
        mListGridView.setAdapter(mFilmAdapter);
    }
}