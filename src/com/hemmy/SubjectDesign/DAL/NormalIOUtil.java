package com.hemmy.SubjectDesign.DAL;

import java.io.IOException;

public interface NormalIOUtil {
   Object readObject(String name) throws IOException, ClassNotFoundException;//从文档中读取对象；
   void writeObject(Object obj,String name);//将对象写入文档；
   void reviseObject(Object obj,String name);//修改文档中的某对象；
   void deleteObject(Object obj,String name);//将对象从文档中删除；
   void createObjectDoc(String name);//创建关联文档

}
