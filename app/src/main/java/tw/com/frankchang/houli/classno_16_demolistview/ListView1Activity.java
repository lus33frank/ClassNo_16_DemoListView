package tw.com.frankchang.houli.classno_16_demolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListView1Activity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview1);

        findviewer();
        setDataToListView();
    }

    private void findviewer() {
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(listViewListener);
    }

    private void setDataToListView() {
        String[] mStrings = getResources().getStringArray(R.array.mStrings);

        ArrayAdapter<String> adt = new ArrayAdapter<String>(this,
                                                            android.R.layout.simple_list_item_1,
                                                            mStrings);
        listView.setAdapter(adt);
    }

    private AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(ListView1Activity.this, ((TextView)view).getText(),
                            Toast.LENGTH_SHORT).show();
        }
    };
}
