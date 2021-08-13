package jdp.prototype.deep_copy;

import java.io.*;

/**
 * @author wmy
 * @date 2021/8/11 9:03
 */
public class DeepProtoType implements Serializable, Cloneable {
    private String name;
    private DeepProtoTypeTarget deepProtoTypeTarget;

    public DeepProtoType() {
        super();
    }

    //深拷贝方式1-重写clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //先完成对基本数据类型和String类型的拷贝
        deep = super.clone();
        //对引用类型的属性单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepProtoTypeTarget = (DeepProtoTypeTarget) deepProtoTypeTarget.clone();
        return deep;
    }

    //深拷贝方式2-通过对象序列化实现（推荐）
    public Object deepClone() {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前对象以对象流的方式输出
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (DeepProtoType) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭流
            try {
                assert bos != null;
                bos.close();
                assert oos != null;
                oos.close();
                assert bis != null;
                bis.close();
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.name = "a";
        deepProtoType.deepProtoTypeTarget = new DeepProtoTypeTarget("b");
        //方式1：重写clone方法完成深拷贝
        DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.clone();
        System.out.println(deepProtoType == deepProtoType1);
        System.out.println(deepProtoType.deepProtoTypeTarget == deepProtoType1.deepProtoTypeTarget);

        //方式2：对象序列化方式完成深拷贝
        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType.deepClone();
        System.out.println(deepProtoType == deepProtoType2);
        System.out.println(deepProtoType.deepProtoTypeTarget == deepProtoType2.deepProtoTypeTarget);


    }
}
