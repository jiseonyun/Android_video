package com.example.jiseo.myapplication;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiseo.myapplication.IdPair;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter{

    /* 아이템을 세트로 담기 위한 어레이 */
    private ArrayList<IdPair> pairs= new ArrayList<>();

    @Override
    public int getCount() {
        return pairs.size();
    }

    @Override
    public IdPair getItem(int position) {
        return pairs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        /* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 */
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        /* 'List_item'에 정의된 위젯에 대한 참조 획득 */
        TextView tv_image = (TextView) convertView.findViewById(R.id.image) ;
        TextView tv_title = (TextView) convertView.findViewById(R.id.title) ;

        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        IdPair myItem = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
//        iv_img.setImageDrawable(myItem.getIcon());
        tv_title.setText(myItem.getTitle());
        tv_image.setText(myItem.getImage());

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */


        return convertView;
    }

    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(String title, String image) {

        IdPair pair = new IdPair();

        /* MyItem에 아이템을 setting한다. */
        pair.setTitle(title);
        pair.setImage(image);

        /* mItems에 MyItem을 추가한다. */
        pairs.add(pair);

    }
}
