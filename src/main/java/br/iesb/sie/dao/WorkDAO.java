package br.iesb.sie.dao;

import javax.enterprise.inject.Model;

import org.hibernate.jdbc.Work;

@Model
public class WorkDAO extends SimpleDAO {

    public void doWork(Work work) {
        getSession().doWork(work);
    }
}
