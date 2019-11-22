/**
 * Copyright (c) 2019 Connexta, LLC
 *
 * Released under the GNU Lesser General Public License version 3; see
 * https://www.gnu.org/licenses/lgpl-3.0.html
 */
package com.connexta.search.rest.jaxrscxf;

import com.connexta.search.rest.models.ErrorMessage;
import com.connexta.search.rest.models.Result;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Query API
 *
 * <p>The Query API is defined to provide clients with the ability to query on datasets. 
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface QueryApi  {

    /**
     * Query endpoint for datasets.
     *
     * A system can use the Query endpoint to perform a query on datasets. Results are returned in order from most matched to least matched. 
     *
     */
    @GET
    @Path("/search")
    @Produces({ "application/json" })
    @ApiOperation(value = "Query endpoint for datasets.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The query request was successful. ", response = Result.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "The client message could not understood by the server due to invalid format or syntax. ", response = ErrorMessage.class),
        @ApiResponse(code = 401, message = "The client could not be authenticated. ", response = ErrorMessage.class),
        @ApiResponse(code = 403, message = "The client does not have permission. ", response = ErrorMessage.class),
        @ApiResponse(code = 501, message = "The requested API version is not supported and therefore not implemented. ", response = ErrorMessage.class) })
    public List<Result> query(@QueryParam("q") @NotNull @Pattern(regexp=".*\\S.*") @Size(min=1,max=5000)  String q);
}

