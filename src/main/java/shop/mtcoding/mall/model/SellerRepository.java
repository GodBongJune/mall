package shop.mtcoding.mall.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class SellerRepository {

    @Autowired
    private EntityManager em;
    @Transactional
    public void save(String name, String email){
        Query query = em.createNativeQuery("insert into seller_tb(name, email) values(:name,:email)");
        query.setParameter("name", name);
        query.setParameter("email", email);
        query.executeUpdate();

    }
}
