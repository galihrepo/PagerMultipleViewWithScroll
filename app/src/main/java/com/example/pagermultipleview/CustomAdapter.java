package com.example.pagermultipleview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by GALIH ADITYO on 6/16/2015.
 */
public class CustomAdapter extends PagerAdapter {

    private Context context;
    private List<ImageDescModel> list;

    public CustomAdapter(Context context, List<ImageDescModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public float getPageWidth(int position) {
        /*
            return 1 => show 1 item
            return 0.5 = > show 2 item
            return 0.33 = > show 3 item
        */
        return 0.33f;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final String desc = list.get(position).getDesc();
        int image = list.get(position).getImage();

        RelativeLayout layout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout item = (RelativeLayout) inflater.inflate(R.layout.item, layout);
        TextView tv = (TextView) item.findViewById(R.id.desc);
        ImageView iv = (ImageView) item.findViewById(R.id.imageView);

        tv.setText(desc);
        iv.setImageResource(image);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, desc, Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
