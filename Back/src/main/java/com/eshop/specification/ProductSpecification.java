package com.eshop.specification;

import com.eshop.entity.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification {
    public static Specification<Product> buildWhere(String search, Product product){
        Specification<Product> where = null;

        if (!StringUtils.isEmpty(search)) {
            search = search.trim();
            CustomSpecification name = new CustomSpecification("name", search);
            CustomSpecification price = new CustomSpecification("price", search);
            CustomSpecification trademark = new CustomSpecification("trademark", search);
            where = Specification.where(name).or(trademark).or(price);;
        }

        return where;
    }
}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Product>{

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(
            Root<Product> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("name")) {
            return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
        }
        if (field.equalsIgnoreCase("trademark")) {
            return criteriaBuilder.like(root.get("trademark"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("price")) {
            return criteriaBuilder.equal(root.get("price"),  value.toString() );
        }
        return null;
    }
}