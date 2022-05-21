package com.example.helpu3;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {
    Button btn_sub;
    Button btn_sub2;
    private ListView listview;
    private ListViewAdapter adapter;
    TextView receiveView;
    TextView receiveView2;
    SearchView search_view;
    //파이어베이스
    public static ArrayList<ListViewItem> testList = new ArrayList<ListViewItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        //listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        int size = testList.size();
        for (int i = 0; i < size; i++) {
            ListViewItem item = testList.get(i);
            String title = item.getTitle();
            String content = item.getContent();
            //int icon = item.getIcon();
            adapter.addItem(title, R.drawable.welldog, content);
        }
//        Intent intent = getIntent();
//        String title = intent.getStringExtra("title");
//        String content = intent.getStringExtra("content");
//        adapter.addItem(title, R.drawable.welldog,content);
//        adapter.addItem("제목2", R.drawable.welldog, "내용2");
//        adapter.addItem("제목3", R.drawable.welldog, "내용3");
//        adapter.addItem("제목4", R.drawable.welldog, "내용4");
//        adapter.addItem("제목5", R.drawable.welldog, "내용5");
        //삭제는 또  어캐하지....
        //데이터받는부분
//                Intent intent = getIntent();
//                String title = intent.getStringExtra("title");
//                String content = intent.getStringExtra("content");
//                receiveView = (TextView)findViewById(R.id.receiveText);
//                receiveView2 = (TextView)findViewById(R.id.receiveText2);
//                receiveView.setText(title);
//                receiveView2.setText(content);


        adapter.notifyDataSetChanged();

        btn_sub = findViewById(R.id.button_sub);
        btn_sub2 = findViewById(R.id.button_sub2);

        //홈
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        //글쓰기
        btn_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
            }
        });
        //상세보기
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                                parent.getItemAtPosition(position).toString(),
//                                Toast.LENGTH_LONG).show();
                Intent intent =
                        new Intent(getApplicationContext(), CustomActivity.class);
                intent.putExtra("title", testList.get(position).getTitle());
                intent.putExtra("content", testList.get(position).getContent());
                //intent.putExtra("img", testList.get(position).getIcon()); testList에 사진을 저장시켜주면 나옴
                //intent.putExtra("POSITION", position);
                startActivity(intent);

            }
        });
    }
}