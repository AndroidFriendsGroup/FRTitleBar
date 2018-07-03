package cn.share.jack.frtitlebar;

import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by jack on 2018/2/1
 */

class FRTitleBarViewHelper {

    private View mContentView;

    private SparseArray<WeakReference<View>> mViews;

    public FRTitleBarViewHelper(View view) {
        this.mContentView = view;
        mViews = new SparseArray<>();
    }

    public View getContentView() {
        return mContentView;
    }

    public <T extends View> T getView(int idRes) {
        //防止多次findViewById
        WeakReference<View> viewWeakReference = mViews.get(idRes);
        View view = null;
        if (null != viewWeakReference) {
            view = viewWeakReference.get();
        }
        if (null == view) {
            view = mContentView.findViewById(idRes);
            if (null != view) {
                mViews.put(idRes, new WeakReference<>(view));
            }
        }
        return (T) view;
    }

    public void setText(int id, CharSequence charSequence) {
        TextView tv = getView(id);
        if (null != tv) {
            tv.setVisibility(View.VISIBLE);
            tv.setText(StringUtils.valueOf(charSequence));
        }
    }

    public void setTextColor(@IdRes int viewId, int textColor) {
        TextView tv = getView(viewId);
        if (null != tv) {
            tv.setVisibility(View.VISIBLE);
            tv.setTextColor(ContextCompat.getColor(mContentView.getContext(), textColor != 0 ? textColor : R.color.white));
        }
    }

    public void setOnClickListener(int id, View.OnClickListener onClickListener) {
        View view = getView(id);
        if (null != view && null != onClickListener) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setDrawable(@IdRes int viewId, int drawableRes, int gravity) {
        TextView tv = getView(viewId);
        if (null != tv && drawableRes != 0) {
            tv.setVisibility(View.VISIBLE);
            switch (gravity) {
                case 0:
                    tv.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0);
                    break;
                case 1:
                    tv.setCompoundDrawablesWithIntrinsicBounds(0, drawableRes, 0, 0);
                    break;
                case 2:
                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableRes, 0);
                    break;
                case 3:
                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, drawableRes);
                    break;
            }
        }
    }
}
