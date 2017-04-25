package cn.droidlover.xdroidmvp.sys.ui;

import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.sys.R;
import cn.droidlover.xdroidmvp.sys.adapter.DevelopCustomerFragmentAdapter;
import cn.droidlover.xdroidmvp.sys.model.DevelopCustomerModel;
import cn.droidlover.xdroidmvp.sys.present.PDevelopCustomer;
import cn.droidlover.xdroidmvp.sys.widget.StateView;
import cn.droidlover.xrecyclerview.RecyclerItemCallback;
import cn.droidlover.xrecyclerview.XRecyclerContentLayout;
import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by haoxi on 2017/4/25.
 */

public class DevelopCustomerFragment extends XFragment<PDevelopCustomer> {
    @BindView(R.id.contentLayout)
    XRecyclerContentLayout contentLayout;
    StateView errorView;
    DevelopCustomerFragmentAdapter adapter;

    /**
     * 获得adapter
     *
     * @return
     */
    public SimpleRecAdapter getAdapter() {
        if (adapter == null) {
            adapter = new DevelopCustomerFragmentAdapter(context);
            adapter.setRecItemClick(new RecyclerItemCallback<DevelopCustomerModel.DevelopCustomer, DevelopCustomerFragmentAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, DevelopCustomerModel.DevelopCustomer model, int tag, DevelopCustomerFragmentAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);

                }
            });
        }
        return adapter;
    }

    /**
     * 初始化Adapter
     */
    private void initAdapter() {
        setLayoutManager(contentLayout.getRecyclerView());
        contentLayout.getRecyclerView().setAdapter(getAdapter());
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

    /**
     * 展示数据
     *
     * @param page  页码
     * @param model 数据
     */
    public void showData(int page, DevelopCustomerModel model) {
        if (page > 1) {
            getAdapter().addData(model.getData());
        } else {
            getAdapter().setData(model.getData());
        }

        if (null != model.getData() && !model.getData().isEmpty() && model.getData().size() == 10) {
            contentLayout.getRecyclerView().setPage(page, page + 1);
        } else {
            contentLayout.getRecyclerView().setPage(page, page);
        }

        if (getAdapter().getItemCount() < 1) {
            contentLayout.showEmpty();
            return;
        }
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
    public PDevelopCustomer newP() {
        return new PDevelopCustomer();
    }

    public static DevelopCustomerFragment newInstance() {
        return new DevelopCustomerFragment();
    }
}