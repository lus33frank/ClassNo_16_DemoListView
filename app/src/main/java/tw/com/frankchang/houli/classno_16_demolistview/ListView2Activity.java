package tw.com.frankchang.houli.classno_16_demolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListView2Activity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);

        findviewer();
        setDataToListView();
    }

    private void findviewer() {
        listView = (ListView) findViewById(R.id.listView2);
        listView.setOnItemClickListener(listViewListener);
        listView.setOnItemLongClickListener(listViewListenerForLong);
    }

    private void setDataToListView() {
        String[] mStrings = getResources().getStringArray(R.array.mStrings);
        String[] mPlaces = getResources().getStringArray(R.array.mPlaces);

        //建立ArrayList物件
        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        //依陣列個數跑回圈，將資料放進ArrayList
        for (int i = 0; i < mStrings.length; i++){
            //建立HashMap物件
            HashMap<String, Object> items = new HashMap<>();
            items.put("mFood", mStrings[i]);
            items.put("mPlace", mPlaces[i]);

            data.add(items);
        }

        SimpleAdapter sAdt = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2,
                                                new String[]{"mFood", "mPlace"},
                                                new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(sAdt);
    }

    private AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(ListView2Activity.this,
                    ((TextView)view.findViewById(android.R.id.text1)).getText(),
                    Toast.LENGTH_SHORT).show();
        }
    };

    private AdapterView.OnItemLongClickListener listViewListenerForLong = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(ListView2Activity.this,
                    ((TextView)view.findViewById(android.R.id.text2)).getText(),
                    Toast.LENGTH_SHORT).show();

            return false;
            //return true;
        }
    };
}
