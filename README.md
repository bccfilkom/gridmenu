# GridMenu

GridMenu is a simple-but-customizable view consisted list of menu arranged in grid-fashioned way.

[![](https://jitpack.io/v/bccfilkom/gridmenu.svg)](https://jitpack.io/#bccfilkom/gridmenu)

<img src="sample.png" title="Grid Menu"/>

## Download

### Gradle:
**Step 1.** Add the JitPack repository to your build file
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

**Step 2.** Add the dependency
```gradle
dependencies {
    implementation 'com.github.bccfilkom:gridmenu:1.0.0'
}
```

### Maven:
**Step 1.** Add the JitPack repository to your build file
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

**Step 2.** Add the dependency
```xml
<dependency>
    <groupId>com.github.bccfilkom</groupId>
    <artifactId>gridmenu</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Include following code in your layout:
```xml
<com.bcc.gridmenuview.GridMenu
    android:id="@+id/menu"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:spanCount="4"/>
```

### Include following code in your activity:
#### Java
```java
GridMenu menu = findViewById(R.id.menu);
menu.setMenuItems(list);
menu.setOnClickListener(new OnItemClickListener() {
    @Override
    public void onClick(int position) {
        // do something
    }
});
```
#### Kotlin
```kotlin
square_menu.setMenuItems(list)
square_menu.setOnClickListener { position: Int ->
    // do something
}
```

## Supported xml Attributes

| Attribute  | Description          		 | Value   | Default Value |
| -----------|-------------------------------|---------|---------------|
| spanCount  | Number of columns in GridMenu.| integer | 3             |

## Contributing to this project

Interested in contributing? please check out [the Contributing Guide](CONTRIBUTING.md) to get started
