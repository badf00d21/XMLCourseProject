package rest;


import dao.IUserDao;
import database.IDatabaseManager;
import model.User;
import rest.response.TestXML;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces(MediaType.APPLICATION_XML)
public class TestXmlRest {

    @EJB
    IUserDao userDao;

    @GET
    public Object get() {

        try {
            User u = userDao.getUser("qwe");
            u = userDao.getUser("a");
            u = userDao.getUser("c");
            int x = 0;
        }
        catch (Exception e){
            e.printStackTrace();
        }


        TestXML t = new TestXML();

        t.setTestInt(10);
        t.setTestString("Ovo je test");

        return Response
                .status(Response.Status.CREATED)
                .entity(t)
                .build();
    }

}
