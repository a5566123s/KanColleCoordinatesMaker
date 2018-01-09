# KanColleCoordinates
舰娘立绘坐标文件生成器(仮)
====
根据官方的api_start2一键生成舰娘立绘坐标文件(config.ini)
--------
可用于保存官方原版立绘的坐标
----

带有限定立绘的舰娘swf文件只有在实装期间才能保存
而如果只使用带限定立绘的swf会发生坐标偏移（因为随着swf更新，记录了对应限定立绘坐标的api_start2文件也会跟着更新）
从限定立绘生效期间的api_start2文件中提取出舰娘立绘的坐标，生成对应的.config.ini文件和swf一起使用就能达到完美效果

之前看到NGA上有dalao收集限定立绘期间的swf和config.ini坐标文件(https://bbs.ngacn.cc/read.php?tid=9507482)
但是很久没更新了。为了随时能使用翔鹤的圣诞立绘就自己写了下
目前没有图形界面（写了但是有Bug）
暂时先丢个java源文件（

api_start2文件如何获取：https://bbs.ngacn.cc/read.php?tid=10045361

一键生成config.ini文件，支持岛风Go和ACGPower（ACGPower勾选兼容.hack魔改）
