package com.andkid.myrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.andkid.myrecyclerview.R;
import com.andkid.myrecyclerview.data.Girl;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuguan.chen on 2017/3/6.
 */

public class GirlRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	public static final String TAG = "GirlRVAdapter";

	public static final int TYPE_TEXT_VIEW = 1;
	public static final int TYPE_IMG_VIEW = 2;

	public List<Girl> getGirls() {
		if (girls == null)
			girls = new ArrayList();
		return girls;
	}

	public void setGirls(List<Girl> girls) {
		this.girls = girls;
		notifyDataSetChanged();
	}

	private List<Girl> girls;


	public static class TextViewHolder extends RecyclerView.ViewHolder {
		private final TextView textView;

		public TextViewHolder(View v) {
			super(v);
			textView = (TextView) v;
		}

		public TextView getTextView() {
			return textView;
		}

	}

	public static class ImageViewHolder extends RecyclerView.ViewHolder {
		private final ImageButton imageButton;

		public ImageViewHolder(View v) {
			super(v);
			imageButton = (ImageButton) v;
		}

		public ImageButton getImageButton() {
			return imageButton;
		}

	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		switch (viewType) {
			case TYPE_TEXT_VIEW:
				TextView textView = new TextView(parent.getContext());
				textView.setTextSize(60);
				return new TextViewHolder(textView);
			case TYPE_IMG_VIEW:
				ImageButton imageView = (ImageButton) LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_girl, parent, false);
				return new ImageViewHolder(imageView);
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		switch (getItemViewType(position)) {
			case TYPE_TEXT_VIEW:
				((TextViewHolder) holder).getTextView().setText("当前位置 " + position);
				break;
			case TYPE_IMG_VIEW:
				Glide.with(holder.itemView.getContext())
						.load(getGirls().get(position).getUrl())
						.into(((ImageViewHolder) holder).getImageButton());
				break;
		}
	}

	@Override
	public int getItemCount() {
		return getGirls().size();
	}

	@Override
	public int getItemViewType(int position) {
		return TYPE_IMG_VIEW;
	}
}
