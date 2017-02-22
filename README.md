# Scoreboard
Scoreboard library for bukkit based minecraft server.

## Example
A sidebar with some effect for player.
```
SidebarBoard b = SidebarBoard.of(this, p);

b.setBody(FixedBody.of(TextLine.of("这是第一行"),
        LineFactory.looped("这行是滚动的", 6),
        LineFactory.lighted("这行会闪烁", ChatColor.BLUE, ChatColor.GOLD),
        MixedLine.of(TextLine.of("这行混合了"), LineFactory.magic("魔术", 4), TextLine.of("效果"))
));
b.setHead(TextLine.of("这是一个简单的例子"));

b.update(p::isOnline, 10); // Set this board uodate each 10 tick while player online.
```

More flexible sidebar body builder by extend `FixedBodyHandler` or impl `LineListBuilder`.