# javaPainter
a simple painter create by java
学校java大作业，就是一个简单的画板<br>
由于老师的特殊要求，所有的java文件放在根目录下，不包含包，所以显得比较凌乱<br>
使用方法：
````
javac javaPainter.java
java javaPainter
````

# Attention
画板的开发环境在linux下，以下地方在windows下测试需要更改：<br>
`Common.java`
````
import com.sun.xml.internal.ws.handler.HandlerException;
````
在windows下没有，需要改成
````
import java.awt.HeadlessException
````
对应的`try...catch`语句也应该改正
