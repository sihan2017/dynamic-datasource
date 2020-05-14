mp内置的ServiceImpl在新增,更改,删除方法上自带事物.会导致切换数据库失败

解决办法:

1、重写自己的ServiceImpl 取消所有事物注解。（用的少不推荐，用的地方多推荐）

2、写自己的service方法，在自己的实现类里调用baseMapper的方法。