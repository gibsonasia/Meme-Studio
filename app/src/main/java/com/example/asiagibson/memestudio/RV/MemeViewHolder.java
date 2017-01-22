package com.example.asiagibson.memestudio.RV;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asiagibson.memestudio.Activities.DemotivationalActivity;
import com.example.asiagibson.memestudio.Activities.GalleryActivity;
import com.example.asiagibson.memestudio.Activities.EnterTextActivity;
import com.example.asiagibson.memestudio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiagibson on 1/19/17.
 */

public class MemeViewHolder extends RecyclerView.ViewHolder {
    public Context context;
    private List<String> memeTitle = new ArrayList<>();
    ImageView memeType;

    public MemeViewHolder(View view) {
        super(view);
        context = view.getContext();

        memeType = (ImageView) itemView.findViewById(R.id.iv_meme_type);
        memeTitle.add("Painter Meme");
        memeTitle.add("Demotivational Meme");
        memeTitle.add("Vanilla Meme");
        memeTitle.add("Doge Meme");
        memeTitle.add("Side-Eye Chloe Meme");
        memeType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), memeTitle.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();

                Intent intent;
                switch (getAdapterPosition()) {
                    case 0:
                        intent = new Intent(context, GalleryActivity.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(context, DemotivationalActivity.class);
                        context.startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(context, EnterTextActivity.class);
                        context.startActivity(intent);
                        break;

                    //                   case 3:
//                        intent = new Intent(context,YOUR_ACTIVITY.class);
//                        break;
//                    case 4:
//                        intent = new Intent(context,YOUR_ACTIVITY.class);
//                        break;


                }
            }
        });
    }

    public void bind(Integer holderMeme) {
        memeType.setImageResource(holderMeme);

    }
}
