package com.example.narek.mymenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    private ListView list;
    private CustomAdapter customAdapter;
    private List<Data> datas;
    Data curData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItem();
        updateView();
        list.setOnItemLongClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.delete:
                Toast.makeText(getApplicationContext(), "Delete Clicked", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < datas.size(); i++) {
                    if (datas.get(i).isCheked()) {
                        datas.remove(i--);
                        customAdapter.notifyDataSetChanged();
                    }
                }



                return true;
            case R.id.show_hidden_notes:
                showHidenItems();
                Toast.makeText(getApplicationContext(), "Show Hidden Notes Clicked", Toast.LENGTH_SHORT).show();


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addItem() {
        datas = new ArrayList<>();
        Data data = new Data("item", false, false,false);
        Data data1 = new Data("item1", false, false,false);
        Data data2 = new Data("item2", false, false,false);
        Data data3 = new Data("item3", false, false,false);
        Data data4 = new Data("item4", false, false,false);
        Data data5 = new Data("item5", false, false,false);
        Data data6 = new Data("item6", false, false,false);
        Data data7 = new Data("item7", false, false,false);
        datas.add(data);
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);
        datas.add(data5);
        datas.add(data6);
        datas.add(data7);


    }

    private void updateView() {
        customAdapter = new CustomAdapter(MainActivity.this,datas);
        list = (ListView) findViewById(R.id.list_item);
        assert list != null;
        list.setAdapter(customAdapter);

    }

    private void showHidenItems() {
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).isHidden()) {
                datas.get(i).setHidden(false);

            }
        }
        customAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        curData = (Data) list.getItemAtPosition(position);
        datas.get(position).setTitle(curData.getTitle());
        datas.get(position).setHidden(true);
        datas.get(position).setColor(true);
        customAdapter.notifyDataSetChanged();

        return false;
    }



}
