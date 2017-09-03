package tw.com.frankchang.houli.classno_16_demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 張景翔 on 2017/5/2.
 */

public class MyBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<HashMap<String, Object>> data;

    public MyBaseAdapter(Context context, ArrayList<HashMap<String, Object>> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyTag myTag = new MyTag();

        if (convertView == null){
            //view不存在時
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_customize_listview, null);
            myTag.imgview = (ImageView) convertView.findViewById(R.id.imageView);
            myTag.tvShow1 = (TextView) convertView.findViewById(R.id.textView_food);
            myTag.tvShow2 = (TextView) convertView.findViewById(R.id.textView_places);

            convertView.setTag(myTag);
        }
        else{
            //view存在時
            myTag = (MyTag)convertView.getTag();
        }

        //塞資料
        myTag.imgview.setImageResource((Integer) data.get(position).get("pics"));
        myTag.tvShow1.setText((String)data.get(position).get("food"));
        myTag.tvShow2.setText((String)data.get(position).get("places"));

        return convertView;
    }

    private class MyTag{
        TextView tvShow1, tvShow2;
        ImageView imgview;
    }
}
