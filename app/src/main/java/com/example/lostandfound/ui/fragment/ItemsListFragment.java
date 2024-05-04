package com.example.lostandfound.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lostandfound.data.local.entity.CaseEntity;
import com.example.lostandfound.databinding.FragmentItemsListBinding;
import com.example.lostandfound.ui.adapter.ItemsListRvAdapter;
import com.example.lostandfound.ui.viewModels.ItemsListViewModel;
import com.example.lostandfound.R;
import com.example.lostandfound.ui.viewModels.OnItemsLoadedListener;

import java.util.ArrayList;
import java.util.List;

public class ItemsListFragment extends Fragment implements OnItemsLoadedListener {

    private ItemsListViewModel mViewModel;

    private FragmentItemsListBinding binding;
    private ItemsListRvAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentItemsListBinding.inflate(inflater);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ItemsListViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.initiate(getContext(),this);
        // Initialize the adapter
        adapter = new ItemsListRvAdapter(new ArrayList<>());
        mViewModel.getAllItemsAsync();
        // Set the adapter to the RecyclerView
        binding.lotFoundRv.setAdapter(adapter);
    }

    @Override
    public void onItemsLoaded(List<CaseEntity> items) {
        adapter.setData(items);
    }
}