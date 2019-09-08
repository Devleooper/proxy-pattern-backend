package co.edu.konradlorenz;

import co.edu.konradlorenz.dto.Data;
import co.edu.konradlorenz.subject.impl.RealVideo;
import co.edu.konradlorenz.subject.impl.VideoProxy;
import com.google.common.base.Strings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class ApiController {


    private VideoProxy videoProxy = new VideoProxy(null);

    @GET
    @Path("/video")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(@QueryParam("name") String videoName, @QueryParam("type") String type) {


        if (!(Strings.isNullOrEmpty(videoName) && Strings.isNullOrEmpty(type))) {
            Data responseData = new Data();
            videoProxy.setVideo(new RealVideo(videoName));

            if (type.equals("min")) {
                responseData.setVideo(videoProxy.loadSampleVideo());
            } else {
                responseData.setVideo(videoProxy.loadFullVideo());
            }

            return Response
                    .status(Response.Status.OK)
                    .header("Access-Control-Allow-Origin", "http://localhost:4200")
                    .entity(responseData)
                    .build();

        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Access-Control-Allow-Origin", "http://localhost:4200")
                    .entity(new Data())
                    .build();

        }


    }
}
