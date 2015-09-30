package br.iesb.sie.dao;

import org.hibernate.jdbc.Work;

import javax.enterprise.inject.Model;

@Model
public class WorkDAO extends SimpleDAO {

    public void doWork(Work work) {
        getSession().doWork(work);
    }
}
