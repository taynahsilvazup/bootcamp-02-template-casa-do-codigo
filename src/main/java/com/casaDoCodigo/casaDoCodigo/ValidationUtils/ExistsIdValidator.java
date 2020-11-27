package com.casaDoCodigo.casaDoCodigo.ValidationUtils;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o == null) {
            return true;
        }

        Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + " =:value");
        query.setParameter("value", o);
        List<?> list = query.getResultList();

        Assert.isTrue(list.size() <= 1, "Foi encontrado mais de um " + klass + " com o atrubuto " + domainAttribute + " = " + o);

        return !list.isEmpty();
    }
}
