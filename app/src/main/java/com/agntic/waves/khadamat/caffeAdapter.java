package com.agntic.waves.khadamat;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.agntic.waves.R;
import com.bugsnag.android.Bugsnag;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


/**
 * Created by root on 2/3/16.
 */
public class caffeAdapter extends RecyclerView.Adapter<caffeAdapter.ViewHolder> {

    private Context context;
    public static List<CofModels> mobiles = new ArrayList<>();

    public caffeAdapter(Context context, List<CofModels> mobiles) {
        this.context = context;
        this.mobiles = new ArrayList<>();
        this.mobiles = mobiles;
    }

    @Override
    public caffeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardView = inflater.inflate(R.layout.reitem, null, false);
        final caffeAdapter.ViewHolder viewHolder = new caffeAdapter.ViewHolder(cardView);
        viewHolder.mobileImage = (ImageView) cardView.findViewById(R.id.img_item_rec);
        viewHolder.modelName = (TextView) cardView.findViewById(R.id.txt_item_rec);


        if (mobiles.get(0).getUrl_img() != null) {

            RequestOptions options = new RequestOptions()
                    .error(R.drawable.default_artwork)
                    .fitCenter();

            //Glide.with(context)
            //        .asBitmap().load(mobiles.get(0).getUrl_img())
             //       .apply(options).into(Coffe.imageView2);
            Glide.with(context)
                    .load(mobiles.get(0).getUrl_img())
                    .thumbnail( 0.5f )
                    .apply(options)
                    .into(Coffe.imageView2);


            try {

                Glide.with(context)
                        .load(mobiles.get(0).getUrl_img())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .thumbnail( 0.5f )
                        //.diskCacheStrategy(DiskCacheStrategy.ALL)
                        .apply(bitmapTransform(new BlurTransformation(42)))
                        .into(Coffe.imageView1);
            } catch (Exception e) {
                Bugsnag.notify(e);
                e.printStackTrace();
            }

        } else {
            Returant.imageView2.setImageResource(R.drawable.default_artwork);
        }


        viewHolder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    int position = viewHolder.getAdapterPosition();

                    try {
                        /**List<MusicManager.Music> musicList = new ArrayList<>();

                         MusicManager.Music music = new MusicManager.Music(mobiles.get(position).Name, mobiles.get(position).Url_img, mobiles.get(position).artist, mobiles.get(position).author);

                         musicList.add(music);

                         Music.mManager.setPlayList(musicList);
                         Music.mManager.startPlay(0);
                         Music.initMusicManager(false);*/

                        if (mobiles.get(position).getUrl_img() != null) {

                            RequestOptions options = new RequestOptions()
                                    .error(R.drawable.default_artwork)
                                    .fitCenter();

                            //Glide.with(context)
                            //        .asBitmap().load(mobiles.get(position).getUrl_img())
                            //        .apply(options).into(Coffe.imageView2);
                            Glide.with(context)
                                    .load(mobiles.get(position).getUrl_img())
                                    .thumbnail( 0.5f )
                                    .apply(options)
                                    .into(Coffe.imageView2);

                        } else {
                            Returant.imageView2.setImageResource(R.drawable.default_artwork);
                        }

                    } catch (Exception e) {
                        Bugsnag.notify(e);
                        e.printStackTrace();
                    }

                    try {
                    v.animate().scaleY(1.05f).scaleX(1.05f).start();
                    } catch (Exception e) {
                        Bugsnag.notify(e);
                        e.printStackTrace();
                    }

                    try {

                    Glide.with(context)
                            .load(mobiles.get(position).getUrl_img())
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .thumbnail( 0.5f )
                            //.diskCacheStrategy(DiskCacheStrategy.ALL)
                            .apply(bitmapTransform(new BlurTransformation(42)))
                            .into(Coffe.imageView1);
                    } catch (Exception e) {
                        Bugsnag.notify(e);
                        e.printStackTrace();
                    }
                }else {
                    try {
                    v.animate().scaleY(1f).scaleX(1f).start();
                    } catch (Exception e) {
                        Bugsnag.notify(e);
                        e.printStackTrace();
                    }
                }
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();

                try {
                /**List<MusicManager.Music> musicList = new ArrayList<>();

                MusicManager.Music music = new MusicManager.Music(mobiles.get(position).Name, mobiles.get(position).Url_img, mobiles.get(position).artist, mobiles.get(position).author);

                musicList.add(music);

                Music.mManager.setPlayList(musicList);
                Music.mManager.startPlay(0);
                Music.initMusicManager(false);*/

                    if (mobiles.get(position).getUrl_img() != null) {

                        RequestOptions options = new RequestOptions()
                                .error(R.drawable.default_artwork)
                                .fitCenter();

                        //Glide.with(context)
                        //        .asBitmap().load(mobiles.get(position).getUrl_img())
                        //        .apply(options).into(Coffe.imageView2);
                        Glide.with(context)
                                .load(mobiles.get(position).getUrl_img())
                                .thumbnail( 0.5f )
                                .apply(options)
                                .into(Coffe.imageView2);

                    } else {
                        Returant.imageView2.setImageResource(R.drawable.default_artwork);
                    }

                } catch (Exception e) {
                    Bugsnag.notify(e);
                    e.printStackTrace();
                }

            }
        });



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(caffeAdapter.ViewHolder holder, int position) {

        ImageView mobileImageView = (ImageView) holder.mobileImage;

        RequestOptions options = new RequestOptions()
                .error(R.drawable.default_artwork);

        //Glide.with(context)
        //        .asBitmap().load(mobiles.get(position).getUrl_img())
        //        .apply(options).into(mobileImageView);
        Glide.with(context)
                .load(mobiles.get(position).getUrl_img())
                .thumbnail( 0.5f )
                .apply(options)
                .into(mobileImageView);

        /*if (mCurrentMusic2.albumCover != null) {
            mobileImageView.setImageBitmap(
                    BitmapFactory.decodeByteArray(
                            mobiles.get(position).albumCover, 0, mobiles.get(position).albumCover.length
                    )
            );
        } else {
            mobileImageView.setImageResource(R.drawable.default_artwork);
        }**/


        TextView modelTextView = (TextView) holder.modelName;
        modelTextView.setText(mobiles.get(position).getName());


        //Get file font
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "IRANSansMobile.ttf");

        modelTextView.setTypeface(typeface);


    }

    @Override
    public int getItemCount() {
        return mobiles.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mobileImage;
        TextView modelName;

        public ViewHolder(View itemView) {
            super(itemView);
            mobileImage = (ImageView) itemView.findViewById(R.id.img_item_rec);
            modelName = (TextView) itemView.findViewById(R.id.txt_item_rec);
        }
    }

}
