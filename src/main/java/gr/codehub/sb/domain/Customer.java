package gr.codehub.sb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Customer {

    private static final long MAXIMUM_VISIBLE_CUSTOMER_ID = 999_999L;

    private Long id;
    private String name;
    private String email;
    private Date registrationDate;

    @JsonIgnore
    public boolean isHidden() {
        return id > MAXIMUM_VISIBLE_CUSTOMER_ID;
    }
}
