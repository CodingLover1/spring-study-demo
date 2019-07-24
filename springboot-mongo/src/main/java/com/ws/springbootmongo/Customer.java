package com.ws.springbootmongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author shuo.wang
 * @date 19-7-24
 */

@Data
@Document
public class Customer {

    @Id
    private String id;
    private String lastName;
    private String firstName;
}
