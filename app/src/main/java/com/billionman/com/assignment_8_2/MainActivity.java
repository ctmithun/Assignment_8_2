package com.billionman.com.assignment_8_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
    }

    private void setData() {
        ListView lv = (ListView) findViewById(R.id.listView);
        List<Contact> lData = buildData();
        ContactAdapter ca = new ContactAdapter(lData);
        lv.setAdapter(ca);
    }

    private List<Contact> buildData() {
        List<Contact> ls = new ArrayList<>();
        for(int i = 1; i <= 5;i++) {
            Contact c = new Contact();
            c.setName("Employee"+i);
            c.setPhoneNumber("984506565"+i);
            ls.add(c);
        }
        return ls;
    }

    class ContactAdapter extends BaseAdapter {
        List<Contact> lc = null;
        @Override
        public int getCount() {
            return lc.size();
        }

        ContactAdapter(List<Contact> contacts) {
            this.lc = contacts;
        }

        @Override
        public Object getItem(int position) {
            return lc.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

            View v = inflater.inflate(R.layout.item_data, null);
            TextView tv1 = (TextView) v.findViewById(R.id.name);
            tv1.setText(lc.get(position).getName());
            TextView tv2 = (TextView) v.findViewById(R.id.ph);
            tv2.setText(lc.get(position).getPhoneNumber());
            return v;
        }
    }
}
