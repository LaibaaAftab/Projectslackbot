package com.resources;
import com.example.projectslackbot.user;
import com.google.gson.Gson;
import com.example.projectslackbot.reminder;
import com.example.projectslackbot.schedularJava;
import java.util.UUID;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/SlackBot")
public class rcrcs {
    @POST
    @Path("/setReminder")

    public Response postReminder(String payload) throws Exception{

            //JsonObject ob = new JsonObject();
            final user setREm = new Gson().fromJson(payload,user.class);


            if(!reminder.checkObject(setREm)) {
                return Response.status(400).entity("Invalid request").build();
            }

            else
            {
                String message = reminder.getReminder(setREm);
                if(reminder.storeReminder(setREm)==1)
                {

                    schedularJava j = new schedularJava();

                    UUID randomUUID = UUID.randomUUID();
                    String randomStr =  randomUUID.toString().replaceAll("_", "");

                    j.schedularevent(setREm.getMinutes(),randomStr,randomStr,randomStr,randomStr);
                }
                return Response.ok(message).build();
            }
    }
}
