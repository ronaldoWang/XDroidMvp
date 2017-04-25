package cn.droidlover.xdroidmvp.sys.ui;

import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.sys.R;
import cn.droidlover.xdroidmvp.sys.adapter.MainAdapter;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.present.PMain;
import cn.droidlover.xdroidmvp.sys.widget.StateView;
import cn.droidlover.xrecyclerview.RecyclerItemCallback;
import cn.droidlover.xrecyclerview.XRecyclerContentLayout;
import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by haoxi on 2017/4/25.
 */

public class MainFragment extends XFragment<PMain> {
    @BindView(R.id.contentLayout)
    XRecyclerContentLayout contentLayout;
    StateView errorView;
    MainAdapter adapter;

    public SimpleRecAdapter getAdapter() {
        if (adapter == null) {
            adapter = new MainAdapter(context);
            adapter.setRecItemClick(new RecyclerItemCallback<DevelopCustomerModel.DevelopCustomer, MainAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, DevelopCustomerModel.DevelopCustomer model, int tag, MainAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);
                    switch (tag) {
                    }
                }
            });
        }
        return adapter;
    }

    private void initAdapter() {
        setLayoutManager(contentLayout.getRecyclerView());
        contentLayout.getRecyclerView()
                .setAdapter(getAdapter());
        contentLayout.getRecyclerView()
                .setOnRefreshAndLoadMoreListener(new XRecyclerView.OnRefreshAndLoadMoreListener() {
                    @Override
                    public void onRefresh() {
                        getP().loadData(1);
                    }

                    @Override
                    public void onLoadMore(int page) {
                        getP().loadData(page);
                    }
                });


        if (errorView == null) {
            errorView = new StateView(context);
        }
        contentLayout.errorView(errorView);
        contentLayout.loadingView(View.inflate(getContext(), R.layout.view_loading, null));

        contentLayout.getRecyclerView().useDefLoadMoreView();
    }

    public void setLayoutManager(XRecyclerView recyclerView) {
        recyclerView.verticalLayoutManager(context);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initAdapter();
        getP().loadData(1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_pager;
    }


    @Override
    public PMain newP() {
        return new PMain();
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }
}
