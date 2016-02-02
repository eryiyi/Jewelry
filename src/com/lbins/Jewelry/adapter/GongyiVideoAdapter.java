package com.lbins.Jewelry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.lbins.Jewelry.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * author: ${zhanghailong}
 * Date: 2015/2/6
 * Time: 14:06
 * 类的功能、说明写在此处.
 */
public class GongyiVideoAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<Integer> findEmps;
    private Context mContext;

    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类

    private OnClickContentItemListener onClickContentItemListener;

    public void setOnClickContentItemListener(OnClickContentItemListener onClickContentItemListener) {
        this.onClickContentItemListener = onClickContentItemListener;
    }

    public GongyiVideoAdapter(List<Integer> findEmps, Context mContext) {
        this.findEmps = findEmps;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return findEmps.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gongyi_video_item_xml, null);
            holder.pic = (ImageView) convertView.findViewById(R.id.pic);
            holder.play = (ImageView) convertView.findViewById(R.id.play);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final int favour = findEmps.get(position);
        if (findEmps != null) {
//            imageLoader.displayImage(favour.getCover(), holder.detail_favour_item_cover, UniversityApplication.txOptions, animateFirstListener);
//            holder.detail_favour_item_dateline.setText(favour.getTime());
        }
//        holder.detail_favour_item_cover.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onClickContentItemListener.onClickContentItem(position, 1, null);
//            }
//        });
        return convertView;
    }

    class ViewHolder {
        ImageView pic;
        ImageView play;
    }

}