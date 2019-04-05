/**
 * Copyright 2019 Ivar Grimstad
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.agiljejava.jwt;

import com.ibm.websphere.security.jwt.Claims;
import com.ibm.websphere.security.jwt.JwtBuilder;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

@Path("/authenticate")
public class LoginResource {

    @POST
    public Response authenticate(@BeanParam UserCredentials userCredentials) throws Exception {

        Set<String> roles = new HashSet<>();
        roles.add("senior");
        String token = buildJwt("duke", roles);

        return Response.ok(token).build();
    }


    private String buildJwt(String userName, Set<String> roles) throws Exception {
        return JwtBuilder.create("jwtFrontEndBuilder")
                .claim(Claims.SUBJECT, userName)
                .claim("upn", userName) // MP-JWT defined subject claim
                .claim("groups", roles.toArray(new String[roles.size()])) // MP-JWT builds an array from this
                .claim("custom-value", "Duke Rocks")
                .buildJwt()
                .compact();
    }
}
