package com.lbins.Jewelry.data;


import com.lbins.Jewelry.module.AddressObj;

import java.util.List;

/**
 * Created by Administrator on 2016/1/15.
 */
public class ShoppingAddressDATA extends Data {
    private List<AddressObj> data;

    public List<AddressObj> getData() {
        return data;
    }

    public void setData(List<AddressObj> data) {
        this.data = data;
    }
}
