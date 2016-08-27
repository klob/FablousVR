
# Simple VrView Implement
Providing a library which can help you implement a VrView easily.  

# Sample

see the mp4 [https://github.com/klob/FablousVR/blob/master/VrDemo.mp4](https://github.com/klob/FablousVR/blob/master/VrDemo.mp4)

# Usage
VrLayout  
```xml

		<com.diandi.klob.vrview.VrLayout
   		 xmlns:android="http://schemas.android.com/apk/res/android"
   		 android:id="@+id/layout_vr"
   		 android:layout_width="match_parent"
  		 android:layout_height="match_parent"
    />

```
set two renders for the VrView  

```java  

		mVrRender = new VrRender(this, bitmap);
        mVrRender2 = new VrRender(this, bitmap);
        mGlSurfaceView.setRender(mVrRender,mVrRender2);

```
and then call

```java  

    protected void onResume() {
        super.onResume();
        if (null != mGlSurfaceView) {
            mGlSurfaceView.onResume();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != mGlSurfaceView) {
            mGlSurfaceView.onPause();
        }
    }
```
#More
see the demo or [https://developers.google.com/vr/](https://developers.google.com/vr/)

# License

    Copyright (C) 2016 klobliu (http://klob.diandi.life).

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
