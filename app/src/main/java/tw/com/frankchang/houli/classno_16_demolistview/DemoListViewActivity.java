package tw.com.frankchang.houli.classno_16_demolistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DemoListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demolistview);
    }

    //自訂畫面
    public void listview3OnClick(View view) {
        Intent it3 = new Intent(this, ListView3Activity.class);
        startActivity(it3);
    }

    //多欄顯示
    public void listview2OnClick(View view) {
        Intent it2 = new Intent(this, ListView2Activity.class);
        startActivity(it2);
    }

    //單欄顯示
    public void listview1OnClick(View view) {
        Intent it1 = new Intent(this, ListView1Activity.class);
        startActivity(it1);
    }
}
