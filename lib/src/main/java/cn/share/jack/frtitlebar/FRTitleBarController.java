package cn.share.jack.frtitlebar;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jack on 2018/1/31
 */

class FRTitleBarController {

    static final int GRAVITY_LEFT = 0;
    static final int GRAVITY_TOP = 1;
    static final int GRAVITY_RIGHT = 2;
    static final int GRAVITY_BOTTOM = 3;

    private FRTitleBarParams mParams;
    private FRTitleBarViewHelper viewHelper;

    FRTitleBarController(FRTitleBarParams params) {
        this.mParams = params;
        createAndBindView();
    }

    private void createAndBindView() {
        //创建View
        //没传父布局
        if (null == mParams.mParent) {
            //获取activity的根布局(DecorView的第一个子view为LinearLayout)
            ViewGroup viewRoot = (ViewGroup) ((Activity) (mParams.mContext)).getWindow().getDecorView();
            mParams.mParent = (ViewGroup) viewRoot.getChildAt(0);
        }
        if (null == mParams.mParent) {
            return;
        }
        if (mParams.mLayoutRes == 0) {
            throw new IllegalArgumentException("titlebar布局不能为空");
        }
        View mNavigationView = LayoutInflater.from(mParams.mContext).inflate(mParams.mLayoutRes, mParams.mParent, false);
        mParams.mParent.addView(mNavigationView, 0);   //添加到ViewGroup第一个位置
    }

    public void setText(int id, CharSequence charSequence) {
        viewHelper.setText(id, charSequence);
    }

    public void setOnClickListener(int id, View.OnClickListener onClickListener) {
        viewHelper.setOnClickListener(id, onClickListener);
    }

    public void setTitleBarViewHelper(FRTitleBarViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    public <T extends View> T getView(int viewId) {
        return viewHelper.getView(viewId);
    }

    public void setTextColor(@IdRes int viewId, int textColor) {
        viewHelper.setTextColor(viewId, textColor);
    }

    public void setDrawable(@IdRes int viewId, int drawableRes, int gravity) {
        viewHelper.setDrawable(viewId, drawableRes, gravity);
    }

    public static class FRTitleBarParams {

        public Context mContext;
        public ViewGroup mParent;
        public int mLayoutRes;
        public CharSequence mLeftContent;
        public int mLeftDrawable;
        public CharSequence mTitleContent;
        public CharSequence mRightContent;
        public int mRightDrawable;
        public String mRightIcon;
        public View.OnClickListener mLeftOnClickListener;
        public View.OnClickListener mRightOnClickListener;
        public int mBackgroundColor;
        public int mLeftTextColor;
        public int mTitleTextColor;
        public int mRightTextColor;

        public FRTitleBarParams(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mParent = viewGroup;
        }

        public void apply(FRTitleBarController controller) {
            FRTitleBarViewHelper viewHelper = null;
            if (null!=mParent){
                viewHelper=new FRTitleBarViewHelper(mParent);
            }
            if (null!=viewHelper){
                controller.setTitleBarViewHelper(viewHelper);
                controller.setText(R.id.lt_tv_titlebar_left, mLeftContent);
                controller.setText(R.id.lt_tv_titlebar_title, mTitleContent);
                controller.setText(R.id.lt_tv_titlebar_right, mRightContent);
                controller.setDrawable(R.id.lt_tv_titlebar_left, mLeftDrawable, FRTitleBarController.GRAVITY_LEFT);
                controller.setDrawable(R.id.lt_tv_titlebar_right, mRightDrawable, FRTitleBarController.GRAVITY_RIGHT);
                controller.getView(R.id.lt_rl_main).setBackgroundColor(ContextCompat.getColor(mContext, mBackgroundColor != 0 ? mBackgroundColor : R.color.white));
                controller.setTextColor(R.id.lt_tv_titlebar_left, mLeftTextColor);
                controller.setTextColor(R.id.lt_tv_titlebar_title, mTitleTextColor);
                controller.setTextColor(R.id.lt_tv_titlebar_right, mRightTextColor);
                if (null == mLeftOnClickListener) {
                    controller.setOnClickListener(R.id.lt_tv_titlebar_left, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((Activity) mContext).finish();
                        }
                    });
                } else {
                    controller.setOnClickListener(R.id.lt_tv_titlebar_left, mLeftOnClickListener);
                }
                if (null != mRightOnClickListener) {
                    controller.setOnClickListener(!StringUtils.isEmpty(mRightIcon) ? R.id.lt_iv_right : R.id.lt_tv_titlebar_right, mRightOnClickListener);
                }
            }
        }
    }
}