package service;

import entity.ProviderEntity;
import org.hibernate.Session;
import utils.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class ProviderService {

    public List<ProviderEntity> getAllProviders() {
        List<ProviderEntity> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM ProviderEntity");
            result = (List<ProviderEntity>) query.getResultList();
        }catch (Exception e){
         System.err.println("Unable to load Providers + \n"+e.toString());
        }finally {
            return result;
        }
    }
}
