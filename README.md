# ParallaxViewPager

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![](https://jitpack.io/v/Haegon/ParallaxViewPager.svg)](https://jitpack.io/#Haegon/ParallaxViewPager)


## Demo

<img src="https://github.com/Haegon/ParallaxViewPager/tree/master/extra/Screenshot1.png" width="360px" height="640px"/>

<img src="https://github.com/Haegon/ParallaxViewPager/tree/master/extra/Screenshot2.png" width="360px" height="640px"/>

### Download from Google Play

<a href="https://play.google.com/store/apps/details?id=com.gohn.parallaxviewpager.sample"><img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" height="50px"/></a>



## Add to your project

Gradle

* Add it in your root build.gradle at the end of repositories:
```Gradle
allprojects {
    repositories {
    	...
    	maven { url 'https://jitpack.io' }
    }
}
```

* Add the dependency
```Gradle
dependencies {
    compile 'com.github.Haegon:ParallaxViewPager:1.0.0'
}
```


Maven

* Add the JitPack repository to your build file
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

* Add the dependency
```xml
<dependency>
    <groupId>com.github.Haegon</groupId>
    <artifactId>ParallaxViewPager</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### ViewPager
```xml
<com.gohn.parallaxviewpager.ParallaxViewPager
    android:id="@+id/pager"
    android:layout_width="match_parent"
    android:layout_height="200dp"/>
```

### Layout Resource of Adapter Item
```xml
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/image"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <TextView
        android:id="@+id/text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|left" />

    <TextView
        android:id="@+id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</FrameLayout>
```


### Configuration in Java Code
```Java
ParallaxViewPager pager = (ParallaxViewPager) findViewById(R.id.pager);

pager.addMovementToView(R.id.title, 0.0f); // Stop On View
pager.addMovementToView(R.id.text, 0.2f); // Move Little
pager.addMovementToView(R.id.image, 0.8f); // Move Much

pager.setAdapter(new SampleAdapter());
```

License
=======

    Copyright 2017 Haegon Koh

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
