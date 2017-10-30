package com.tck.animationstudy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/30 0030.
 */

public class DurationFragment extends Fragment implements View.OnClickListener {

    @LayoutRes
    int sampleLayoutRes;

    private TextView durationLabelTv;
    private AppCompatSeekBar durationSb;

    private ImageView imageView;
    private Button up;
    private Button down;
    private Button left;
    private Button right;

    int duration = 300;

    public static DurationFragment newInstance(@LayoutRes int sampleLayoutRes) {
        DurationFragment fragment = new DurationFragment();
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


        durationLabelTv = (TextView) view.findViewById(R.id.durationLabelTv);
        durationSb = (AppCompatSeekBar) view.findViewById(R.id.durationSb);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        up = (Button) view.findViewById(R.id.up);
        down = (Button) view.findViewById(R.id.down);
        left = (Button) view.findViewById(R.id.left);
        right = (Button) view.findViewById(R.id.right);

        durationLabelTv.setText(getContext().getString(R.string.ms_with_value,duration));
        durationSb.setMax(10);
        durationSb.setProgress(1);
        durationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                duration = progress * 300;
                durationLabelTv.setText(getContext().getString(R.string.ms_with_value,duration));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up:
                imageView.animate().translationY(DpUtils.dpToPixel(-100)).setDuration(duration);
                break;
            case R.id.down:
                imageView.animate().translationY(DpUtils.dpToPixel(100)).setDuration(duration);
                break;
            case R.id.left:
                imageView.animate().translationX(DpUtils.dpToPixel(-100)).setDuration(duration);
                break;
            case R.id.right:
                imageView.animate().translationX(DpUtils.dpToPixel(100)).setDuration(duration);
                break;

        }
    }
}
