package com.cities.city.entity;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data   @AllArgsConstructor  @NoArgsConstructor @Builder
public class City {
	@NotEmpty
	private String name;
	@Indexed(name = "IdIndex", unique = true)
	@Id
    private String id;
    private String ascii;
    private String alt_name;
    private String lat;
    @Field(name = "long")
    private String longitud;
    private String feat_class;
    private String feat_code;
    private String country;
    private String cc2;
    private String admin1;
    private String admin2;
    private String admin3;
    private String admin4;
    private String population;
    private String elevation;
    private String dem;
    private String tz;
    private String modified_at;

}