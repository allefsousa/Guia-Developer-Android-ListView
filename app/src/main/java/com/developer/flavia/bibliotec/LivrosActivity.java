package com.developer.flavia.bibliotec;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class LivrosActivity extends AppCompatActivity {
    private ListView listView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);
        // titulos listView
        String [] NomeLivros = new String[]{"Android Arsenal ","Documentação Google","StackOverflow Android"};
        // adaptador responsavel por montar o list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,NomeLivros);
        listView = (ListView)findViewById(R.id.listLivros);
        listView.setAdapter(adapter);


        /*******************************************************************************************
         * Evento de click no List View
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                String url=null;
                switch (position){

                    case 0:
                         url = "https://android-arsenal.com/";
                        i.setData(Uri.parse(url));
                        startActivity(i);

                        break;
                    case 1:
                         url = "https://developer.android.com/index.html";
                        i.setData(Uri.parse(url));
                        startActivity(i);

                        break;
                    case 2:

                         url = "http://stackoverflow.com/questions/tagged/android";
                        i.setData(Uri.parse(url));
                        startActivity(i);

                        break;

                }
            }
        });


    }
}
