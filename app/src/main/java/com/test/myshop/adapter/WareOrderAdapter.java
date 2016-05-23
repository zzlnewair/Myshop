package com.test.myshop.adapter;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import com.test.myshop.R;
import com.test.myshop.bean.ShoppingCart;



public class WareOrderAdapter extends SimpleAdapter<ShoppingCart> {




    public WareOrderAdapter(Context context, List<ShoppingCart> datas) {
        super(context, R.layout.template_order_wares, datas);

    }

    @Override
    protected void convert(BaseViewHolder viewHoder, final ShoppingCart item) {

//        viewHoder.getTextView(R.id.text_title).setText(item.getName());
//        viewHoder.getTextView(R.id.text_price).setText("￥"+item.getPrice());
        SimpleDraweeView draweeView = (SimpleDraweeView) viewHoder.getView(R.id.drawee_view);
        draweeView.setImageURI(Uri.parse(item.getImgUrl()));

    }


    public float getTotalPrice(){

        float sum=0;
        if(!isNull())
            return sum;

        for (ShoppingCart cart:
                datas) {

                sum += cart.getCount()*cart.getPrice();
        }

        return sum;

    }


    private boolean isNull(){

        return (datas !=null && datas.size()>0);
    }






}
