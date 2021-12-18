package tdtu.lab04.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> data;
    ArrayAdapter<String> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listview1
        listView =findViewById(R.id.listview);

        data=getMockData();
        adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item_view,
                R.id.my_text_view,
                data
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,data.get(i).toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private ArrayList<String> getMockData() {
        ArrayList<String> mockData = new ArrayList<>();
        for (int i=1;i<=6;i++){
            mockData.add(new String("item "+i));
        }


        return mockData;
    }
}