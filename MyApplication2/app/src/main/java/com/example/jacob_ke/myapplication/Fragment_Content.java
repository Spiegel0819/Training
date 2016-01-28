/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.jacob_ke.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment_Content extends Fragment {
    final static String ARG_POSITION = "position";
    private static final String TAG = "Fragment_Content";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        Log.v(TAG, "onCreateView!!!");
        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);

        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "onStart!!!");
        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateContentView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateContentView(mCurrentPosition);
        }
    }

    public void updateContentView(int position) {
        Log.v(TAG, "updateArticleView");
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText(Fragment_Array.Articles[position]);
        Button button = (Button) getActivity().findViewById(R.id.demo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DisplayMessageActivity_1.class);
                startActivity(intent);
            }
        });
        ImageView img = (ImageView) getActivity().findViewById(R.id.img);
        img.setImageResource(R.drawable.unweb);
        if (position == 0 ) {

            button.setVisibility(View.VISIBLE);
            img.setVisibility(View.INVISIBLE);
        } else {
            button.setVisibility(View.INVISIBLE);
            img.setVisibility(View.VISIBLE);
        }
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG, "onSaveInstanceState!!!");
        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "onResume!!!");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "onPause!!!");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "onStop!!!");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy!!!");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(TAG, "onDestroyView!!!");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(TAG, "onDetach!!!");
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG, "onAttach");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "onCreate!!!");
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(TAG, "onAttachCreated");
    }
}