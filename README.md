# GridMenu

GridMenu is a simple-but-customizable view consisted list of menu arranged in grid-fashioned way.

<img src="sample.png" title="Grid Menu"/>

## Download

### Gradle:
```groovy

```
### Maven:
```xml

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

## Supported xml Attributes

| Attribute  | Description          		 | Value   | Default Value |
| -----------|-------------------------------|---------|---------------|
| spanCount  | Number of columns in GridMenu.| integer | 3             |

## Contributing to this project

Interested in contributing? please check out [the Contributing Guide](CONTRIBUTING.md) to get started