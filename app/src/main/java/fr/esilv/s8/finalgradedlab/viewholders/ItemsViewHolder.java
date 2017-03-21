package fr.esilv.s8.finalgradedlab.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.esilv.s8.finalgradedlab.R;
import fr.esilv.s8.finalgradedlab.interfaces.OnItemSelectedListener;
import fr.esilv.s8.finalgradedlab.model.Item;


/**
 * Created by Stanislas Daniel Claude Dolcini on 17/03/17.
 */

public class ItemsViewHolder extends RecyclerView.ViewHolder {

    private final TextView title,youtuber,publicationDate;
    private final View view;
    private final ImageView imageView;
    private OnItemSelectedListener onItemSelectedListener;

    public ItemsViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        this.title = (TextView) itemView.findViewById(R.id.video_title);
        this.youtuber = (TextView) itemView.findViewById(R.id.video_youtuber);
        this.imageView = (ImageView) itemView.findViewById(R.id.my_image_view);
        this.publicationDate = (TextView) itemView.findViewById(R.id.publicationDate);
    }

    public void bind(final Item item) {
        title.setText(item.getSnippet().getTitle());
        youtuber.setText(item.getSnippet().getChannelTitle());
        publicationDate.setText(item.getSnippet().getPublishedAt());
        Glide.with(view.getContext()).load(
                item.getSnippet().getThumbnails() != null ?
                        item.getSnippet().getThumbnails().getMedium().getUrl():
                        "http://goo.gl/gEgYUd").into(imageView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemSelectedListener == null) {
                    return;
                }
                onItemSelectedListener.OnItemSelected(item);
            }
        });
    }


    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }


}
