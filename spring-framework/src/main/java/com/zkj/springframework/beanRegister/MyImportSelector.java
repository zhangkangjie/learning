package com.zkj.springframework.beanRegister;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata Import所在类的类信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("导入类 "+importingClassMetadata.getClassName());
        //返回类名数组
        return new String[]{"com.zkj.springframework.beanRegister.Person"};
    }
}
