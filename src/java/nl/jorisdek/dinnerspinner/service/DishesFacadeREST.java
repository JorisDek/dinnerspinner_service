/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jorisdek.dinnerspinner.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import nl.jorisdek.dinnerspinner.entity.Dishes;

/**
 *
 * @author Gebruiker
 */
@Stateless
@Path("dishes")
public class DishesFacadeREST extends AbstractFacade<Dishes> {
    @PersistenceContext(unitName = "DinnerSpinnerPU")
    private EntityManager em;

    public DishesFacadeREST() {
        super(Dishes.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Dishes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Dishes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }
    
    @GET
    @Path("{gezond}/{goedkoop}/{snel}/{simpel}")
    @Produces({"application/json"})
    public Dishes findRandom(@PathParam("gezond") Boolean gezond, @PathParam("goedkoop") Boolean goedkoop, @PathParam("snel") Boolean snel, @PathParam("simpel") Boolean simpel) {
        return super.findRandom(gezond, goedkoop, snel, simpel);
    }
    

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Dishes find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Dishes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Dishes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
