package com.angular.rest.webservices.angularweb.service.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    
//    {
//    	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU3NjAzOTI4NywiaWF0IjoxNTc1NDM0NDg3fQ.79ZITSvY71ubOUuj8rrDM4eccYMuLL1-i0YcU4fcmOEzZ532YGkrdLwSpKedQVtOVJFf4KU674IIbOLDww9VyA"
//    	}

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

