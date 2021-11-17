package se.iths.exceptionhandling;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BasicResponse {

        public String message;
        public String response;

        public BasicResponse(String response, String message) {
            this.response = response;
            this.message = message;

        }
    }

