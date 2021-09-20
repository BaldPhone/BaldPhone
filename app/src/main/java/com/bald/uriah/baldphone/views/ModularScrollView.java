/*
 * Copyright 2019 Uriah Shaul Mandel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bald.uriah.baldphone.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

import com.bald.uriah.baldphone.utils.BPrefs;

public class ModularScrollView extends ScrollView implements Modular {
    public boolean touchEnabled;

    public ModularScrollView(Context context) {
        super(context);
        touchEnabled = context.getSharedPreferences(BPrefs.KEY, Context.MODE_PRIVATE).getBoolean(BPrefs.TOUCH_NOT_HARD_KEY, false);
    }

    public ModularScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        touchEnabled = context.getSharedPreferences(BPrefs.KEY, Context.MODE_PRIVATE).getBoolean(BPrefs.TOUCH_NOT_HARD_KEY, false);
    }

    public ModularScrollView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        touchEnabled = context.getSharedPreferences(BPrefs.KEY, Context.MODE_PRIVATE).getBoolean(BPrefs.TOUCH_NOT_HARD_KEY, false);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return touchEnabled && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return touchEnabled && super.onTouchEvent(ev);
    }

}
