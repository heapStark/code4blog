package heap.stark.jdk.classloader;

import heap.stark.jdk.Vo.Student;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Loader extends ClassLoader {


    @Test
    public void t() throws IOException, ClassNotFoundException {
        File file = new File("/home/wzl/IdeaProjects/blog/target/classes/heap/stark/jdk/Vo/Student.class");
        FileInputStream bufferedReader = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        bufferedReader.read(bytes);
        Class c = loadClass(bytes);
        //双亲委派模型被破坏
        Assert.assertNotEquals(Student.class,c);
        Assert.assertEquals(Student.class,new Load2().loadClass("heap.stark.jdk.Vo.Student"));

        Assert.assertEquals(this.loadClass("heap.stark.jdk.Vo.Student"),c);
        Assert.assertEquals(c.getClassLoader(),this);
        Assert.assertEquals(Object.class.getClassLoader(),null);
        Assert.assertEquals(Student.class.getClassLoader(),Thread.currentThread().getContextClassLoader());

    }

    public Class loadClass(byte[] bytes) {
        return defineClass(null, bytes, 0, bytes.length);
    }

    public static class Load2 extends ClassLoader{
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }
}
