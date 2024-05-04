package com.example.lostandfound.ui.adapter;

import android.graphics.Color;

import com.example.lostandfound.R;
import com.example.lostandfound.data.local.entity.CaseEntity;
import com.example.lostandfound.databinding.LostFoundRvItemBinding;
import com.example.lostandfound.ui.base.BaseRecyclerViewAdapter;

import java.util.List;
import java.util.Objects;

public class ItemsListRvAdapter extends BaseRecyclerViewAdapter<LostFoundRvItemBinding, CaseEntity> {

    public ItemsListRvAdapter(List<CaseEntity> initialData) {
        super(initialData);
    }
    @Override
    public void bind(LostFoundRvItemBinding binding, CaseEntity item) {
        String status = item.getStatus();
        if (Objects.equals(status, "Lost")){
            binding.getRoot().setBackgroundColor(Color.GRAY);
        }else {
            binding.getRoot().setBackgroundColor(Color.WHITE);
        }
        binding.tvFoundOrLost.setText(item.getStatus());
        binding.tvName.setText(item.name);
    }

    @Override
    public int getLayoutId() {
        return R.layout.lost_found_rv_item;
    }
}