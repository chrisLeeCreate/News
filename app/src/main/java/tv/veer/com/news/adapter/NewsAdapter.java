package tv.veer.com.news.adapter;

// +----------------------------------------------------------------------
// | CreateTime: 17/8/3 
// +----------------------------------------------------------------------
// | Author:     lishaowei
// +----------------------------------------------------------------------
// | Description:  
// +----------------------------------------------------------------------

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import tv.veer.com.news.R;
import tv.veer.com.news.greenDao.New;

public class NewsAdapter extends RecyclerArrayAdapter<New> {
    private static final int Type_One = 0;
    private static final int TYPE_Two = 1;

    private boolean setHeader = false;

    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        if (setHeader) {
            return new NewsViewHolder(parent);
        } else {
            if (viewType == Type_One) {
                return new PhotpHolder(parent);
            } else {
                return new NewsViewHolder(parent);
            }
        }

    }

    private class PhotpHolder extends BaseViewHolder<New> {
        private SimpleDraweeView photo;

        public PhotpHolder(ViewGroup itemView) {
            super(itemView, R.layout.item_photo);
            photo = $(R.id.iv_big_photo);
        }

        @Override
        public void setData(New news) {
            photo.setImageURI(Uri.parse(news.getThumb_url()));
        }
    }

    private class NewsViewHolder extends BaseViewHolder<New> {
        private SimpleDraweeView photo;
        private TextView title;
        private TextView des;

        public NewsViewHolder(ViewGroup itemView) {
            super(itemView, R.layout.item_news);
            title = $(R.id.tv_title);
            des = $(R.id.tv_description);
            photo = $(R.id.iv_photo);
        }

        @Override
        public void setData(New news) {
            photo.setImageURI(Uri.parse(news.getThumb_url()));
            title.setText(news.getTitle());
            des.setText(news.getCategory());
        }
    }

    @Override
    public int getViewType(int position) {
        if (position == 0) {
            return Type_One;
        } else {
            return TYPE_Two;
        }
    }


    public void setHeader(boolean setHeader) {
        this.setHeader = setHeader;
    }
}
