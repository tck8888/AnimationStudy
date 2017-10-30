package com.tck.animationstudy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/10/30 0030.
 */

public class TransitionFragment extends Fragment implements View.OnClickListener {

    @LayoutRes
    int sampleLayoutRes;

    private ImageView imageView;
    private Button up;
    private Button down;
    private Button left;
    private Button right;

    public static TransitionFragment newInstance(@LayoutRes int sampleLayoutRes) {
        TransitionFragment fragment = new TransitionFragment();
        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes", sampleLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ViewStub sampleStub = (ViewStub) view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(sampleLayoutRes);
        sampleStub.inflate();

        imageView = (ImageView) view.findViewById(R.id.imageView);
        up = (Button) view.findViewById(R.id.up);
        down = (Button) view.findViewById(R.id.down);
        left = (Button) view.findViewById(R.id.left);
        right = (Button) view.findViewById(R.id.right);

        up.setOnClickListener(this);
        down.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            sampleLayoutRes = arguments.getInt("sampleLayoutRes");
        }
    }


    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up:
                imageView.animate().translationY(0);
                break;
            case R.id.down:
                imageView.animate().translationY(DpUtils.dpToPixel(150));
                break;
            case R.id.left:
                imageView.animate().translationX(0);
                break;
            case R.id.right:
                imageView.animate().translationX(DpUtils.dpToPixel(150));
                break;
        }
    }
}
