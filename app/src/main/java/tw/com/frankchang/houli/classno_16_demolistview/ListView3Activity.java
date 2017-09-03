package tw.com.frankchang.houli.classno_16_demolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListView3Activity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview3);

        findviewer();
        setDataToListView();
    }

    private void findviewer() {
        listView = (ListView) findViewById(R.id.listView3);
    }

    private void setDataToListView() {
        String[] mStrings = getResources().getStringArray(R.array.mStrings);
        String[] mPlaces = getResources().getStringArray(R.array.mPlaces);
        int[] pics = {R.drawable.apple, R.drawable.brick_wall, R.drawable.redstar,
                        R.drawable.yellowstar, R.drawable.greenstar};

        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
        for (int rows = 0; rows < mStrings.length; rows++){
            HashMap<String, Object> items = new HashMap<>();
            items.put("pics", pics[rows%5]);
            items.put("food", mStrings[rows]);
            items.put("places", mPlaces[rows]);

            data.add(items);
        }

        MyBaseAdapter baseAdt = new MyBaseAdapter(this, data);
        listView.setAdapter(baseAdt);
    }
}
