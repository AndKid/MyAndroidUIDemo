package com.andkid.myrecyclerview.data;

import java.util.List;

/**
 * Created by yuguan.chen on 2017/3/7.
 */

public class GirlSet {
	public boolean error;
	List<Girl> results;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<Girl> getResults() {
		return results;
	}

	public void setResults(List<Girl> results) {
		this.results = results;
	}
}
