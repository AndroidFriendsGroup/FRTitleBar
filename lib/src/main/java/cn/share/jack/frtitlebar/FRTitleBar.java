package cn.share.jack.frtitlebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jack on 2018/1/26
 */

public class FRTitleBar {

    FRTitleBarController controller;

    FRTitleBar(FRTitleBarController.FRTitleBarParams params) {
        controller = new FRTitleBarController(params);
    }

    public static class FRTiTitleBarBuilder {

        FRTitleBarController.FRTitleBarParams params;

        public FRTiTitleBarBuilder(Context context) {
            this(context, null);
        }

        public FRTiTitleBarBuilder(Context context, ViewGroup viewGroup) {
            params = new FRTitleBarController.FRTitleBarParams(context, viewGroup);
            params.mLayoutRes = R.layout.layout_titlebar;
        }

        public FRTiTitleBarBuilder setBackgroundColor(int backgroundColor) {
            params.mBackgroundColor = backgroundColor;
            return this;
        }

        //设置左边文字
        public FRTiTitleBarBuilder setLeftContent(CharSequence leftContent) {
            params.mLeftContent = leftContent;
            return this;
        }

        //设置左边文字颜色
        public FRTiTitleBarBuilder setLeftTextColor(int leftTextColor) {
            params.mLeftTextColor = leftTextColor;
            return this;
        }

        //设置左边图标（本地）
        public FRTiTitleBarBuilder setLeftDrawable(int leftDrawable) {
            params.mLeftDrawable = leftDrawable;
            return this;
        }

        public FRTiTitleBarBuilder setDefaultLeft() {
            params.mLeftDrawable = R.drawable.icon_back_white;
            return this;
        }

        //设置左边点击事件
        public FRTiTitleBarBuilder setLeftOnClickListener(View.OnClickListener onClickListener) {
            params.mLeftOnClickListener = onClickListener;
            return this;
        }

        //设置标题
        public FRTiTitleBarBuilder setTitleContent(CharSequence titleContent) {
            params.mTitleContent = titleContent;
            return this;
        }

        //设置标题文字颜色
        public FRTiTitleBarBuilder setTitleTextColor(int titleTextColor) {
            params.mTitleTextColor = titleTextColor;
            return this;
        }

        //设置右边文字
        public FRTiTitleBarBuilder setRightContent(CharSequence rightContent) {
            params.mRightContent = rightContent;
            return this;
        }

        //设置标题文字颜色
        public FRTiTitleBarBuilder setRightTextColor(int rightTextColor) {
            params.mRightTextColor = rightTextColor;
            return this;
        }

        //设置右边图标（本地）
        public FRTiTitleBarBuilder setRightDrawable(int rightDrawable) {
            params.mRightDrawable = rightDrawable;
            return this;
        }

        //设置右边图标（网络）
        public FRTiTitleBarBuilder setRightIcon(String rightIcon) {
            params.mRightIcon = rightIcon;
            return this;
        }

        //设置右边点击事件
        public FRTiTitleBarBuilder setRightOnClickListener(View.OnClickListener onClickListener) {
            params.mRightOnClickListener = onClickListener;
            return this;
        }

        public FRTitleBar builder() {
            FRTitleBar titleBar = new FRTitleBar(params);
            params.apply(titleBar.controller);
            return titleBar;
        }
    }
}