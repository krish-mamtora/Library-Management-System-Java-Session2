package com.example.demo.repository.custom;

import com.example.demo.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryCustomImp implements BookRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

            @Override
            public List<Book> findBooksWithAvailability(String title , Boolean available){
                CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                CriteriaQuery<Book> cq = cb.createQuery(Book.class);
                Root<Book> book = cq.from(Book.class);

                List<Predicate>  predicate  = new ArrayList<>();

                if(title!=null){
                    predicate.add(cb.like(book.get("title") , "%" + title + "%"));
                }
                if(available != null){
                    predicate.add(cb.equal(book.get("available") , available));
                }

                return entityManager.createQuery(cq).getResultList();
            }
}
