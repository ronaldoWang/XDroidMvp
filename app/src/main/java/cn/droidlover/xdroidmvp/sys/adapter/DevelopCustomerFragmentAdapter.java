package cn.droidlover.xdroidmvp.sys.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.kit.KnifeKit;
import cn.droidlover.xdroidmvp.sys.R;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;

/**
 * Created by haoxi on 2017/4/25.
 */

public class DevelopCustomerFragmentAdapter extends SimpleRecAdapter<DevelopCustomerModel.DevelopCustomer, DevelopCustomerFragmentAdapter.ViewHolder> {
    public static final int TAG_VIEW = 0;
    public DevelopCustomerFragmentAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_main;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DevelopCustomerModel.DevelopCustomer item = data.get(position);
        holder.tvItem.setText(item.getCustomerName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getRecItemClick() != null) {
                    getRecItemClick().onItemClick(position, item, TAG_VIEW, holder);
                }
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_tv_item)
        TextView tvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(this, itemView);
        }
    }
}
