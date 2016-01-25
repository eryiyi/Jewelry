package com.lbins.Jewelry.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lbins.Jewelry.R;
import com.lbins.Jewelry.module.AddressObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * author: ${zhanghailong}
 * Date: 2015/2/6
 * Time: 14:06
 * 我的收货地址
 */
public class ItemMineAddressAdapter extends BaseAdapter {
    private ViewHolder holder;
    private List<AddressObj> lists;
    private Context mContext;
    Resources res;

    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
    ImageLoader imageLoader = ImageLoader.getInstance();//图片加载类

    private OnClickContentItemListener onClickContentItemListener;

    public void setOnClickContentItemListener(OnClickContentItemListener onClickContentItemListener) {
        this.onClickContentItemListener = onClickContentItemListener;
    }

    public ItemMineAddressAdapter(List<AddressObj> lists, Context mContext) {
        this.lists = lists;
        this.mContext = mContext;
        res = mContext.getResources();
    }

    @Override
    public int getCount() {
        return lists.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_address_adapter, null);
            holder.item_nickname = (TextView) convertView.findViewById(R.id.item_nickname);
            holder.item_moren = (TextView) convertView.findViewById(R.id.item_moren);
            holder.item_tel = (TextView) convertView.findViewById(R.id.item_tel);
            holder.item_address = (TextView) convertView.findViewById(R.id.item_address);
            holder.item_zip = (TextView) convertView.findViewById(R.id.item_zip);
            holder.item_in = (ImageView) convertView.findViewById(R.id.item_in);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final AddressObj favour = lists.get(position);
        if (favour != null) {
            holder.item_nickname.setText(favour.getContact_name());
            holder.item_tel.setText(favour.getContact_mobile());
            holder.item_zip.setText("");
            holder.item_address.setText(favour.getAddress());
//            if (favour.getIs_default_address().equals("0")){
                //不是默认的，隐藏掉默认标签
//               holder.item_moren.setVisibility(View.GONE);
//            }else{
//                holder.item_moren.setVisibility(View.VISIBLE);
//            }

        }

        return convertView;
    }

    class ViewHolder {
        TextView item_nickname;
        TextView item_moren;
        TextView item_tel;
        TextView item_address;
        TextView item_zip;
        ImageView item_in;
    }

}