package com.andkid.myrecyclerview.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andkid.myrecyclerview.R;
import com.andkid.myrecyclerview.adapter.GirlRVAdapter;
import com.andkid.myrecyclerview.callback.GirlCallback;
import com.andkid.myrecyclerview.data.GirlSet;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.Call;

/**
 * Created by AndKid on 2017/3/1.
 */ // Instances of this class are fragments representing a single
// object in our collection.
public class GirlsFragment extends Fragment {
	public static final String ARG_OBJECT = "object";
	MyRecyclerView recyclerView;

	public void getGirlSet() {

		OkHttpUtils
				.get()
				.url("http://gank.io/api/data/福利/30/1")
				.build()
				.execute(new GirlCallback() {
					@Override
					public void onError(Call call, Exception e, int id) {

					}

					@Override
					public void onResponse(GirlSet response, int id) {
						if (response != null && response.isError() == false) {
							((GirlRVAdapter)recyclerView.getAdapter()).setGirls(response.getResults());
						}
					}
				});
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getGirlSet();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
	                         ViewGroup container, Bundle savedInstanceState) {
		// The last two arguments ensure LayoutParams are inflated
		// properly.
		final View rootView = inflater.inflate(
				R.layout.fragment_collection_object, container, false);
		recyclerView = (MyRecyclerView) rootView.findViewById(R.id.recycler_view);
		recyclerView.setAdapter(new GirlRVAdapter());
		recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
		return rootView;
	}

}
