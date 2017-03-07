package com.andkid.myrecyclerview.callback;

import com.andkid.myrecyclerview.data.GirlSet;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * Created by yuguan.chen on 2017/3/7.
 */

public abstract class GirlCallback extends Callback<GirlSet> {

	@Override
	public GirlSet parseNetworkResponse(Response response, int id) throws Exception {
		String string = response.body().string();
		GirlSet girlSet = new Gson().fromJson(string, GirlSet.class);
		return girlSet;
	}
}
