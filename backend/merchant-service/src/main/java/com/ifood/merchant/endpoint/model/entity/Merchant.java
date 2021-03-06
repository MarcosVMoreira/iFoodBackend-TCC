package com.ifood.merchant.endpoint.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifood.merchant.endpoint.enumeration.AllowedPaymentEnum;
import com.ifood.merchant.endpoint.enumeration.MerchantTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@Builder
public class Merchant {

    @Id
    private String id;

    private long code;

    @NotEmpty(message = "400.003")
    @Indexed(unique = true)
    private String document;

    @NotEmpty(message = "400.003")
    private String name;

    @NotEmpty(message = "400.003")
    @Indexed(unique = true)
    private String email;

    @NotEmpty(message = "400.003")
    private String logo;

    private String image;

    @NotEmpty(message = "400.003")
    private String phone;

    @NotEmpty(message = "400.003")
    private String country;

    @NotEmpty(message = "400.003")
    private String state;

    @NotEmpty(message = "400.003")
    private String city;

    @NotEmpty(message = "400.003")
    private String neighborhood;

    @NotEmpty(message = "400.003")
    private String streetName;

    @NotEmpty(message = "400.003")
    private String streetNumber;

    @NotEmpty(message = "400.003")
    private String postalCode;

    @NotNull(message = "400.003")
    private boolean availability;

    @NotNull(message = "400.003")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime businessStart;

    @NotNull(message = "400.003")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime businessEnd;

    @NotNull(message = "400.003")
    private List<String> coordinates;

    @NotNull(message = "400.003")
    private Float basePreparationTime;

    private List<AllowedPaymentEnum> allowedPayments;

    private List<Category> categories;

    private List<MerchantTypeEnum> merchantType;

    private Float rate;

    private Integer rateAmount;

    private Float distance;

    private Float fee;

    private Float duration;

    private String description;
}
