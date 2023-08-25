package xyz.msprpayetonkawa.apiwebshop.security.payload.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String email;
    private String lastName;
    private String firstName;
    private String company;
    private String prospect;

}
