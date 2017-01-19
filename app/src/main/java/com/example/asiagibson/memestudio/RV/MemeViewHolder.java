package com.example.asiagibson.memestudio.RV;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.asiagibson.memestudio.R;

/**
 * Created by asiagibson on 1/19/17.
 */

public class MemeViewHolder extends RecyclerView.ViewHolder {

    ImageView memeType;

    public MemeViewHolder(View view) {
        super(view);

        memeType = (ImageView) itemView.findViewById(R.id.iv_meme_type);
    }

    public void bind(Integer holderMeme){
        memeType.setImageResource(holderMeme);
    }
}
